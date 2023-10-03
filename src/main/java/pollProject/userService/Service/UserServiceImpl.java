package pollProject.userService.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pollProject.userService.Model.User;
import pollProject.userService.Poll.PollService;
import pollProject.userService.Repository.UserRepository;

import java.util.Objects;

import static pollProject.userService.ConstVariables.ConstVariables.REGISTER_TOKEN;
import static pollProject.userService.ConstVariables.ConstVariables.UNREGISTER_TOKEN;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PollService pollService;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public void createUser(User user) throws JsonProcessingException {
        userRepository.createUser(user);
    }
    @Override
    public User readUser(Long id) {
        User userToRead = userRepository.readUser(id);
        logger.info(String.format("IN THE SERVICE: A QUERY TO READ USER ID:\"%s\", IS_REGISTERED=\"%s\".",id,userToRead.getRegistered()));
        return userToRead;
    }
    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
        pollService.deleteAnswersByUserId(id);
    }
    @Override
    public void handleRegistration(Long id, String token) {
        logger.info(String.format("IN THE SERVICE: A REQUEST TO HANDLE REGISTRATION STATUS TO USER ID:\"%s\" WITH TOKEN:\"%s\" RECEIVED.",id, token));
        User userToHandle = userRepository.readUser(id);
        if (userToHandle != null) {
            if (Objects.equals(token, REGISTER_TOKEN)) {
                logger.info(String.format("IN THE SERVICE: REGISTER TOKEN CORRECT. WILL REGISTER :-)"));
                userRepository.handleRegistration(id, true);
            } else if (Objects.equals(token, UNREGISTER_TOKEN)) {
                logger.warn(String.format("IN THE SERVICE: UNREGISTER TOKEN CORRECT. WILL REMOVE!"));
                userRepository.handleRegistration(id, false);
                pollService.deleteAnswersByUserId(id);
            } else {
                logger.error(String.format("IN THE SERVICE: THE TOKEN:\"%s\" IS INCORRECT :-(",token));
            }
        } else {
            logger.error(String.format("IN THE SERVICE: USER WITH ID:\"%s\" IS NOT EXIST :-(",id));
        }
    }
    @Override
    public Boolean checkConfirmed(Long id) {
        User userToConfirm = userRepository.readUser(id);

        if ((!(userToConfirm == null))) {
            logger.info(String.format("IN THE SERVICE: THE CONFIRMATION PROCESS TO USER ID:\"%s\". IS_REGISTERED:\"%s\".",userToConfirm.getUserId(),userToConfirm.getRegistered()));
            if (userToConfirm.getRegistered()) {
                logger.info(String.format("IN THE SERVICE: THE USER WITH ID:\"%s\" IS CONFIRMED :-)",id));
                return true;
            } else {
                logger.warn(String.format("IN THE SERVICE: THE USER WITH ID:\"%s\" IS NOT CONFIRMED :-(",id));
                return false;
            }
        } else {
            logger.error(String.format("IN THE SERVICE: USER WITH ID:\"%s\" IS NOT EXIST :-(",id));
            return null;
        }
    }
}
