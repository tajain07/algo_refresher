package multithreading_handson;

public class StartThreadTwice extends Thread {
    public void run() {
        System.out.println("running...");
    }

    public static void main(String[] args) {
        StartThreadTwice threadTwice = new StartThreadTwice();
        threadTwice.start();
        threadTwice.start();
    }
}
