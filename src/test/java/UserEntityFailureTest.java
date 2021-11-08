
import exceptions.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.javafaker.Faker;

public class UserEntityFailureTest {
    Faker faker = new Faker();

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test(expected = InvalidEmailException.class)
    public void setInvalidEmailTest() throws InvalidEmailException {
        User u1 = new User();
        u1.setEmail("lehn90@lohncom");
        System.out.println(u1.getEmail());
    }
    @Test(expected = InvalidUsernameException.class)
    public void setInvalidUsernameTest() throws InvalidUsernameException{
        for(int i=0; i < 10; i++ ) {
            User u = new User();
            u.setUsername(faker.name().username().substring(1, 4));
        }
    }
    @Test(expected = InvalidPasswordException.class)
    public void setInvalidPasswordTest() throws InvalidPasswordException{
        for(int i=0; i < 10; i++ ) {
            User u = new User();
            u.setPassword(faker.expression("Qp95Ci"));
        }
    }
    @Test(expected = InvalidDobException.class)
    public void setInvalidDoBTest()throws InvalidDobException{
        for(int i=0; i < 10; i++ ) {
            User u = new User();
            u.setDoB(faker.date().birthday(160, 200));
        }
    }
    @Test(expected = InvalidRealException.class)
    public void setInvalidRealTest()throws InvalidRealException{
        User u = new User();
        u.setReal(false);
    }


}