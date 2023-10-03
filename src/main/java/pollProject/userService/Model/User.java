package pollProject.userService.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.time.LocalDate;

import static pollProject.userService.ConstVariables.ConstVariables.REGISTER_TOKEN;
import static pollProject.userService.ConstVariables.ConstVariables.UNREGISTER_TOKEN;

public class User {
    @JsonProperty(value = "id")
    private Long userId;
    private String firstName;
    private String LastName;
    private String email;
    private int age;
    @JsonProperty(value = "address")
    private String userAddress;
    private Date joinedDate;
    private Boolean isRegistered;
    public User() {}
    public User(Long userId, String firstName, String lastName, String email, int age, String userAddress, Date joinedDate, Boolean isRegistered) {
        this.userId = userId;
        this.firstName = firstName;
        this.LastName = lastName;
        this.email = email;
        this.age = age;
        this.userAddress = userAddress;
        this.joinedDate = joinedDate;
        this.isRegistered = isRegistered;
    }
    public Long getUserId() {
        return userId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return LastName;
    }
    public String getEmail() {
        return email;
    }
    public int getAge() {
        return age;
    }
    public String getUserAddress() {
        return userAddress;
    }
    public Date getJoinedDate() {
        return joinedDate;
    }
    public Boolean getRegistered() {
        return isRegistered;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
    public void setJoinedDate(Date joiningDate) {
        this.joinedDate = joinedDate;
    }
    public void setRegistered(Boolean isRegistered) {
        this.isRegistered = isRegistered;
    }
}
