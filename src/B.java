public class B extends A {
    private int b = a + 10;

    public B() {
        a = 2;
        System.out.println(String.format("constructor B: a = %d, b = %d", a, b)
    }

    public int getB() {
        return b;
    }

    public static void main (String [] args) {
        B b = new B();
        System.out.println(String.format("main: a = %d, b = %d", b.getA(), b.getB());
    }
}
