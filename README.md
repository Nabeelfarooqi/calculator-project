 Calculator Project

A calculator project developed incrementally, starting with a Java implementation and later to be ported to Arduino C++ to explore expression parsing and embedded systems design.

Versioning Strategy

Each version is implemented in both Java and Arduino C++. The goal is to preserve identical calculator behavior while porting logic between languages.

Java Versions

v1.0 — Basic Calculator
	∙ 	Accepts sequential inputs (number → operator → number) until = is pressed
	∙	Left-to-right evaluation with no operator precedence
	∙	Supports +, -, *, /
	∙	Division by zero handling
	∙	Each operation (addition, subtraction, multiplication, division) implemented as a separate static method





v1.1 — RPN Calculator
	∙	Accepts a full RPN (Reverse Polish Notation) expression in a single line (e.g., 3 5 2 * +)
	∙	Evaluates using a stack-based algorithm via java.util.Stack
	∙	Supports +, -, *, /
	∙	Division by zero handling
	∙	Error handling for malformed or invalid expressions





v2.0 (Planned)
	∙	Infix expression support with proper operator precedence (* and / before + and -)
	∙	Implemented using the Shunting-Yard algorithm
	∙	Will accept natural math expressions (e.g., 3 + 5 * 2)

Arduino Versions

v1.0
	∙	Project scaffold created under arduino/v1/
	∙	Placeholder calculator_serial.ino added for future C++ implementation

v2.0 (Planned)
	∙	Arduino port mirroring Java v2.0 logic
	∙	Serial input/output for expressions

How to Run

Java v1.0
	1.	Compile: java calculatorProject.java
	2.	Run: java calculatorProject
	3.	Enter a value, then follow prompts entering operators and numbers, use = to get the final result





Java v1.1
	1.	Compile: java calculatorProject.java
	2.	Run: java calculatorProject
	3.	Enter a full RPN expression when prompted, for example: 3 5 2 * +
