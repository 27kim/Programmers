/**
 * 추상클래스와 달리 몸통을 갖춘 일반 메서드 또는 멤버변수를 구성원으로 가질 수 없다.
 * 오직 추상메서드와 상수만을 멤버로 가질 수 있으며, 그 외의 다른 어떠한 요소도 허용하지 않는다.
 * <p>
 * interface 인터페이스이름 {
 * public static final 타입 상수이름 = 값;
 * public abstract 메서드이름(매개변수목록);
 * }
 * <p>
 * - 모든 멤버변수는 public static final 이어야 하며, 이를 생략할 수 있다.
 * - 모든 메서드는 public abstract 이어야 하며, 이를 생략할 수 있다.
 */

public class Interface_1 {
    public static void main(String[] args) {
        new FighterTest().print();
    }
}

interface Movable {
    void move(int x, int y);
}

interface Attackable {
    void attack(Unit u);
}

interface Fightable extends Movable, Attackable {

}

class Fighter extends Unit implements Fightable {

    @Override
    public void move(int x, int y) {
    }

    @Override
    public void attack(Unit u) {
    }
}

class FighterTest {
    void print() {
        Fighter f = new Fighter();
        System.out.println("Fighter f = new Fighter();");
        if (f instanceof Unit) {
            System.out.println("f는 Unit클래스의 자손입니다.");
        }
        if (f instanceof Fightable) {
            System.out.println("f는 Fightable인터페이스를 구현했습니다.");
        }
        if (f instanceof Movable) {
            System.out.println("f는 Movable인터페이스를 구현했습니다.");
        }
        if (f instanceof Attackable) {
            System.out.println("f는 Attackable인터페이스를 구현했습니다.");
        }
        if (f instanceof Object) {
            System.out.println("f는 Object클래스의 자손입니다.");
        }
    }
}

class Tv_1 {
    protected boolean power;
    protected int channel;
    protected int volume;

    public void power() {
        power = !power;
    }

    public void channelUp() {
        channel++;
    }

    public void channelDown() {
        channel--;
    }

    public void volumeUp() {
        volume++;
    }

    public void volumeDown() {
        volume--;
    }
}

class VCR_1 {
    protected int counter;             // VCR의 카운터

    public void play() {
        // Tape을 재생한다.
    }

    public void stop() {
        // 재생을 멈춘다.
    }

    public void reset() {
        counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int c) {
        counter = c;
    }
}

interface IVCR {
    void play();

    void stop();

    void reset();

    int getCounter();

    void setCounter(int c);
}

class TVCR extends Tv_1 implements IVCR{

    VCR_1 vcr = new VCR_1();

    @Override
    public void play() {
        vcr.play();
    }

    @Override
    public void stop() {
        vcr.stop();
    }

    @Override
    public void reset() {
        vcr.reset();
    }

    @Override
    public int getCounter() {
        return vcr.getCounter();
    }

    @Override
    public void setCounter(int c) {
        vcr.setCounter(c);
    }
}
