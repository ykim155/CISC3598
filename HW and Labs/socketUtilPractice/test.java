package socketUtilPractice;

public class test {
    public static void main(String[] args) throws InterruptedException {
        socketUtils test = new socketUtils();

        boolean connected = test.socketConnect();

        if(connected) {
            boolean msg = test.sendMessage("Fanduel is the best!");
            boolean msg2 = test.sendMessage("QUIT");
            if(msg) {
                test.closeSocket();
            }
        }
    }
}
