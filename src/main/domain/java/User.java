/*
 *Template of objects of type "User"
 * @param uuidTeg of type UUIDClock is used as initial ID
 * @param username has limits of characters (between 2 and 16)
 * @param email  of user, contains characters  @  and .
 * @param password of user, contains at least 6 characters, not longer than 32, has to contain at least 1 Upper case, 1 Lower case, one digit and one sign (like !,#... etc)
 * @param Dob Of Date Type date of birth of user;
 * @param real of type Boolean, true if person confirmed him/herself
 */

import  com.fasterxml.uuid.*;
import exceptions.*;

import java.util.Calendar;
import java.util.Date;


public class User {
    private UUIDClock uuidTeg;
    private String username;
    private String email;
    private String password;
    private Date DoB;
    private Boolean real;



    public User(String username, String email, String password, Date Dob,Boolean real) throws InvalidEmailException, InvalidUsernameException, InvalidPasswordException, InvalidDobException, InvalidRealException {
        this.uuidTeg = new UUIDClock();
        setUsername(username);
        setEmail(email);
        setPassword(password);
        setDoB(Dob);
        setReal(real);
    }

    public User() {

    }


    public Date getDoB() {
        return DoB;
    }

    public void setDoB(Date doB) throws InvalidDobException {
        if (doB.after(new Date(1940, Calendar.JANUARY,1))&& doB.before(new Date(2004, Calendar.JANUARY, 1)))
            this.DoB = doB;
        else throw new InvalidDobException();


    }

    public Boolean getReal() {
        return real;
    }

    public void setReal(Boolean real) throws InvalidRealException{
        if (real) this.real = true;
        else throw new InvalidRealException();
    }

    public void setUuidTeg(UUIDClock uuidTeg) {
        this.uuidTeg = uuidTeg;
    }

    public UUIDClock getUuidTeg() {
        return uuidTeg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws InvalidUsernameException {
        if(username.length() > 6 && username.length() < 26)
            this.username = username;
        else throw new InvalidUsernameException();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail (String email) throws InvalidEmailException {

        if(email.contains("@") && email.contains("."))
            this.email = email;
        else throw new InvalidEmailException();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InvalidPasswordException {
        if (validatePassword(password)) this.password = password;
        else throw new InvalidPasswordException();
    }

    public static boolean validatePassword(String password) {
        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        boolean specialCh = false;
        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}~";
        String [] str2 =password.split("");
        if (password.length() < 6 )return false;
        else if (password.length() > 32 ) return false;
        else {
            for (int i = 0; i < password.length(); i++) {
                char symbol = password.charAt(i);

                if (Character.isUpperCase(symbol)) {
                    upper = true;
                } else if (Character.isLowerCase(symbol)) {
                    lower = true;
                } else if (Character.isDigit(symbol)) {
                    digit = true;
                } else if (specialCharacters.contains(str2[i])) {
                    specialCh = true;
                }
            }

        } return (upper && lower && digit && specialCh);
    }


    @Override
    public String toString() {
        return "User{" +
                "uuidTeg=" + uuidTeg +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", DoB=" + DoB +
                ", real=" + real +
                '}';
    }
}

