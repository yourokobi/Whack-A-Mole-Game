# JAVA GUI MINI APPS

## DESCRIPTION
A collection of beginner-friendly Java GUI applications built with Swing and AWT. Includes a Whack-a-Mole game that gets faster as you level up, and interactive button demos to showcase event handling.

## FEATURES
- Whack-a-Mole game with increasing difficulty
- Basic button interaction demos using Swing and AWT
- Reusable close button utility
- Clean, simple UIs for learning and experimentation

## HOW TO RUN
1. Make sure Java is installed on your system
2. Compile all Java files: `javac *.java`
3. Run any application:
   - `java WhackAMole`
   - `java ButtonInteraction`
   - `java MultiButtonSomething`
4. For Whack-a-Mole, ensure `mole.png` and `boom.png` are in the same directory

## PROJECT STRUCTURE
- WhackAMole.java – Reflex game with scoring and levels
- ButtonInteraction.java – Swing demo with simple button dialogs
- MultiButtonSomething.java – AWT app with custom button listeners
- CloseButton.java – Utility to add a "Close" button to Swing panels

## DESIGN NOTES
This project is designed for educational use, showcasing Java GUI basics like:
- Layouts and panels
- Action listeners
- Dialog boxes
- Timers and game logic

## REQUIREMENTS
- Java 8 or higher
- `mole.png` and `boom.png` image files for the game

## FUTURE IMPROVEMENTS
- Add sound effects to Whack-a-Mole
- Replace AWT with Swing in all apps for consistency
- Score history and high score tracking
- Better image/resource management
