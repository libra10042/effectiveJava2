package item7.ex1.callback_pattern;

public class Teacher {
    public static void main(String[] args) {
        // Context 객체 생성
        Student student = new Student();

        // Context에 '익명 내부 클래스'로 Strategy 주입
        student.takeNotes(new Strategy() {
            @Override
            public void ChoosePen() {
                System.out.println("검은펜을 잡았습니다.");
            }
        });

        student.takeNotes(new Strategy() {
            @Override
            public void ChoosePen() {
                System.out.println("빨간펜을 잡았습니다.");
            }
        });

        student.takeNotes(new Strategy() {
            @Override
            public void ChoosePen() {
                System.out.println("파란펜을 잡았습니다.");
            }
        });
    }
}
