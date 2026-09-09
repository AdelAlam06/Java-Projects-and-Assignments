public class App {
    public static void main(String[] args) throws Exception {
        Student s = new Student("CPS209", "Ade", 18);
        System.out.println(s.getAge());
        System.out.println(s.getName());
        System.out.println(s.getCourses());
        s.add("CPS213");
        System.out.println(s.getCourses());
}   }
