package item7.ex1.strategy_pattern;

public class Student {
    public void takeNotes(Strategy strategy){
        System.out.println("선생님이 펜을 주십니다.");
        strategy.ChoosePen();
        System.out.println("필기를 시작합니다.");
    }
}
