package exceptions;

public class InvalidRealException extends Exception{
    @Override
    public String getMessage() {
        return "You have to confirm yourself!";
    }
}
