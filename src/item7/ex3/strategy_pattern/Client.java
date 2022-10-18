package item7.ex3.strategy_pattern;


interface Strategy {
    public abstract void runStrategy(); // 전략 메서드
}

class StrategyGun implements Strategy{
    @Override
    public void runStrategy() {
        System.out.println("탕, 타탕, 타다당");
    }
}

class StrategySword implements Strategy{
    @Override
    public void runStrategy() {
        System.out.println("챙.. 채채챙 챙");        
    }
}

class StrategyBow implements Strategy {
    @Override
    public void runStrategy(){
        System.out.println("슝.. 슝슝슝");
    }
}

class Solider { 
    void runContext(Strategy strategy){
        System.out.println("전투시작");
        strategy.runStrategy();
        System.out.println("전투 종료");
    }
}

public class Client {
    public static void main(String[] args) {
        Strategy strategy = null;
        Solider rambo = new Solider();

        strategy = new StrategyGun();
        strategy.runStrategy();
        System.out.println();

        strategy = new StrategySword();
        strategy.runStrategy();
        System.out.println();

        strategy = new StrategyBow();
        strategy.runStrategy();
        System.out.println();
    }
}
