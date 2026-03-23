# Calculator Project
A calculator project developed incrementally, starting with a Java implementation and later to be ported to Arduino C++ to explore expression parsing and embedded systems design.

## Versioning Strategy
Each version is tracked via git tags. Use `git checkout <tag>` to view any version.

---

## Java Versions

### v1.0 — Basic Calculator
- Accepts sequential inputs (number → operator → number) until `=` is pressed
- Left-to-right evaluation with no operator precedence
- Supports `+`, `-`, `*`, `/`
- Division by zero handling
- Each operation (addition, subtraction, multiplication, division) implemented as a separate static method

### v1.1 — RPN Calculator
- Accepts a full RPN (Reverse Polish Notation) expression in a single line (e.g., `3 5 2 * +`)
- Evaluates using a stack-based algorithm via `java.util.Stack`
- Supports `+`, `-`, `*`, `/`
- Division by zero handling
- Error handling for malformed or invalid expressions

### v1.2 — Shunting-Yard Infix Calculator
- Accepts natural infix expressions (e.g., `3 * 2 + 5`)
- Converts infix to postfix using the Shunting-Yard algorithm
- Proper operator precedence (`*` and `/` before `+` and `-`)
- Parenthesis support (e.g., `( 3 + 5 ) * 2`)
- Evaluates converted postfix using the v1.1 stack-based RPN evaluator
- Note: tokens must be space-separated

### v1.2.1 — Exponent Operator
- Adds `^` (exponentiation) operator
- Implemented as right-associative (e.g., `2 ^ 3 ^ 2 = 512`)
- Use parentheses to force left-to-right (e.g., `( 2 ^ 3 ) ^ 2 = 64`)

### v1.3 — Factorial Operator
- Adds `!` (factorial) as a postfix operator (e.g., `5 !`)
- Supports factorial in larger expressions (e.g., `5 ! + 3 = 123`)
- Error handling for factorial of negative numbers
- Result formatting: whole numbers display without decimal (e.g., `5` instead of `5.0`)
- Precedence map moved to static field for efficiency

### v2.0 (Planned)
- Tokenizer to remove space-separated token requirement
- Unary minus support (e.g., `-3 * 2`)

---

## Arduino Versions

### v1.0
- Project scaffold created under `arduino/v1/`
- Placeholder `calculator_serial.ino` added for future C++ implementation

### v2.0 (Planned)
- Arduino port mirroring Java v1.3 logic
- Serial input/output for expressions

---

## How to Run

### Java (latest — v1.3)
1. Compile: `javac CalculatorProject.java`
2. Run: `java CalculatorProject`
3. Enter a full infix expression when prompted, for example: `5 ! + 3` or `3 * ( 2 + 5 ^ 2 )`
4. Note: separate all tokens with spaces

### Older versions
Use `git checkout <tag>` to switch to a previous version, for example:
```
git checkout v1.0.0
```

---

## Project Structure
```
calculator-project/
├── java/
│   └── CalculatorProject.java
├── arduino/
│   └── v1/
│       └── calculator_serial.ino
├── .gitignore
└── README.md
```
