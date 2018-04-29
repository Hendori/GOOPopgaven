public class A {
    protected int a = 5;

    public A() {
        System.out.println("constructor A: a = "+a);
        a = 7;
    }

    public int getA() {
        return a;
    }
}    
