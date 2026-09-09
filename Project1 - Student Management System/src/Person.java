/*Name: Adel Alam
 * ID: 501293305
 * email: adel.alam@torontomu.ca
 */
public class Person {
    private String name;
    private int age;
    private static int studentCount = 0; 
    // Parent class
    // constructor that gets values from student when student constructor is initalized. Student counter keeps record of how many students are created
    //stores name and age in this class
    public Person(String name, int age){
        this.name = name;
        this.age = age;
        studentCount++;
    }

    //these 2 returns name and age of the student respectively when a certain student is indexed
    public String getName(){ 
        return name; 
    }
    public int getAge(){ 
        return age; 
    }

    //this is used with the toString in student class to return the information of the students in string format
    public String toString() {
        return  "Name: " + name + ", Age: " + age;
    }
    
    //this displays total amount of students to console
    public static void displayTotal(){
        System.out.println(studentCount);
    }
    //this decrements the student counter if the student is removed from the list
    public static void CounterDecrementor(){
        studentCount--;
    }

}
