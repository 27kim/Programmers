class Interface_3{
    public static void main(String[] args) {
        Tank_1 t = new Tank_1();
        DropShip d = new DropShip();

        Marine_1 m = new Marine_1();
        SCV       s = new SCV();

        s.repair(t);       // SCV가 Tank를 수리하도록 한다.
        s.repair(d);
//             s.repair(m);       에러발생 : repair(Repairable) in SCV cannot be applied to (Marine)
    }
}

interface Repairable {}

class GroundUnit extends Unit_1 {
    GroundUnit(int hp) {
        super(hp);
    }
}

class AirUnit extends Unit_1 {
    AirUnit(int hp) {
        super(hp);
    }
}

class Unit_1 {
    int hitPoint;
    final int MAX_HP;
    Unit_1(int hp) {
        MAX_HP = hp;
    }
}

class Tank_1 extends GroundUnit implements Repairable {
    Tank_1() {
        super(150);             // Tank의 HP는 150이다.
        hitPoint = MAX_HP;
    }

    public String toString() {
        return "Tank";
    }
    //...
}

class DropShip extends AirUnit implements Repairable {
    DropShip() {
        super(125);             // Dropship의 HP는 125이다.
        hitPoint = MAX_HP;
    }

    public String toString() {
        return "DropShip";
    }
    //...
}

class Marine_1 extends GroundUnit {
    Marine_1() {
        super(40);
        hitPoint = MAX_HP;
    }
    //...
}


class SCV extends GroundUnit implements Repairable{
    SCV() {
        super(60);
        hitPoint = MAX_HP;
    }

    void repair(Repairable r) {
        if (r instanceof Unit_1) {
            Unit_1 u = (Unit_1)r;
            while(u.hitPoint!=u.MAX_HP) {
                /* Unit의 HP를 증가시킨다. */
                u.hitPoint++;
            }
            System.out.println( u.toString() + "의 수리가 끝났습니다.");
        }
    }
    //...
}