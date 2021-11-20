package exceptions;

public class InvalidDobException  extends Exception{
    @Override
    public String getMessage() {
        return "Wrong Date of Birth!";
    }

}
