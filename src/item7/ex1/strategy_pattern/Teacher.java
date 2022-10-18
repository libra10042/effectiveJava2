package item7.ex1.strategy_pattern;

public class Teacher {
    public static void main(String[] args) {
        // Context 객체 생성
        Student student = new Student();

        // Strategy 객체 생성
        BlackPen black = new BlackPen();
        RedPen red = new RedPen();
        BluePen blue = new BluePen();

        // Context에 Strategy 주입
        student.takeNotes(black);
        student.takeNotes(red);
        student.takeNotes(blue);
    }
}
