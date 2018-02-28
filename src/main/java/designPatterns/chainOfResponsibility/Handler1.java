package designPatterns.chainOfResponsibility;

public class Handler1 implements Handler {

    private Handler next;

    @Override
    public void handleRequest(int n) {
        if (n < 10) {
            System.out.println("handler1 handle the request" + n);
        } else {
            if (next == null) {
                throw new NullPointerException("next cannot be null");
            }
            next.handleRequest(n);
        }

    }

    @Override
    public void setNextHandler(Handler next) {
        this.next = next;
    }
}
