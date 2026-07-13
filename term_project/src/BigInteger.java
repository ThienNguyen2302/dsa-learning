import java.util.ArrayList;

public class BigInteger {
    private DigitList digits;
    private int sign;

    public BigInteger() {
        this.digits = null;
        this.sign = 1;
    }

    public BigInteger(DigitList L) {
        this.digits = L;
        this.sign = 1;
    }

    public BigInteger(int i, DigitList L) {
        this.digits = L;
        this.sign = sgn(i);
    }

    public BigInteger(int i) {
        this.digits = DigitList.digitize(Math.abs(i));
        this.sign = sgn(i);
    }

    public BigInteger(String str) {
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            this.digits = DigitList.digitize(str);
            this.sign = -1;
        } else {
            this.digits = DigitList.digitize(str);
            this.sign = 1;
        }
    }

    public DigitList getDigits() {
        return this.digits;
    }

    public int getSign() {
        return this.sign;
    }

    public void setDigits(DigitList digits) {
        this.digits = digits;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    private int sgn(int i) {
        if (i < 0)
            return -1;
        else
            return 1;
    }

    public int length() {
        if (this.digits == null)
            return 0;
        else
            return this.digits.length();
    }

    public BigInteger copy() {
        if (this.digits == null)
            return new BigInteger(0);
        else
            return new BigInteger(this.sign, this.digits.copy());
    }

    public BigInteger trimDigit() {
        return new BigInteger(this.sign, DigitList.trimDigitList(this.digits));
    }

    public boolean equals(Object obj) {
        if (obj instanceof BigInteger) {
            BigInteger other = (BigInteger) obj;
            if (this.sign == other.sign && DigitList.compareDigitLists(this.digits, other.digits) == 0) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        if (this.digits != null) {
            String integer = "";
            DigitList tmp = this.digits;
            integer = tmp.getDigit() + integer;
            tmp = tmp.getNextDigit();
            while (tmp != null) {
                integer = tmp.getDigit() + integer;
                tmp = tmp.getNextDigit();
            }
            return ((this.sign == -1) ? "-" : "") + integer;
        } else
            return "";
    }

    public BigInteger leftDigits(int n) {
        return new BigInteger(this.digits.leftDigits(n));
    }

    public BigInteger rightDigits(int n) {
        return new BigInteger(this.digits.rightDigits(n));
    }

    public BigInteger shift(int n) {
        if (n < 1)
            return this;
        else {
            BigInteger clone = this.copy();
            clone.digits = new DigitList(0, clone.digits);
            return clone.shift(n - 1);
        }
    }

    /********************************
     * STUDENT'S CODE
     ********************************/

    public BigInteger add(BigInteger other) {
        if (this.sign == other.sign)
            return new BigInteger(this.sign, DigitList.addDigitLists(0, this.digits, other.digits));
        else if (this.digits.compareDigitLists(this.digits, other.getDigits()) == -1) {
            return new BigInteger(other.getSign(), DigitList.subDigitLists(0, this.digits, other.digits));
        } else
            return new BigInteger(this.sign, DigitList.subDigitLists(0, this.digits, other.digits));
    }

    public BigInteger sub(BigInteger other) {
        if (this.sign != other.sign)
            return new BigInteger(this.sign, DigitList.addDigitLists(0, this.digits, other.digits));
        else if (this.digits.compareDigitLists(this.digits, other.getDigits()) == -1) {
            return new BigInteger((-1) * this.sign, DigitList.subDigitLists(0, this.digits, other.digits));
        } else
            return new BigInteger(this.sign, DigitList.subDigitLists(0, this.digits, other.digits));
    }

    public BigInteger mul(BigInteger other) {
        // code here
        DigitList tmp = this.digits;
        while (this.length() < other.length()) {
            while (tmp.getNextDigit() != null) {
                tmp = tmp.getNextDigit();
            }
            tmp.setNextDigit(new DigitList(0, null));
        }
        while (this.length() > other.length()) {
            tmp = other.digits;
            while (tmp.getNextDigit() != null)
                tmp = tmp.getNextDigit();
            tmp.setNextDigit(new DigitList(0, null));
        }
        int sig;
        if (this.sign != other.sign)
            sig = -1;
        else
            sig = 1;
        if (this.length() == 1 || other.length() == 1)
            return new BigInteger(DigitList.digitize(this.digits.getDigit() * other.getDigits().getDigit()));
        int n = this.length() / 2;
        BigInteger xleft = new BigInteger(this.sign, this.digits.leftDigits(n));
        BigInteger xright = new BigInteger(this.sign, this.digits.rightDigits(this.length() - n));
        BigInteger yleft = new BigInteger(other.sign, other.digits.leftDigits(n));
        BigInteger yright = new BigInteger(other.sign, other.digits.rightDigits(other.length() - n));
        BigInteger xyleft = xleft.mul(yleft);
        BigInteger xy = xright.mul(yleft).add(xleft.mul(yright)).shift(n);
        BigInteger xyright = xright.mul(yright).shift(2 * n);
        return new BigInteger(sig, DigitList.trimDigitList(xyleft.getDigits().addDigitLists(0, xyleft.getDigits(),
                xyright.getDigits().addDigitLists(0, xyright.getDigits(), xy.getDigits()))));
    }

    public static BigInteger pow(BigInteger X, BigInteger Y) {
        // code here
        DigitList tmp = new DigitList();
        if (Y.digits.compareDigitLists(Y.digits, tmp) == 0)
            return new BigInteger(1);
        Y.digits = Y.digits.subDigitLists(1, Y.digits, tmp);
        return new BigInteger(X.sign, X.mul(pow(X, Y)).digits);
    }

    public static BigInteger factorial(BigInteger X) {
        // code here
        int sign = X.sign;
        X.setSign(1);
        if (X.equals(new BigInteger(1)))
            return new BigInteger(1);
        return new BigInteger(DigitList.trimDigitList(X.mul(factorial(X.sub(new BigInteger(1)))).digits));
    }

    public static BigInteger computeValue(ArrayList<BigInteger> operandArr, ArrayList<Character> operatorArr) {
        // complete - and * operator
        BigInteger output = operandArr.get(0);
        for (int j = 0; j < operatorArr.size(); j++) {
            switch (operatorArr.get(j)) {
                case '+':
                    output = output.add(operandArr.get(j + 1));
                    break;
                case '-':
                    output = output.sub(operandArr.get(j + 1));
                    break;
                case '*':
                    output = output.mul(operandArr.get(j + 1));
                    break;
                default:
                    break;
            }
        }
        return output;
    }
}