package exceptions;

public class InvalidPasswordException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid Password! Password has to contain at least 1 Upper case, 1 Lower case, one digit and one sign (like !,#... etc)!";
    }
}
