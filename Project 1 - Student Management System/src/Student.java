/*Name: Adel Alam
 * ID: 501293305
 * email: adel.alam@torontomu.ca
 */
public class Student extends Person implements Comparable<Student>{
    

    private double gpa;

    //constructor that supers the name and age of the student to the person class
    //stores the gpa in this class
    public Student(String name, int age, double gpa) {
        super(name, age);
    
        this.gpa = gpa;
    }

    // Overloaded constructor for when there is no gpa required
    public Student(String name, int age) {
        super(name, age);
        this.gpa = 0.0;
    }

    //returns the gpa of a particular student when requested
    public double getGPA() {
         return gpa; 
    }

    //sets the gpa of a particular student when requested
    //useful when changing the gpa because if a student is added without a gpa or if user wants to change a gpa this 
    //can change the gpa
    public void setGPA(double gpa) { 
        this.gpa = gpa; 
    }

    //returns the string to be inputted to the console
    @Override
    public String toString() {
        return super.toString() + ", GPA: " + gpa;
    }

    //compares the name of a student to another to make sure they aren't the same
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) {
           return false;
        }

        Student other = (Student) obj;
        return this.getName() == other.getName();
    }

    //compares GPAs of 2 students
    @Override
    public int compareTo(Student other) {
        if(this.gpa > other.gpa){
            return 1;
        }
        else if(this.gpa < other.gpa){
            return -1;
        }
            return 0;    
    }
}
