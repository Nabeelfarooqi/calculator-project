# Calculator Project
Calculator project developed incrementally, starting with a Java implementation and later ported to Arduino C++ to explore expression parsing and embedded systems design.

## Versioning Strategy
Each version is implemented in both Java and Arduino C++.
The goal is to preserve identical calculator behavior while porting logic between languages.

### Java Versions

#### v1.0
- Left-to-right evaluation
- Supports +, -, *, /
- No operator precedence (PEMDAS not implemented)

#### v2.0 (Planned)
- Java calculator with operator precedence (* and / before + and -)

### Arduino Versions

#### v1.0
- Folder `arduino/v1/` created
- Empty `calculator_serial.ino` added as a placeholder
- Prepares repository for future Arduino C++ implementation

#### v2.0 (Planned)
- Arduino port mirroring Java v2 logic
- Uses Serial input/output for expressions

## How to Run Java v1
1. Compile the Java file
2. Run the program
3. Enter numbers and operators interactively in the console. Use `=` to see the final result.
