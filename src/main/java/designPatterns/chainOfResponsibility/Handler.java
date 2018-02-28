package designPatterns.chainOfResponsibility;

public interface Handler {
    void handleRequest(int n);

    void setNextHandler(Handler next);
}
