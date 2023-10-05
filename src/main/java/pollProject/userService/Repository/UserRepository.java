package pollProject.userService.Repository;

import org.springframework.dao.EmptyResultDataAccessException;
import pollProject.userService.Model.User;

import java.util.List;

public interface UserRepository {
    public void createUser(User user);
    public User readUser(Long id);
    public void updateUser(User user) throws EmptyResultDataAccessException;
    public void deleteUser(Long id);
    public void handleRegistration(Long id, Boolean isRegistered);
    public List<User> readAllUsers();
}
