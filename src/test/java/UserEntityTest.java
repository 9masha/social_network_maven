/*
setCorrectUserNameTest() - makes iterative test 100 times, each time setting a fake username and testing if the name was set (use Java Fake and special annotations in order to init the faker object before the test CASE)
setCorrectEmailTest - sets 100 times a random fake email and each time verifies if it's correct
setCorrectPasswordTest() - sets 2-3 static passwords that meet the requirements from HW3. Finish the User entity #4
setCorrectDobTest() - tests 10 random dates of birth, verifies the result of each
setCorrectRealTest() - check true/false values for this property
 */
import com.github.javafaker.Faker;

import exceptions.*;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;


public class UserEntityTest {

    Faker faker = new Faker();

    @Test
    public void setCorrectUserNameTest() throws InvalidUsernameException{
        for(int i=0; i < 100; i++ ){
            User u = new User();
            u.setUsername(faker.name().username());
            System.out.println(u.getUsername());
        }
    }
    @Test
    public void setCorrectEmailTest() throws InvalidEmailException{
        for(int i=0; i < 100; i++ ){
            User u = new User();
            u.setEmail(faker.name().username() + "@gmail.com");
            System.out.println(u.getEmail());
        }
    }
    @Test
    public void setCorrectPasswordTest() throws InvalidPasswordException{
        User u = new User();
        u.setPassword("58-Klo%");
        System.out.println(u.getPassword());
        u.setPassword("Zbo-569/Io!");
        System.out.println(u.getPassword());
        u.setPassword("&Dom-782)!");
        System.out.println(u.getPassword());
    }
    @Test
    public void setCorrectDobTest() throws InvalidDobException {
        for(int i=0; i < 10; i++ ) {
            User u = new User();
            u.setDoB(faker.date().between(new Date(1950, Calendar.JANUARY, 1), new Date (2000, Calendar.JANUARY, 1)));
            System.out.println(u.getDoB());
        }
    }
    @Test
    public void setCorrectRealTest() throws InvalidRealException {
        User u = new User();
        u.setReal(true);
        System.out.println(u.getReal());
    }

}

