package gustavo.franca.mag_bank.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gustavo.franca.mag_bank.domain.CheckingAccount;
import gustavo.franca.mag_bank.domain.SavingAccount;
import gustavo.franca.mag_bank.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserDTO {
    @JsonIgnore
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

    @JsonIgnore
    @Schema(hidden = true)
    private SavingAccount savingAccount;

    @JsonIgnore
    @Schema(hidden = true)
    private CheckingAccount checkingAccount;

    @NotNull(message = "The cep field is required.")
    private String cep;

    public UserDTO() {
        this.savingAccount = null;
        this.checkingAccount = null;
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
        this.userTypeId = obj.getUserType() != null ? obj.getUserType().getCode() : null;
        this.savingAccount = obj.getSavingAccount();
        this.checkingAccount = obj.getCheckingAccount();
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

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    public CheckingAccount getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
