package internship;

import java.util.*;

//Student class
class Student {
 int id;
 String name;
 double marks;

 public Student(int id, String name, double marks) {
     this.id = id;
     this.name = name;
     this.marks = marks;
 }

 // toString for formatted output
 public String toString() {
     return String.format("ID: %d | Name: %s | Marks: %.2f", id, name, marks);
 }
}

//Comparator for sorting by marks
class MarksComparator implements Comparator<Student> {
 public int compare(Student s1, Student s2) {
     return Double.compare(s2.marks, s1.marks); // Descending order
 }
}

public class StudentManagementSystem {

 public static void main(String[] args) {

     //  Optimize memory with initial capacity
     ArrayList<Student> students = new ArrayList<>(10);

     students.add(new Student(101, "Riya", 85));
     students.add(new Student(102, "Amit", 90));
     students.add(new Student(103, "Neha", 78));
     students.add(new Student(101, "Riya", 85)); // Duplicate

     // Remove duplicates using Set
     Set<Integer> uniqueIds = new HashSet<>();
     ArrayList<Student> uniqueStudents = new ArrayList<>();

     for (Student s : students) { // Enhanced for loop
         if (uniqueIds.add(s.id)) {
             uniqueStudents.add(s);
         }
     }

     //  HashMap for fast lookup
     HashMap<Integer, Student> studentMap = new HashMap<>();

     for (Student s : uniqueStudents) {
         studentMap.put(s.id, s);
     }

     // Fast search
     System.out.println("Lookup Student with ID 102:");
     System.out.println(studentMap.get(102));

     System.out.println("\nSorted Student List (By Marks):");

     //  Sorting using Comparator
     Collections.sort(uniqueStudents, new MarksComparator());

     //  Formatted Report
     System.out.println("----- Student Report -----");

     for (Student s : uniqueStudents) {
         System.out.println(s);
     }

     // Demonstrating Collection Hierarchy
     System.out.println("\nCollection Hierarchy Used:");
     System.out.println("List -> ArrayList");
     System.out.println("Set -> HashSet");
     System.out.println("Map -> HashMap");
 }
}
