public class A {
        public int x = 2;

        public A(){
            this.x++;
        }
        public A(int x){
            this.x += x;
        }
        public void f(double x){
            this.x = (int)(x + B.y);
        }

        public static void main (String[] args){
            B b = new B(2);
            System.out.println(b.x + " " + B.y);
            A z = b;
            System.out.println(z.x);
            z.f(-6);
            System.out.println(b.x + " " + B.y);
        }
}
