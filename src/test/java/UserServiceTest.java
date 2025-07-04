import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.junit.Test;
import static org.junit.Assert.*;

public class   UserServiceTest {
    private final UserService userService = new UserServiceImpl();

    private final String testName = "Nick";
    private final String testLastName = "Martin";
    private final Byte testAge = 15;


    @Test
    public void dropUsersTable() {
        try {
            userService.dropUsersTable();
            userService.dropUsersTable();
        } catch (Exception e) {
            fail("dropUsersTable() threw an exception: " + e.getMessage());
        }
    }

    @Test
    public void createUsersTable() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
        } catch (Exception e) {
            fail("createUsersTable() threw an exception: " + e.getMessage());
        }
    }

    @Test
    public void saveUser() {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLastName, testAge);

            User savedUser = userService.getAllUsers().get(0);

            assertEquals(testName, savedUser.getName());
            assertEquals(testLastName, savedUser.getLastName());
            assertEquals(testAge, savedUser.getAge());
    }

    @Test
    public void removeUserById() {
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser(testName, testLastName, testAge);
        userService.removeUserById(1L);
        assertTrue(userService.getAllUsers().isEmpty());
    }

    @Test
    public void getAllUsers() {
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser(testName, testLastName, testAge);
        assertEquals(1, userService.getAllUsers().size());
    }

    @Test
    public void cleanUsersTable() {
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser(testName, testLastName, testAge);
        userService.cleanUsersTable();
        assertTrue(userService.getAllUsers().isEmpty());

    }

}
