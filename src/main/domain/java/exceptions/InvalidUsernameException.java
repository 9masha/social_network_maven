package exceptions;

public class InvalidUsernameException extends Exception{
    @Override
    public String getMessage() {
        return "Invalid userName!Username must be between 6 and 16 characters!";
    }
}
