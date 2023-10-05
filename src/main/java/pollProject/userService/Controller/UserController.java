package pollProject.userService.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pollProject.userService.Model.User;
import pollProject.userService.Service.UserService;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
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
    public void deleteUser(@RequestParam(value = "id") Long id, @RequestHeader(value = "delToken") String delToken) {
        userService.deleteUser(id, delToken);
    }
    @PutMapping(value = "/register")
    public void handleUserRegistration(@RequestParam(value = "id") Long id, @RequestHeader(value = "regToken") String regToken) throws ParseException {
        userService.handleRegistration(id, regToken);
    }
    @GetMapping(value = "/confirm/{id}")
    public Boolean checkConfirmed(@PathVariable(value = "id") Long id) {
        return userService.checkConfirmed(id);
    }
}
