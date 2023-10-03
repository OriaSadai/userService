package pollProject.userService.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import pollProject.userService.Model.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    public void createUser(User user) throws JsonProcessingException;
    public User readUser(Long id);
    public void updateUser(User user);
    public void deleteUser(Long id);
    public void handleRegistration(Long id, String token);
    public Boolean checkConfirmed(Long id);
}
