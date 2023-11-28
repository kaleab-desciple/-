package sms_updated;
import java.util.Scanner;



class StudentManagementSystem {
    private static final int MAX_STUDENTS = 100;
    private static final int MAX_DEPARTMENTS = 100;
    private static final int MAX_GRADES = 100;
    private static final int MAX_COURSES = 100;


    private static Student[] students = new Student[MAX_STUDENTS];

    private static Department[] deps = new Department[MAX_DEPARTMENTS];
    //    private static courses [] ALL_courses = new courses[MAX_COURSES];
    private static Grade[] grades = new Grade[MAX_GRADES];

    private static Courses[] courses = new Courses[MAX_COURSES];

    private static StudCourse[] sc = new StudCourse[8];



    private static int student_num = 0;
    private static int dep_counter = 0;
    private static int gradeCounter = 0;
    private static int courseCounter = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("********************------------------------------------------------------------*************************************");
        System.out.println("******************---------------------------------------------------------------************************************");
        System.out.println("*************------------------------- [ HARAMAYA UNIVERSITY ] --------------------**********************************");
        System.out.println("****************------ STUDENT REGISTRATION SYSTEM PROGRAM BY ASSIGNMENT --------************************************");
        System.out.println("******************------------------------------------------------------------***************************************");
        System.out.println("********************-------------------------------------------------------******************************************");
        System.out.println("**********************---------------------------------------------------********************************************");
        int choice;
        do {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Add grade ");
            System.out.println("3. add Student department");
            System.out.println("4. add department courses");
            System.out.println("5. Update Student Information");
            System.out.println("6. Delete Student Information");
            System.out.println("7. View Student Information");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ToAddStudent(scanner);
                    break;
                case 2:
                    ToAddGrade(scanner);
                    break;
                case 3:
                    ToAddDepartment(scanner);
                    break;
                case 4:
                    ToAddCourse(scanner);
                    break;
                case 5:
                    ToUpdateStudentInformation(scanner);
                    break;
                case 6:
                    ToDeleteStudentInformation(scanner);
                    break;
                case 7:
                    ToViewStudentInformation(scanner);
                    break;
                case 8:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }

    private static void ToViewStudentInformation(Scanner scanner) {
        {
            System.out.print("Enter student roll to view information: ");
            int rollNumber = scanner.nextInt();

            boolean found = false;
            for (int i = 0; i < student_num; i++) {
                if (students[i].rollNumber == rollNumber) {
                    System.out.println("Students Information:");
                    System.out.println("Name: " + students[i].name);
                    System.out.println("Roll Number: " + students[i].rollNumber);
                }
                // Display Grade
                for (int j = 0; j < gradeCounter; j++) {
                    if (grades[j].rollNumber == rollNumber) {
                        System.out.println("Grade: " + grades[j].grade);
                    }
                }

                // display Department
                for (int j = 0; j < dep_counter; j++) {
                    if (deps[j].rollNumber == rollNumber) {
                        System.out.println("department name: " + deps[j].dep_name);
                        System.out.println("collage : " + deps[j].collage_name);
                    }
                }

                // display courses
                for (int j = 0; j < courseCounter; j++) {
                    if (courses[j].rollNumber == rollNumber) {

                        for (int a = 0; a < sc.length; a++) {
                            System.out.println("course " + (a + 1) + " name: " + courses[j].sc[a].crs_name + ": AND  hour: " + courses[j].sc[a].crs_hour);
                        }
                        System.out.println("=================================================================================================");
                    }
                }
            }
            found = true;

            if (!found) {
                System.out.println("Student not found with roll number: " + rollNumber);
            }
        }
    }

    private static void ToDeleteStudentInformation(Scanner scanner) {

        System.out.print("Enter student roll number to delete information: ");
        int rollNumber = scanner.nextInt();

        boolean found = false;
        for (int i = 0; i < student_num; i++) {
            if (students[i].rollNumber == rollNumber) {
                // Remove the student and related records
                for (int j = i; j < student_num - 1; j++) {
                    students[j] = students[j + 1];
                }
                student_num--;

                // Remove related grades
                for (int j = 0; j < gradeCounter; j++) {
                    if (grades[j].rollNumber == rollNumber) {
                        for (int k = j; k < gradeCounter - 1; k++) {
                            grades[k] = grades[k + 1];
                        }
                        gradeCounter--;
                        break;
                    }
                }

                for (int j = 0; j < dep_counter; j++) {
                    if (deps[j].rollNumber == rollNumber) {
                        for (int k = j; k < dep_counter - 1; k++) {
                            deps[k] = deps[k + 1];
                        }
                        dep_counter--;
                        break;
                    }
                }

                for (int j = 0; j < courseCounter; j++) {
                    if (courses[j].rollNumber == rollNumber) {
                        for (int k = j; k < courseCounter - 1; k++) {
                            courses[k] = courses[k + 1];
                        }
                        courseCounter--;
                        break;
                    }
                }
                found = true;
                System.out.println("Student information deleted successfully!");
                break;
            }
            if (!found) {
                System.out.println("Student not found with roll number: " + rollNumber);
            }
        }
    }


