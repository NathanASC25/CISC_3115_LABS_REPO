// StudentRegistry class to test the Student class
public class StudentRegistry {
    public static void main(String[] args) {
        // Step 1: Create two instances of the Student class
        Student student1 = new Student();
        Student student2 = new Student();
        // Step 2: Use setter methods to set values for all attributes of first student
        // Example values: ID "S001", name "John Doe", grade 85.5, active true
        student1.setStudentId("5001");
        student1.setName("John Doe");
        student1.setGrade(85.5);
        student1.setIsActive(true);
        // Step 3: Set values for second student
        // Example values: ID "S002", name "Jane Smith", grade 92.0, active true
        student2.setStudentId("5002");
        student2.setName("Jane Smith");
        student2.setGrade(92.0);
        student2.setIsActive(true);
        // Step 4: Display details of both students
        student1.displayStudentDetails();
        student2.displayStudentDetails();
        // Step 5: Compare the grades of the two students and print who has the higher grade
        // Hint: Create a separate method for this comparison
        compareGrades(student1, student2);
        
        // Step 6: Test the letter grade method for both students
        String letterGrade1 = student1.getLetterGrade();
        String letterGrade2 = student2.getLetterGrade();
        System.out.printf("\nStudent 1's Letter Grade: %s", letterGrade1);
        System.out.printf("\nStudent 2's Letter Grade: %s", letterGrade2);
        // Step 7: Test the passing status method for both students
        boolean isPassing1 = student1.isStudentPassing();
        boolean isPassing2 = student2.isStudentPassing();
        System.out.printf("\nStudent 1 is passing: %b", isPassing1);
        System.out.printf("\nStudent 2 is passing: %b", isPassing2);
        // Step 8: Change one student to inactive and display the updated information
	student2.setIsActive(false);
        boolean isActive1 = student1.getIsActive();
        boolean isActive2 = student2.getIsActive();
        System.out.printf("\nStudent 1 is active: %b", isActive1);
        System.out.printf("\nStudent 2 is active: %b", isActive2);
    }
    public static void compareGrades(Student student1, Student student2) {
        if (student1.getGrade() > student2.getGrade()) {
            System.out.printf("\n%s has the higher grade.", student1.getName());
        }
        else if (student2.getGrade() > student1.getGrade()) {
            System.out.printf("\n%s has the higher grade.", student2.getName());
        }
        else {
            System.out.printf("\n%s and %s have the same grade.", student1.getName(), student2.getName());
        }
    }
    // Step 9: Create a static method to compare two students' grades and return the student with the higher grade
    // Hint: Take two Student objects as parameters
}
