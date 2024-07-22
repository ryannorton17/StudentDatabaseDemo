import java.util.Scanner;

import static java.lang.Math.round;

public class Student {

    // Necessary Variables
    private String firstName;
    private String lastName;
    private int grade;
    private static int baseID = 1000; // a static base number for id's standardizes student ID formatting.
    private String studentID;
    private String courses = "";
    private double balance; // balance is a double to allow for using cents when making payments
    private final int cost = 250; // cost is final because tuition is a fixed amount per course.

    // Constructor to prompt user to enter student's name and year
    public Student() {
        // import scanner to read user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + "Please enter student information:");
        System.out.println("First Name:");
        this.firstName = scanner.nextLine();
        System.out.println("Last Name:");
        this.lastName = scanner.nextLine();
        // provide options for grade level, using an Int reduces errors in user input
        System.out.println("Please enter the number of " + this.firstName + "'s Grade Level: \n" +
                "9. Freshman \n" +
                "10. Sophmore \n" +
                "11. Junior \n" +
                "12. Senior");
        this.grade = scanner.nextInt();
        setStudentID(); // calls method below to generate ID based on provided information + static class information
        System.out.println("You entered: " + this.firstName + " " + this.lastName + ", Grade: " + this.grade);
        System.out.println(this.firstName + "'s Student ID is: " + this.studentID);
    }

    // Method to generate student ID for each Student | First number needs to reflect grade level
    private String setStudentID() {
        baseID++;
        this.studentID = grade + "-" + baseID;
        return this.studentID;
    }

    // Method to enroll in courses
    public void enroll() {
        // Enrollment loop, user will use the 0 key to exit the loop.
        do {
            System.out.println("Please enter a course to enroll. When finished, press 'Q'.");
            Scanner enrollScanner = new Scanner(System.in);
            String course = enrollScanner.nextLine();
            if (!course.equals("Q")) { // As long as Q is not entered, enrollment will continue.
                courses = courses + "\n" + course;
                balance = balance + cost; // increment tuition cost with each enrollment
                System.out.println("ENROLLED IN: " + courses);
                System.out.println("CURRENT TUITION BALANCE: " + balance);
            } else {break;} // if Q is entered, loop breaks
        } while (1 != 0); // the break parameter is within the loop, so the while parameter remains infinite.
        System.out.println("YOU ARE ENROLLED IN: " + courses);
        System.out.println("FINAL TUITION BALANCE: " + balance);
    }

    // need to view balance and pay tuition

    // Method to View
    public void viewBalance() {
        System.out.println("Your remaining balance is : $" + balance);
    }

    // Method to Pay
    public void payBalance() {
        System.out.println("Please enter an amount to pay.");
        Scanner scannerPayment = new Scanner(System.in);
        double payment = scannerPayment.nextDouble();
        balance = balance - payment;
        System.out.println("Thank you for your payment of " + payment + ".");
        viewBalance();
    }

    // Show Student information
    public String showInfo() {
        return "\nSTUDENT INFORMATION: "
                + "\nStudent ID: " + studentID
                + "\nName: " + firstName + " " + lastName
                + "\nGrade: " + grade
            + "\nCourses Enrolled: " + courses
            + "\nBalance " + balance;
    }

    // need to create a getStatus() method to show current status of student
}
