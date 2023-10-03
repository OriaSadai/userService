package pollProject.userService.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pollProject.userService.Model.User;
import pollProject.userService.Service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @PostMapping("/create")
    public void createUser(@RequestBody User user) throws JsonProcessingException {
        userService.createUser(user);
    }
    @GetMapping("/read/{id}")
    public User readUser(@PathVariable Long id) {
        return userService.readUser(id);
    }
    @PutMapping(value = "/update")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }
    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam(value = "id") Long id) {
        userService.deleteUser(id);
    }
    @PutMapping(value = "/register")
    public void handleUserRegistration(@RequestParam(value = "id") Long id, @RequestHeader(value = "token") String token) {
        logger.info(String.format("IN THE CONTROLLER: A REQUEST TO HANDLE REGISTRATION STATUS FOR USER ID:\"%s\". TOKEN:\"%s\".",id,token));
        userService.handleRegistration(id, token);
    }
    @GetMapping(value = "/confirm/{id}")
    public Boolean checkConfirmed(@PathVariable(value = "id") Long id) {
        logger.info(String.format("IN THE CONTROLLER: A REQUEST FROM POLL SERVICE TO CHECK CONFIRMATION STATUS FOR USER ID:\"%s\".",id));
        Boolean isConfirmed = null;
        isConfirmed = userService.checkConfirmed(id);
        logger.info(String.format("IN THE CONTROLLER: THE CONFIRMATION STATUS FOR USER ID:\"%s\" IS:\"%s\"",id,isConfirmed));
        return isConfirmed;
    }
}
