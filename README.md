 Calculator Project
A calculator project developed incrementally, starting with a Java implementation and later to be ported to Arduino C++ to explore expression parsing and embedded systems design.

 Versioning Strategy
Each version is implemented in both Java and Arduino C++. The goal is to preserve identical calculator behavior while porting logic between languages.

---

 Java Versions

 v1.0 — Basic Calculator
- Accepts sequential inputs (number → operator → number) until = is pressed
- Left-to-right evaluation with no operator precedence
- Supports +, -, *, /
- Division by zero handling
- Each operation (addition, subtraction, multiplication, division) implemented as a separate static method

 v1.1 — RPN Calculator
- Accepts a full RPN (Reverse Polish Notation) expression in a single line (e.g., 3 5 2 * +)
- Evaluates using a stack-based algorithm via java.util.Stack
- Supports +, -, *, /
- Division by zero handling
- Error handling for malformed or invalid expressions

 v1.2 — Shunting-Yard Infix Calculator
- Accepts natural infix expressions (e.g., 3 * 2 + 5)
- Converts infix to postfix using the Shunting-Yard algorithm
- Proper operator precedence (* and / before + and -)
- Parenthesis support (e.g., ( 3 + 5 ) * 2)
- Evaluates converted postfix using the v1.1 stack-based RPN evaluator
- Note: tokens must be space-separated

 v1.2.1 — Exponent Operator
- Adds ^ (exponentiation) operator
- Implemented as right-associative (e.g., 2 ^ 3 ^ 2 = 512)
- Use parentheses to force left-to-right (e.g., ( 2 ^ 3 ) ^ 2 = 64)

 v2.0 (Planned)
- TBD

---

 Arduino Versions

 v1.0
- Project scaffold created under arduino/v1/
- Placeholder calculator_serial.ino added for future C++ implementation

 v2.0 (Planned)
- Arduino port mirroring Java v1.2 logic
- Serial input/output for expressions

---

 How to Run

 Java v1.0
1. Compile: javac calculatorProject.java
2. Run: java calculatorProject
3. Enter a value, then follow prompts entering operators and numbers, use = to get the final result

 Java v1.1
1. Compile: javac calculatorProject.java
2. Run: java calculatorProject
3. Enter a full RPN expression when prompted, for example: 3 5 2 * +

 Java v1.2
1. Compile: javac calculatorProject.java
2. Run: java calculatorProject
3. Enter a full infix expression when prompted, for example: 3 * ( 2 + 5 )
4. Note: separate all tokens with spaces

 Java v1.2.1
1. Compile: javac calculatorProject.java
2. Run: java calculatorProject
3. Enter a full infix expression when prompted, for example: 2 ^ 3 ^ 2
4. Note: separate all tokens with spaces

---

 Project Structure
calculatorProject/
- java/v1.0/calculatorProject.java
- java/v1.1/calculatorProject.java
- java/v1.2/calculatorProject.java
- java/v1.2.1/calculatorProject.java
- arduino/v1/calculator_serial.ino
