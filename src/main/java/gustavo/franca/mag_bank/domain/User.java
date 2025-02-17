package gustavo.franca.mag_bank.domain;

import gustavo.franca.mag_bank.domain.dtos.UserDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "user_type_id")
    private UserType userType;

    public User() {
    }

    public User(Long id, String fullName, String email, String cpf, String password, String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.userType = new UserType();
        this.userType.setId(2L);
    }

    public User(UserDTO objDTO) {
        this.id = objDTO.getId();
        this.fullName = objDTO.getFullName();
        this.email = objDTO.getEmail();
        this.cpf = objDTO.getCpf();
        this.password = objDTO.getPassword();
        this.phoneNumber = objDTO.getPhoneNumber();
        this.userType = new UserType();
        this.userType.setId(objDTO.getUserType().getId() != null ? objDTO.getUserType().getId() : 2L);
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
