package exceptions;

public class InvalidEmailException extends Exception{
    @Override
    public String getMessage() {
        return "Invalid email! It must contain '@' and '.' ";
    }
}