    private static void ToUpdateStudentInformation(Scanner scanner) {

        System.out.print("Enter student roll number to update information: ");
        int rollNumber = scanner.nextInt();

        boolean found = false;
        System.out.print("ReEnter student information: ");
        for (int i = 0; i < student_num; i++) {
            if (students[i].rollNumber == rollNumber) {
                System.out.print("Enter new student name: ");
                String newName = scanner.next();
                students[i].name = newName;

                //******** update the grade **********//
                System.out.print("Enter new student grade: ");
                int newGrade = scanner.nextInt();
                grades[i].grade = newGrade;


            } else {
                System.out.println("course number out of range !!! ");
            }

            found = true;
            System.out.println("Student information updated successfully!");
            break;

    }

        if(!found)

    {
        System.out.println("Student not found with roll number: " + rollNumber);
    }

}


    private static void ToAddGrade(Scanner scanner) {

        if (gradeCounter < MAX_GRADES) {
            System.out.print("Enter student roll number: ");
            int rollNumber = scanner.nextInt();
            System.out.print("Enter student grade (0-4): ");
            double grade = scanner.nextDouble();

            if (grade>=0 && grade <=4){
                grades[gradeCounter] = new Grade(rollNumber, grade);
                System.out.println("Grade added successfully!");
                gradeCounter++;
            }
            else{
                System.out.println("incorrect grade input !!! ");
            }
        }
        else {
            System.out.println("Maximum number of grades reached. Cannot add more.");
        }
    }

    private static void ToAddStudent(Scanner scanner) {
        if (student_num < MAX_STUDENTS) {
            System.out.print("Enter student name: ");
            String name = scanner.next();
            System.out.print("Enter student roll number: ");
            int rollNumber = scanner.nextInt();

            students[student_num] = new Student(name, rollNumber);
            System.out.println("Student added successfully!");
            student_num++;
        } else {
            System.out.println("Maximum number of students reached. Cannot add more.");
        }
    }


    private static void ToAddDepartment(Scanner scanner) {
        if (dep_counter < MAX_DEPARTMENTS) {
            System.out.print("Enter student roll number: ");
            int rollNumber = scanner.nextInt();
            System.out.print("Enter collage name: ");
            String collage_name = scanner.next();
            System.out.print("Enter Department name : ");
            String Dep_name = scanner.next();

            deps[dep_counter] = new Department(rollNumber, collage_name, Dep_name);
            System.out.println("department and courses added successfully!");
            dep_counter++;

        } else {
            System.out.println("Maximum number of students reached. Cannot add more.");
        }
    }


    private static void ToAddCourse(Scanner scanner) {

        if (courseCounter < MAX_COURSES) {
            System.out.print("Enter number of courses : ");
            int subjects = scanner.nextInt();

            StudCourse[] sc = new StudCourse[subjects];
            int rollNumber = 0;
            if (subjects >= 1 && subjects <= 8) {
                System.out.print("Enter student roll number: ");
                rollNumber = scanner.nextInt();


                sc = new StudCourse[subjects];
                String crs_name = null;
                int crs_hour = 0;
                for (int x = 0; x < subjects; x++) {
                    System.out.print("Enter course " + (x + 1) + " name: ");
                    crs_name = scanner.next();
                    System.out.print("Enter course " + (x + 1) + " hour: ");
                    crs_hour = scanner.nextInt();
                    sc[x] = new StudCourse(crs_name, crs_hour);
                }

            } else {
                System.out.println("course number out of range !!! ");
            }

            courses[courseCounter] = new Courses(rollNumber, sc);
            System.out.println("courses added successfully!");
            courseCounter++;
        } else {
            System.out.println("maximum number of courses reached. Cannot add more");
        }

    }
}
