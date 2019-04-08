public class Interface_6 {
    public static void main(String[] args) {
        AAA a = new AAA();
        a.mehtodA();
    }
}



interface II{
    void methodB();
}

class AAA {
    void mehtodA(){
        II i = InstanceManager.getInstance();
        i.methodB();
    }
}

class BBB implements II{

    @Override
    public void methodB() {
        System.out.println("class BBB implements II");
    }
}

class InstanceManager{
    public static II getInstance(){
        return new BBB();
    }
}