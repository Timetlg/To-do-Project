package protodo;

import java.util.ArrayList;
import java.util.Scanner;

public class ProjectToDo {
    //test

    /*
    - adds new tasks by scanning for user input
    - adds task to list created in main
     */
    private static void addNewTask(Scanner scan, ArrayList<Task> list) {

        System.out.println("\nEnter New Task");

        // add task name to string
        String title = scan.nextLine();

        // Create a new task
        Task newTask = new Task(title);
        // Add new task to task list
        list.add(newTask);

        System.out.println("\nTask Added");
        printList(list);

    }

    /*
    - print the dashboard of total and completed tasks using
    .stream to get each item
    .filter to get all the completed tasks
    .count to count each of the completed tasks
    - prints the menu
     */
    private static void printMenu(ArrayList<Task> list) {
        
        // count the number of completed tasks using .stream
        long completedTasks = list.stream().filter(Task::isCompleted).count();
        int totalCount = list.size();
        
        System.out.println("\n--- Dashboard ---");
        System.out.println("Total Tasks: " +  totalCount + " | Completed: " + completedTasks);
        
        // menu
        System.out.println("\nMenu \n"
                + "1. Add New Task \n"
                + "2. Mark Completed\n"
                + "3. Delete Task\n"
                + "4. View Task List \n"
                + "5. Clear Completed Tasks\n"
                + "6. Exit");
    }

    /*
    - prints the to-do list
    - using a for loop to iterate through each task
     */
    private static void printList(ArrayList<Task> list) {

        System.out.println("\n-----TO-Do LIST-----");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
        System.out.println("--------------------");
    }

    /*
    - method to mark tasks as completed
    - checks for empty list and valid number selection
     */
    private static void markTaskCompleted(Scanner scan, ArrayList<Task> list) {

        // Check if the list is empty
        if (list.isEmpty()) {
            System.out.println("\nList is Empty \nNothing to Mark");
            return;
            // since there isn't an else statement return is used
        }

        System.out.println("\nWhich task have you completed?");

        printList(list);

        // get the task to mark and subtract 1 
        int taskNum = getInt(scan) - 1;

        // if selected num is within range it sets the task to completed
        if (taskNum >= 0 && taskNum < list.size()) {
            list.get(taskNum).setCompleted(true);
            System.out.println("\nTask Completed!");
        } else {
            System.out.println("\nInvalid Task Number");
        }
    }

    /*
    - method to delete tasks
    - checks for empty list and valid number selection
     */
    private static void deleteTask(Scanner scan, ArrayList<Task> list) {

        // check if the list is empty
        if (list.isEmpty()) {
            System.out.println("\nList is Empty!");
            return;
        }

        System.out.println("\nSelect a task to Delete");
        printList(list);

        // if selected num is within range it will remove the item
        int choice = getInt(scan) - 1;
        if (choice >= 0 && choice < list.size()) {

            list.remove(choice);

            System.out.println("\nItem has been Removed");
        } else {
            System.out.println("\nInvalid Number! Choose within range");
        }
    }

    private static void clearCompleted(Scanner scan, ArrayList<Task> list) {

        if (list.isEmpty()) {
            System.out.println("\nList is already empty");
            return;
        }

        System.out.println("\nAre you sure you want to clear all completed tasks? (y/n)");
        String response = scan.nextLine().toLowerCase();

        if (response.equals("y")) {
            list.removeIf(task -> task.isCompleted());
            System.out.println("\nCompleted! Tasks Cleared!");
        } else {
            System.out.println("\nAction Cancelled");
        }
    }

    /**
     * - constantly prompts for input until a valid integer is provided -
     * handles exceptions to prevent program crashes on non-numeric input - uses
     * a scanner to read input - the return will be the valid integer entered by
     * user
     *
     */
    private static int getInt(Scanner scan) {

        while (true) {
            try {
                int value = scan.nextInt();
                scan.nextLine();
                return value;
            } catch (Exception e) {
                System.out.println("\nError: Please Enter a Valid Number");
                scan.nextLine();
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Task> taskList = new ArrayList<>();
        Scanner myScan = new Scanner(System.in);

        boolean running = true;

        // while loop that keeps running until user chooses to "exit"
        while (running) {

            printMenu(taskList);

            int choice = getInt(myScan);

            // switch/case uses what the user chose to perform that method
            switch (choice) {
                default:
                    System.out.println("\nInvalid number! Please choose within range");
                    break;

                case 1: // Adding a new task
                    addNewTask(myScan, taskList);
                    break;

                case 2: // Marking task list
                    markTaskCompleted(myScan, taskList);
                    printList(taskList);
                    break;

                case 3: // Deleting an item from list
                    deleteTask(myScan, taskList);
                    printList(taskList);
                    break;

                case 4: //Viewing task list
                    printList(taskList);
                    break;

                case 5: // Clearing completed tasks
                    clearCompleted(myScan, taskList);
                    printList(taskList);
                    break;

                case 6: // Exit
                    running = false;
                    break;
            }
        }
    }
}
