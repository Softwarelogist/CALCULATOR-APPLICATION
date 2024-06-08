# CALCULATOR-APPLICATION
# Description
This Calculator application is a simple, yet functional tool designed to perform basic arithmetic operations such as addition, subtraction, multiplication, and division. The user interface is built using Java Swing and features a modern dark theme. The background is dark gray, buttons are light black with cyan text, and the display has a dark gray background with green text, inspired by the classic "Neo" style.

# Features
Basic arithmetic operations: addition, subtraction, multiplication, and division.
Clear (Clr) button to reset the display.
Delete (Del) button to remove the last character.
Decimal point support for floating-point arithmetic.
Aesthetic dark-themed user interface with custom colors:
Background: Dark gray
Buttons: Light black with cyan text
Display: Dark gray with green text
# Technologies Used
Java SE
Swing for GUI
# Prerequisites
Java Development Kit (JDK) 8 or above
An IDE such as Eclipse or IntelliJ IDEA for running the application
How to Run
Clone the repository or download the source code.
Open the project in your IDE of choice.
Ensure the JDK is properly set up in your IDE.
Compile and run the Calculator class.
Code Overview
The application is divided into several inner classes for better organization and readability:

# Display: Manages the display screen of the calculator.
NumButtons: Initializes and configures the number buttons (0-9).
Function_Buttons: Initializes and configures the function buttons (+, -, *, /, ., =, Del, Clr).
Panel: Arranges the buttons in a grid layout.
Calculator: The main class that sets up the frame and handles action events.
Customization
You can easily customize the colors and fonts used in the calculator by modifying the values in the respective inner classes. For instance, to change the background color of the buttons, you can update the setBackground method calls in the NumButtons and Function_Buttons classes.
