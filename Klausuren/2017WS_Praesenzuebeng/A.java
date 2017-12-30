public class A {
    int x = 3;
    int y = 5;

    public A(){
        this.setX(x - 3);
    }

    public A(int x){
        this.x += x;
    }

    public A(float x){
        this.x *= x;
    }

    void setX(int z){
        this.x = z;
    }

    public void f(float z){
        y *= z;
    }

    public static void main(String[] args){
        A a = new A();
        System.out.println(a.x + " " + B.x);
        A ab = new B();
        System.out.println(ab.x + " " + B.x);
    }
}
