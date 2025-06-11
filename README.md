# Drum Test GUI Application

A simple graphical Java Swing application that displays a custom Drum Panel. Useful for testing and demonstrating GUI functionality in Java using custom panels and themes.

---

## Description

This project launches a Java Swing-based application that showcases a `DrumPanel` (from the `graphicalInterface` package). The project is intended for testing and demoing GUI components with a custom look and feel (Metal OceanTheme). It’s a great example for beginners and intermediate Java developers working with `JPanel`, `JFrame`, and event dispatch thread concepts.

---

## Getting Started

### Dependencies

- Java Development Kit (JDK 8 or later)
- Operating System: Windows 10, macOS, or Linux
- No third-party libraries required — uses only standard Java libraries (`javax.swing`, `java.awt`)

---

### Installing

1. Clone the repository:
   ```bash
   git clone https://github.com/HarpreetComputerEng/Drum-Test.git
Navigate to the project directory:

bash
Copy
Edit
cd Drum-Test
Ensure your directory structure looks like this:

bash
Copy
Edit
Drum-Test/
├── src/
│   ├── test/Drum_Test.java
│   └── graphicalInterface/DrumPanel.java
└── README.md
Executing program
To compile and run the program from terminal:

bash
Copy
Edit
javac -d out src/test/Drum_Test.java src/graphicalInterface/DrumPanel.java
java -cp out test.Drum_Test
If you're using an IDE like IntelliJ or Eclipse:

Import the project as a Java project

Set the main class to test.Drum_Test

Run the application

Help
Make sure the DrumPanel.java file is present and properly compiled.

If GUI doesn’t launch, ensure the code is run from the Event Dispatch Thread (already handled in this example).

Look and Feel errors may occur on unsupported platforms — stick to Metal for maximum compatibility.

If your program includes a help command, you could use:

bash
Copy
Edit
java -cp out test.Drum_Test --help
(Note: This program doesn’t currently implement command-line arguments.)

Authors
Harpreet Singh
📧 harp0183@algonquinlive.com
👨‍🎓 Computer Engineering Student, Algonquin College
💻 Programming Club Member

Version History
0.2

Minor UI adjustments

Look & feel setup added

See commit history for changes

0.1

Initial Release

Basic GUI display with DrumPanel

License
This project is licensed under the MIT License - see the LICENSE.md file for details.

Acknowledgments
DrumPanel GUI concept from coursework/inspiration

awesome-readme

PurpleBooth

fvcproductions

Java Swing community & Oracle documentation

yaml
Copy
Edit

---


