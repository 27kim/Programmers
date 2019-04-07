public class Polymorphism_1 {


    public static void main(String[] args) {
        FireEngine f;
        Ambulance a ;

        Car car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;

        fe.water();
        car = fe;             // car =(Car)fe;에서 형변환이 생략된 형태다.
//         car.water();     //  컴파일 에러!!! Car타입의 참조변수로는 water()를 호출할 수 없다.
        /**
         * 참조변수 car가 참조하고 있는 인스턴스를 참조변수 fe2가 참조하도록 한다.
         * 이때 두 참조변수의 타입이 다르므로 참조변수 car를 형변환하였다.
         * car에는 FireEngine인스턴스의 주소가 저장되어 있으므로 fe2에도 FireEngine인스턴스의 주소가 저장된다.
         * 이제는 참조변수 fe2를 통해서도 FireEngine인스턴스를 사용할 수 있지만,
         * car와는 달리, fe2는 FireEngine타입이므로 FireEngine인스턴스의 모든 멤버들을 사용할 수 있다.
         * */
        fe2 = (FireEngine)car;       // 자손타입 <- 조상타입
        fe2.water();


        Car car_1 = new Car();
        Car car2_1 = null;
        FireEngine fe_1 = null;

        System.out.println("-------------");
        car_1.drive();
        fe_1 = (FireEngine)car_1;
//        fe_1.water(); // 실행 시 에러가 발생한다.
        /**이 예제는 컴파일은 성공하지만, 실행시 에러(ClassCastException)가 발생한다.
         * 에러가 발생한 곳은 문장은 CastingTest2.java의 8번째 라인인 fe = (FireEngine)car;이며,
         * 발생이유는 형변환에 오류가 있기 때문이다.
         * 캐스트 연산자를 이용해서 조상타입의 참조변수를 자손타입의 참조변수로 형변환한 것이기 때문에 문제가 없어 보이지만,
         * 문제는 참조변수 car가 참조하고 있는 인스턴스가 Car타입의 인스턴스라는데 있다.
         * 전에 배운 것처럼 조상타입의 인스턴스를 자손타입의 참조변수로 참조하는 것은 허용되지 않기 때문이다.
         위의 예제에서 Car car = new Car();를 Car car = new FireEngine();와 같이 변경하면,
         컴파일시 뿐 만 아니라 실행 시에도 에러가 발생하지 않을 것이다.
         컴파일시에는 참조변수간의 타입만 체크하기 때문에 실행 시 생성될 인스턴스의 타입에 대해서는 알지 못한다.
         그래서 컴파일시에는 문제가 없었지만,
         실행 시에는 에러가 발생하여 실행이 비정상적으로 종료된 것이다.
         * */
        car2_1 = fe;
        car2_1.drive();
    }



}


class Car{
    String colorl;
    int door;
    void drive(){
        System.out.println("Drive");
    }
    void stop(){
        System.out.println("Stop");
    }
}

class FireEngine extends Car{
    void water(){
        System.out.println("Water");
    }
}

class Ambulance extends Car{
    void siren(){
        System.out.println("Siren");
    }
}