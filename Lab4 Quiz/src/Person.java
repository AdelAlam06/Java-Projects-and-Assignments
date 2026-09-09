import java.util.ArrayList;

public class Person {
    
    String name = "";
    int age = 0;
    ArrayList <String> courses = new ArrayList<>();

    public Person(String courses, String name, int age){
        this.courses.add(courses);
        this.name = name;
        this.age = age;
    }

    public String getName(){return name;}
    public int getAge(){return age;}
    public ArrayList<String> getCourses(){return courses;}

    public void add(String course){
        courses.add(course);
    }

    public void remove(int index){
        courses.remove(index);
    }



}
