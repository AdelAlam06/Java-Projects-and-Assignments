/*Name: Adel Alam
 * ID: 501293305
 * email: adel.alam@torontomu.ca
 */

import java.util.ArrayList;
import java.util.Collections;

public class StudentManager{

    private ArrayList<Student> students;

    //initalizes a new arraylist to store future students in
    public StudentManager(){
        students = new ArrayList<>();
    }
    
    //adds new students to the arraylist that was initalized
    public void addStudent(Student student) {
        students.add(student);
    }

    //removes students from the arraylist and allows decrements the counter to reflect total students
    public void removeStudent(int i){
        students.remove(students.get(i));
        Person.CounterDecrementor();

    }
    //used to change the gpa of the student. (Option 9 from menu)
    public void replaceStudent(int i, Student s){
        students.set(i, s);
    }
    //used to display all the students in the list
    public void displayStudents() {
        for (Student s : students) {
            System.out.println(students.indexOf(s) + ". " + s.toString());
        }

    }

    //gets the index of a student to display the information of 1 student only
    public int getIndex(Student s){
        return students.indexOf(s);
    }
    //used to get specific students to do comparisons for equal and compareto
    public Student getStudent(int i){
        return students.get(i);
    } 
    //sorts students by gpa lowest to greatest when option 5 is chosen
    public void sortStudentsByGPA() {
        Collections.sort(students);
    }
    
}
