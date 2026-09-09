/* Problem Description:
 * The Student Management System helps keep track of student information in an organized and efficient
 * way. Instead of manually recording student details like names, ages, IDs, and grades, this program
 * automates the process, making it easier to store, update, and sort student records. It ensures that
 * information is well-structured and easily accessible, reducing the risk of errors and saving time. By
 * allowing students to be sorted by GPA, it also helps with academic tracking, making it useful for schools,
 * teachers, and administrators who need a simple way to manage student data.
 */

/*Name: Adel Alam
 * ID: 501293305
 * email: adel.alam@torontomu.ca
 */
import java.util.Scanner;

public class ProjectOneTester {
    
    public static StudentManager manager = new StudentManager();
    public static Scanner user = new Scanner(System.in);
    public static int age = 0;
    public static double gpa = 0;
    public static String name = "";

    /* NOTE: We didn't learn how to handle edge cases so this program expects to work as intended without testing for cases that 
     * could break it.
     * Edge cases that I found: option 11 does not work if the list is empty, program breaks if you put a double value when prompted
     * for age, and similarly when you input string for age or gpa since age and gpa are parsed to int and double respectively. There
     * could be more as there is no exceptions testing.
     * 
     * Main is responsible for initalizing the first student then taking the user to the main menu to modify their list of 
     * students however they see fit based on the menu options I have accounted for. 
     * 
     * First it runs it through the initalizer() method
     * which is responsible for adding new students that contain a name, gpa, and age. This is used to set the first student before the 
     * main menu appears and is reused to add future students. Additionally initalizer2() method located below initalizer() method 
     * works almost identically as initalizer with the key difference being that initalizer2() does not accept a GPA. Sole purpose of that
     * method is to meet the overloading requirement of this project.
     * 
     * I also used scanner to get users values for the name, age, and gpa and to check what choice they want in the main menu
     * 
     * Summary of all the choices from string options
     * 1. and 2. are responsible for adding new students
     * 3. is responsible for printing all the students info (name + age + GPA) onto console and 4. does the same output but for only 1 student
     * 5. sorts the list of students based on students using compareTo() check in lowest to greatest order
     * 6. 7. 8. prints out individual info to the console based on what I have
     * 9. Changes the GPA of the student once the user provides the specific student they want to modify
     * 10. removes a student entirely from the list
     * 11. displays the total count of students from Person class
     * 12. checks to see if the name on file equals current name. This was the goal however I couldn't get it to work as intended
     * so all it can do is check to see if the name of a student is the same as itself. When compared to other students with the same 
     * name it will return false since they're not the same object even if they share the same name.
     * 13. Compares the GPA of 2 students
     * 14. exits and closes the program
     */
    public static void main(String[] args) throws Exception {
        
        String options = """
                1.  Add a new student
                2.  Add a new student without gpa
                3.  Display all current students and their information
                4.  Display information of 1 student
                5.  Sort by gpa in ascending order
                6.  Get name of the student
                7.  Get age of the student
                8.  Get GPA of the student
                9.  Change GPA of the student
                10. Remove a student
                11. Display total student count
                12. Checks to see if a student's name exists
                13. Compares GPA of 2 students
                14. Exit

                Please select an option by typing in the number of the choice: 
                """;
        
        System.out.println("Welcome to student manager. Please enter proper information as expected or you will be expected to restart");
        
        manager.addStudent(initalizer());
        int choice = 0;
        while(true){
            System.out.println("Here are your following options:");
            System.out.print(options);
            if(user.hasNextInt() == false){
                System.out.println("Enter a valid choice");
                continue;
            }

            choice = user.nextInt();

            if(choice == 1){
                manager.addStudent(initalizer());
            }
            else if(choice == 2){
                manager.addStudent(initalizer2());
            }
            else if(choice == 3){
                System.out.println();
                manager.displayStudents();
                System.out.println();
            }
            else if(choice == 4){
                System.out.println("Which student do you want displayed? Enter the index number as displayed");

                Student display = manager.getStudent(user.nextInt());
                System.out.println(manager.getIndex(display) + ". " + display.toString());
                System.out.println();
            }
            else if(choice == 5){
                manager.sortStudentsByGPA();
                System.out.println("Students are now sorted by their GPA in ascending order");
            }
            else if(choice == 6){
                System.out.println(getStuff(0));
            }
            else if(choice == 7){
                System.out.println(getStuff(1));
            }
            else if(choice == 8){
                System.out.println(getStuff(2));
            }
            else if(choice == 9){
                System.out.println("Which students GPA do you want to change?");
                int index = user.nextInt();
                Student s = manager.getStudent(index);
                System.out.println();
                System.out.println("What do you want the new GPA to be?");
                s.setGPA(user.nextDouble());
                manager.replaceStudent(index, s);
            }
            else if(choice == 10){
                System.out.println("Which student do you want to remove? Please enter the index from the list");
                manager.removeStudent(user.nextInt());
            }
            else if(choice == 11){
                Person.displayTotal();
            }
            else if(choice == 12){
                System.out.println("Please enter the index of the student you want to compare with");
                Student s = manager.getStudent(user.nextInt());
                System.out.println("Please enter the name of the second student");
                Student s2 = manager.getStudent(user.nextInt());
 
                boolean check = s.equals(s2);

                if(check == true){
                    System.out.println("Names of the students match");
                }
                else if(check == false){
                    System.out.println("Names of the students do not match");
                }

            }
            else if(choice == 13){
                System.out.println("Please enter the index of the student you want to compare with");
                Student s = manager.getStudent(user.nextInt());
                System.out.println("Please enter the name of the second student");
                Student s2 = manager.getStudent(user.nextInt());
                int val = s.compareTo(s2);

                if(val < 0){
                    System.out.println(s2.getName() + " has a greater GPA than " + s.getName());
                }
                if(val > 0){
                    System.out.println(s.getName() + " has a greater GPA than " + s2.getName());
                }
                if(val == 0){
                    System.out.println(s.getName() + " has the same GPA as " + s2.getName());
                }
            }
            else if(choice == 14){
                break;
            }
            
        }
        System.out.println("Program is closed");
    }
        
    /* 
     * This is to make my conditions cleaner. Options 6, 7, and 8 are similar in terms of grabbing a student in order to get
     * certain information. Since they all require obtaining the student from the list, this helper function makes my conditional
     * blocks more smaller by eliminating repetitive code.
     */
    public static String getStuff(int i){
        System.out.println("Which student's information did you want?");
        Student s = manager.getStudent(user.nextInt());

        if(i == 0){
            return s.getName();
        }
        else if(i == 1){
            return String.valueOf(s.getAge());
        }
        else if(i == 2){
            return String.valueOf(s.getGPA());
        }


        return null;
    }
    
    //Explained these two with the main explanation
    public static Student initalizer(){

        while (true){
            
            System.out.println("Please enter the student's name: ");
            name = user.next();

            System.out.println("Please enter the age of the student: ");
            age = user.nextInt();

            System.out.println("Please enter the GPA of the student: ");
            gpa = user.nextDouble();

            System.out.println("Student information is added");
            return new Student(name, age, gpa);
        }
        
    }

    public static Student initalizer2(){

        while (true){
            
            System.out.println("Please enter the student's name: ");
            name = user.next();

            System.out.println("Please enter the age of the student: ");
            age = user.nextInt();

            System.out.println("Student information is added");
            return new Student(name, age);
        }
        
    }
}
