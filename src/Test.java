import java.awt.*;

public class Test {
//    static class nested {
//
//    }
//    class inner {
//        int b;
//        int test(int a) {
//            b = a;
//        }
//
//    }
//    Test outer = new Test();
//    outer.inner innerClass = outer.new inner();
//
//    class Coordinate{
//        int x;
//        int y;
//        public Coordinate(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//    class MyComparator implements Comparator<Coordinate> {
//        @Override
//        public int compareTo(Coordinate c1, Coordinate c2) {
//            if (c1.x == c2.x) {
//                return c1.y < c2.y ? -1 : 1;;
//            } else {
//                return c1.x < c2.x ? -1 : 1;
//            }
//        }
//    }

    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println(a2.show(c));
//        System.out.println(a2.show(d));
    }
}

class A{
    public String show(D obj) {
        return ("A and D");
    }
    public String show(A obj) {
        return ("A and A");
    }
}
class B extends A {
    public String show(B obj) {
        return ("B and B");
    }
    @Override
    public String show(A obj) {
        return ("B and A");
    }
}
class C extends B {}
class D extends B {}
