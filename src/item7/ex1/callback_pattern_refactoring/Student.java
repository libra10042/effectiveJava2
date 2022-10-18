package item7.ex1.callback_pattern_refactoring;

public class Student {
    public void takeNotes(String pen){
        System.out.println("선생님께서 펜을 주십니다.");
        // 변경된 부분
        takePen(pen).ChoosePen();
        System.out.println("필기를 시작합니다.");
    }

    // Strategy를 익명 클래스로 반환하는 메서드
    private Strategy takePen(String pen){
        // 익명 클래스 사용
        return new Strategy() {
            @Override
            public void ChoosePen() {
                System.out.println(pen + "을 잡았습니다.");
            }
        };
    }
}
