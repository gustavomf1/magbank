package gustavo.franca.mag_bank.domain;

import gustavo.franca.mag_bank.domain.dtos.UserDTO;
import gustavo.franca.mag_bank.domain.enums.UserType;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING) // Armazena como STRING no banco
    @Column(name = "user_type", nullable = false)
    private UserType userType;

    public User() {
    }

    public User(Long id, String fullName, String email, String cpf, String password, String phoneNumber, UserType userType) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
    }

    public User(UserDTO objDTO) {
        this.id = objDTO.getId();
        this.fullName = objDTO.getFullName();
        this.email = objDTO.getEmail();
        this.cpf = objDTO.getCpf();
        this.password = objDTO.getPassword();
        this.phoneNumber = objDTO.getPhoneNumber();
        this.userType = UserType.fromCode(objDTO.getUserTypeId());
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
