package item7.ex1.callback_pattern_refactoring;

public class Teacher {
    public static void main(String[] args) {
        Student student = new Student();

        student.takeNotes("검정펜");
        student.takeNotes("빨간펜");
        student.takeNotes("파란펜");
        student.takeNotes("무지개 형관펜");
    }
}
