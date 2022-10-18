package item7.ex3.template_callback_pattern;

interface Strategy {
    public abstract  void runStrategy();
}

class Solider {
    void runContext(String weaponSound){
        System.out.println("전투 시작");
        executeWeapon(weaponSound).runStrategy();
        System.out.println("전투 종료");
    }

    private Strategy executeWeapon(final String weaponSound){
        return new Strategy() {
            @Override
            public void runStrategy() {
                System.out.println(weaponSound);
            }
        };
    }
}

public class Client {
    public static void main(String[] args) {
        Solider rambo = new Solider();

        rambo.runContext("총! 총총총");
        System.out.println();
        rambo.runContext("칼! 칼칼칼");
        System.out.println();
        rambo.runContext("활! 활활활");
    }
}
