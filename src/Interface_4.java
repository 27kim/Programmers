public class Interface_4 {
    public static void main(String[] args) {
        B b =new B();
        b.methodB();

        methodA(new C());
    }

    static public void methodA(I i){
        i.methodB();
    }
}

class B {
    void methodB(){
        System.out.println("methodB");
    }
}

class C implements I {

    @Override
    public void methodB() {
        System.out.println("methodB from Interface");
    }
}

interface I{
    void methodB();
}