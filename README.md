# Console-Based To-Do List Application (Java)

A robust, menu-driven command-line application built in Java that allows users to manage daily tasks. This project demonstrates core Object-Oriented Programming (OOP) principles, efficient data management with collections, and professional input validation.

## 🚀 Features
* Create: Add new tasks with custom titles.
* Read: View a formatted, numbered list of all tasks.
* Update: Mark specific tasks as "Completed" or "Pending."
* Delete: Remove tasks from the list dynamically.
* Crash-Proof Input: Implemented a "Safe Integer" helper method to prevent program crashes from invalid user input (e.g., entering letters instead of numbers).

## 🛠️ Technical Skills Demonstrated
* Encapsulation: Used private fields with getters and setters in a custom `Task` class to protect data integrity.
* ArrayList Management: Utilized `java.util.ArrayList` for dynamic data storage and manipulation.
* Input Handling: Advanced use of `java.util.Scanner` with manual buffer management (solving the `nextInt()`/`nextLine()` skip bug).
* Exception Handling: Implemented logic to handle input mismatches and prevent runtime crashes.
* Method Decoupling: Organized logic into reusable, modular static methods to ensure the `main` method remains clean and readable.

## 📂 Project Structure
* `Task.java`: The blueprint for a task object (Title, Completion Status, and String formatting).
* `ProjectToDo.java`: The main engine containing the application loop, menu logic, and user interaction methods.

   ## 📋 How to Run
1. Ensure you have **JDK 11 or higher** installed.
2. Clone this repository to your local machine.
3. Navigate to the project directory and compile the files:
   ```bash
   javac protodo/*.java
   java protodo.ProjectToDo
   ```
