# Simple Calculator App

A simple Android calculator application built with Kotlin that performs basic mathematical operations while demonstrating core Object-Oriented Programming (OOP) concepts.

## Features

- **Four Basic Operations**: Addition, Subtraction, Multiplication, and Division.
- **OOP Implementation**: Utilizes classes, objects, constructors, and enum classes.
- **Smart Result Display**: Formats output to remove unnecessary trailing zeros for whole numbers.
- **Error Handling**: 
    - Validates empty input fields.
    - Prevents calculation without selecting an operation.
    - Gracefully handles division by zero.
- **User Interface**: Clean layout using `EditText` for inputs, `RadioGroup` for operation selection, and a dedicated `=` button to calculate.

## OOP Concepts Used

- **Class**: The `Calculator` class encapsulates the calculation logic.
- **Object**: Instances of the `Calculator` class are created dynamically during the app's execution.
- **Constructor**: A primary constructor is used to initialize the operands.
- **Enum Class**: The `Operations` enum defines the supported mathematical operations (`ADD`, `SUBTRACT`, `MULTIPLY`, `DIVIDE`).

## Technical Stack

- **Language**: Kotlin
- **IDE**: Android Studio
- **Framework**: Android SDK (AppCompat, ConstraintLayout)

## How to Use

1. Enter the first number in the "Enter first number" field.
2. Enter the second number in the "Enter second number" field.
3. Select an operation (Add, Subtract, Multiply, or Divide) from the radio buttons.
4. Click the **"="** button.
5. The result will be displayed at the bottom.

## Project Structure

- `MainActivity.kt`: Handles the UI logic and user interactions.
- `Calculator.kt`: Contains the core mathematical logic and the `Operations` enum.
- `activity_main.xml`: Defines the user interface layout.
- `strings.xml`: Centralized string resources for the application.
