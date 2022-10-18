package item7.ex1.strategy_pattern;

public class BlackPen implements Strategy{
    @Override
    public void ChoosePen() {
        System.out.println("검은펜을 잡았습니다.");
    }
}
