public class deadlock {

    public static void main(String[] args) {
        String a = "a";
        String b = "b";

        Thread t1 = new Thread() {
            public void run() {
                synchronized (a) {
                    System.out.println(a);
                    synchronized (b) {
                        System.out.println(b);
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                synchronized (b) {
                    System.out.println(b);
                    synchronized (a) {
                        System.out.println(a);
                    }
                }
            }
        };
        t1.start();
        t2.start();

    }
}
