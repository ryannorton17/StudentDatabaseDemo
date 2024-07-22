import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        // Ask how many new users to add.
//        Student student1 = new Student();
//        student1.enroll();
//        student1.payBalance(); // input is adjusted in method
//        System.out.println(student1.showInfo());

        // Define how many students we are looking to enroll
        System.out.println("Enter number of Students to enroll");
        Scanner scanner = new Scanner(System.in);
        int numOfStudents = scanner.nextInt();
        // assemble Array to recieve new Student information
        Student[] student = new Student[numOfStudents];

        // Loop through new student list
        for (int i = 0; i < numOfStudents; i++) {
            student[i] =  new Student();
            student[i].enroll();
            student[i].payBalance(); // input is adjusted in method
            System.out.println(student[i].showInfo());

        }
    }
}

/* Application Objectives
    1. Ask the user how many students to add to database
    2. prompt user to enter name and year for each student
    3. Student should have a unique ID with the first number reflecting their grade level
    4. Students should be able to enroll in courses.
     5. There should be a per course tuition of $250.
     6. Student should be able to retrieve their balance and pay tuition.
     7. The admin should be able to view the following characteristics of each student:
        - Student ID
        - Courses
        - Current Balance Due

 */
