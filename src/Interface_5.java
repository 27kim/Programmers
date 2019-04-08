public class Interface_5 {
    public static void main(String[] args) {
        A a = new A();
        a.play(new AA());
        a.play(new BB());
    }
}

interface I_1 {
    void play();
}

class AA implements I_1 {

    @Override
    public void play() {
        System.out.println("class AA implements I_1");
    }
}


class BB implements I_1 {

    @Override
    public void play() {
        System.out.println("class BB implements I_1");
    }
}

class A{
    void play(I_1 i){
        i.play();
    }
}