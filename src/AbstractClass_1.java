public class AbstractClass_1 {
}

abstract class Player{
    boolean pause;
    int currentPos;

    Player(){
        pause = false;
        currentPos = 0;
    }

    abstract void play(int pos);
    abstract void stop();

    //추상 메서드 사용 가능
    void play(){
        play(currentPos);
    }

    void pause(){
        if(pause){
            pause = false;
            play(currentPos);
        }else{
            pause = true;
            stop();
        }
    }
}

class CDPlyaer extends Player{

    // 조상 클래스의 추상메서드를 구현한다.
    @Override
    void play(int pos) {
        /* 실제구현 내용 생략 */

    }
    // 조상 클래스의 추상메서드를 구현한다.
    @Override
    void stop() {
        /* 실제구현 내용 생략 */
    }

    // CDPlayer클래스에 추가로 정의된 멤버
    int currentTrack; // 현재 재생 중인 트랙

    void nextTrack() {
        currentTrack++;
        //...
    }

    void preTrack() {
        if(currentTrack > 0) {
            currentTrack--;
        }
        //...
    }

}