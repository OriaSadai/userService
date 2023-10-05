package pollProject.userService.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import pollProject.userService.Model.User;
import java.text.ParseException;

public interface UserService {
    public void createUser(User user) throws JsonProcessingException;
    public User readUser(Long id);
    public void updateUser(User user);
    public void deleteUser(Long id, String delToken);
    public void handleRegistration(Long id, String regToken) throws ParseException;
    public Boolean checkConfirmed(Long id);
}
