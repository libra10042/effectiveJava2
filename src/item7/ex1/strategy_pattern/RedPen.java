package item7.ex1.strategy_pattern;

public class RedPen implements Strategy{
    @Override
    public void ChoosePen() {
        System.out.println("빨간펜을 잡았습니다.");
    }
}
