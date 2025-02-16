package gustavo.franca.mag_bank.domain.dtos;

import gustavo.franca.mag_bank.domain.User;
import gustavo.franca.mag_bank.domain.UserType;
import jakarta.validation.constraints.NotNull;

public class UserDTO {
    private Long id;

    @NotNull(message = "The Full Name field is required.")
    private String fullName;

    @NotNull(message = "The email field is required.")
    private String email;

    @NotNull(message = "The CPF field is required.")
    private String cpf;

    @NotNull(message = "The password field is required.")
    private String password;

    @NotNull(message = "The phone number field is required.")
    private String phoneNumber;

    private UserType userType;

    public UserDTO() {
    }

    public UserDTO(Long id, String fullName, String email, String cpf, String password, String phoneNumber, UserType userType) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
    }

    public UserDTO(User obj) {
        this.id = obj.getId();
        this.cpf = obj.getCpf();
        this.fullName = obj.getFullName();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.phoneNumber = obj.getPhoneNumber();
        this.userType = obj.getUserType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
