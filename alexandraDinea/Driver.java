import java.util.Arrays;
import java.util.Scanner;

public class Driver {
    public Scanner input = new Scanner(System.in);
    private Course course = this.course;

    public static void main(String[] args) {
        new Driver();
    }
    public Driver() {
        processStudents();
        runMenu();
    }

    private int mainMenu() {
        System.out.print("""
                STUDENT COURSE MENU!
                ---------
                   1) List all students
                   2) List the students currently registered
                   3) List average students mark
                   4) Display students with lowest average mark
                   5) Display students highest average mark
                   6) List student names with their average marks above average marks
                   7) Display a student's average mark
                   8) Deregister a student
                   0) Exit
                ==>>""");
        int option = input.nextInt();
        return option;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "input=" + input +
                ", course=" + course +
                '}';
    }

    private void processStudents() {
        System.out.print("How many students are on the course?");
        int numberStudents =
                input.nextInt();
        course = new Course(numberStudents);
        for (int i = 0; i < numberStudents; i++) {
            addStudent();
        }
    }

    private void addStudent() {
        input.nextLine();
        System.out.print("Enter student name: ");
        String studentName = input.nextLine();
        System.out.print("Enter student number: ");
        int studentNumber = input.nextInt();
        int[] marks = new int[6];
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter mark" + (i + 1) + ": ");
            marks[i] = input.nextInt();
        }
        System.out.print("Is this student currently registered? (Y/N): ");
        char currentStudent = input.next().charAt(0);
        boolean currentlyRegistered = (currentStudent == 'y') || (currentStudent == 'Y');
        boolean isAdded = course.add(new Student(studentName, studentNumber, marks, currentlyRegistered));
        if (isAdded) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("No student added.");
        }
    }

    private void printStudents() {
        System.out.println("List of students:");
        System.out.println(course.listStudents());
    }

    private void printCurrentStudents() {
        System.out.println("List of current students:");
        System.out.println(course.listCurrentStudents());
    }

    private void printStudentsWithAverageMark() {
        double averageMark = course.averageOfStudentsAvgMark();
        if (averageMark != -1) {
            System.out.println("The average student mark is: " + averageMark);
        } else {
            System.out.println("There are no average marks available.");
        }
    }

    private void runMenu() {
        int option = mainMenu();

        while (option != 0) {

            switch (option) {
                case 1 -> printStudents();
                case 2 -> printCurrentStudents();
                case 3 -> printAverageStudentMark();
                case 4 -> printStudentsWithLowestAverageMark();
                case 5 -> printStudentsWithHighestAverageMark();
                case 6 -> printStudentsWithAvgMarksAboveGivenMark();
                case 7 -> printStudentsWithAverageMark();
                case 8 -> deRegisterStudent();
                default -> System.out.println("Invalid option entered: " + option);
            }

            System.out.println("press any key to continue");
            input.nextLine();
            input.nextLine();

            option = mainMenu();
        }

        //the user chose option 0, so exit the program
        System.out.println("Exiting... Goodbye!");
        System.exit(0);
    }

    private void printAverageStudentMark() {
        double averageMark = course.averageOfStudentsAvgMark();
    }

    private void printStudentsWithAvgMarksAboveGivenMark() {
        System.out.print("View the students with average marks above given mark:  ");
        double marks = input.nextDouble();
        System.out.println(course.listStudentsAboveAverageMark(marks));
    }

    private void printStudentsWithLowestAverageMark() {
        Student lowestMark = course.studentWithLowestAverageMark();
        System.out.println("The lowest average mark is:  " + Arrays.toString(lowestMark.getMarks()));
    }

    private void printStudentsWithHighestAverageMark() {
        Student highestMark = course.studentWithHighestAverageMark();
        System.out.println("The highest average mark is:  " + Arrays.toString(highestMark.getMarks()));
    }
    private void deRegisterStudent(){
        System.out.print("Deregister student?");
        int funny = input.nextInt();
        course.deRegisterStudent(funny);
    }

}
