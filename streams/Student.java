import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int marks;
    private String grade;

    public Student(String name, int marks, String grade) {
        this.name = name;
        this.marks = marks;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return name + " - " + marks + " - " + grade;
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Alice", 85, "A"),
                new Student("Bob", 72, "B"),
                new Student("Charlie", 90, "A"),
                new Student("David", 65, "C"),
                new Student("Alice", 85, "A"),
                new Student("Bob", 72, "B"));

        // Group by name and sum marks
        Map<String, Integer> map = students.stream().collect(
                Collectors.groupingBy(Student::getName,
                        Collectors.summingInt(Student::getMarks)));
        
        // Find the student with the highest total marks
        Map.Entry<String, Integer> maxEntry = map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        System.out.println(maxEntry); // Alice=170

        // if simply max marks is needed without addition
        Student maxStudent = students.stream()
                .max(Comparator.comparingInt(Student::getMarks))
                .orElse(null);


        System.out.println(maxStudent); // Charlie - 90 - A


    }

}