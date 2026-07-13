# DSA Learning Repository

**Purpose:** Personal workspace for learning and practicing Data Structures & Algorithms (DSA) in Java.

**Contents & Structure**

- **Root:** topic folders and exercises.
- **Labs:** [Lab1](Lab1) … [Lab10](Lab10) — lab exercises and implementations.
- **Exercises:** various practice folders such as [term_project](term_project), and [StackAndQueue](StackAndQueue).
- **Sortings:** [sortings](sortings) — sorting algorithm implementations.

**How to Build**

- Compile a single source file (PowerShell):

```
javac -d Lab1/bin Lab1/src/Fraction.java
```

- Compile all sources in a folder (PowerShell):

```
javac -d Lab1/bin Lab1/src/*.java
```

Adjust `Lab1` to the target lab folder you want to build.

**How to Run**

- Run a class with `main` (PowerShell):

```
java -cp Lab1/bin Test
```

Replace `Lab1/bin` and `Test` with the compiled output directory and the class name you want to run.

**Style & Tips**

- Use descriptive, lowerCamelCase names for methods/variables (`precedence`, `capacity`, `prevNode`).
- Prefer generics (e.g., `Comparator<Student>`) to avoid casts.
- Check edge cases (nulls, empty structures) in data-structure code.
- Keep small `main` test classes next to implementations for quick verification.

**Common Git Workflow**

- Commit small, focused changes with descriptive messages.
- Use `git reset` or `git rebase -i` to edit local history; avoid force-pushing to shared branches.

**Next Steps I Can Help With**

- Rename identifiers across the workspace (e.g., `capity` → `capacity`).
- Run a compile and fix build errors.
- Add example `run` scripts or an aggregated build script.

---

Created for personal DSA practice. Happy coding!
