package gustavo.franca.mag_bank.domain.dtos;

import gustavo.franca.mag_bank.domain.User;
import gustavo.franca.mag_bank.domain.enums.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserDTO {
    private Long id;

    @NotBlank(message = "The Full Name field is required.")
    private String fullName;

    @NotBlank(message = "The email field is required.")
    private String email;

    @NotBlank(message = "The CPF field is required.")
    private String cpf;

    @NotBlank(message = "The password field is required.")
    private String password;

    @NotBlank(message = "The phone number field is required.")
    private String phoneNumber;

    @NotNull(message = "The user type field is required.")
    private Integer userTypeId;

    public UserDTO() {
    }

    public UserDTO(Long id, String fullName, String email, String cpf, String password, String phoneNumber, Integer userTypeId) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.userTypeId = userTypeId;
    }

    public UserDTO(User obj) {
        this.id = obj.getId();
        this.cpf = obj.getCpf();
        this.fullName = obj.getFullName();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.phoneNumber = obj.getPhoneNumber();
        this.userTypeId = obj.getUserType() != null ? obj.getUserType().getCode() : null; // Convertendo para Integer
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

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }
}
