package item7.ex1.strategy_pattern;

public class BluePen implements Strategy{
    @Override
    public void ChoosePen() {
        System.out.println("파란펜을 잡았습니다.");
    }
}
