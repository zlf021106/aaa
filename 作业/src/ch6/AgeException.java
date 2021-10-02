package ch6;

public class AgeException extends Exception {
    public AgeException() {
        super("年龄超过范围");
    }
    public AgeException(String message) {
        super(message);
    }
}

