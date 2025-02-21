package Collections.ComparatorDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// // class StringLengthComparator implements Comparator<String> {

//     @Override
//     public int compare(String s1, String s2) {
//         // For ascending order of length:
//         // return s1.length() - s2.length();

//         // For descending order of length:
//          return s2.length() - s1.length(); // Corrected for descending
//     }
// }

class Student {

    private String name;

    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;

    }

    public String getName() {
        return name;
    };

    public double getGpa() {
        return gpa;
    };

    // Override toString() to print name and GPA
    @Override
    public String toString() {
        return "Student{name='" + name + "', gpa=" + gpa + '}';
    }

}

public class Comparators {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("banana", "apple", "date", "grape");
        System.out.println("Original list: " + words);

        // Natural sort (alphabetical):
        Collections.sort(words); // or words.sort(null); Both do the same thing
        System.out.println("Natural sort: " + words);

        // Sort by length (descending):
        // words.sort(new StringLengthComparator());
        // System.out.println("Sorted by length (descending): " + words);

        /*
         * while implementing through lambda expression above StringLengthComparator
         * class isn't required.
         */

        // Example of using a lambda expression for sorting:
        words.sort((s1, s2) -> s1.length() - s2.length()); // Ascending length
        System.out.println("Sorted by length (ascending using lambda): " + words);

        // Example of using a lambda expression for sorting:
        words.sort((s1, s2) -> s2.length() - s1.length());
        System.out.println("Sorted by length (descending using lambda): " + words);

        // Descending length using lambda and Comparator.comparingInt
        words.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println("Sorted by length (descending using lambda and Comparator.comparingInt): " + words);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Charlie", 3.5));
        students.add(new Student("Bob", 3.7));
        students.add(new Student("Alice", 3.5));
        students.add(new Student("Akshit", 3.9));
        // list.sort(null);

        System.out.println(students);

        Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);
        students.sort(comparator);
        for (Student s : students) {
            System.out.println(s.getName() + ": " + s.getGpa());
        }
        //Above 2 lines are doing the same thing as below code
        //.reversed(): doing it in descending order
        //.thencomparing is used the to sort between alice and charlie as they both have same gpa.
        students.sort((o1, o2) -> {
            if (o2.getGpa() - o1.getGpa() > 0) {
                return 1;
            } else if (o2.getGpa() - o1.getGpa() < 0) {
                return -1;
            } else {
                return o2.getName().compareTo(o1.getName());
            }
        });
        for (Student s : students) {
            System.out.println(s.getName() + ": " + s.getGpa());
        }
    }
}

/*
 * 
 * [Collections.Student@2f2c9b19, Collections.Student@31befd9f,
 * Collections.Student@1c20c684, Collections.Student@1fb3ebeb]
 * 
 * Above output is the default string representation of the Student objects in
 * the list. By
 * default, Java uses the toString() method from the Object class, which prints
 * the class name and the memory address (hash code) of the object.
 * 
 * To print the actual data (i.e., the student's name and GPA), you need to
 * override the toString() method in your Student class.
 * 
 * Step 1: Override the toString() Method in Student
 */