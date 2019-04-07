public class AbstractClass_2 {
}

class Marine extends Unit {                   // 보병
    void stimPack() {       /* 스팀팩을 사용한다.*/}

    @Override
    void move(int x, int y) {

    }
}

class Tank extends Unit {                   // 탱크
    void changeMode() {       /* 공격모드를 변환한다. */}

    @Override
    void move(int x, int y) {

    }
}

class Dropship extends Unit {                   // 수송선
    void load() { /* 선택된 대상을 태운다.*/ }
    void unload() { /* 선택된 대상을 태운다.*/ }

    @Override
    void move(int x, int y) {

    }
}

abstract class Unit{
    int x, y;                         // 현재 위치
    abstract void move(int x, int y);
    /**
     * move메서드가 추상메서드로 선언된 것에는,
     * 앞으로 Unit클래스를 상속받아서 작성되는 클래스는
     * move메서드를 자신의 클래스에 알맞게
     * 반드시 구현해야한다는 의미가 담겨 있는 것이기도 하다.
     * */
    void stop() {       /* 현재 위치에 정지 */ }
}