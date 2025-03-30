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

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false)
    private UserType userType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "saving_account_id", unique = true)
    private SavingAccount savingAccount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "checking_account_id", unique = true)
    private CheckingAccount checkingAccount;

    @OneToOne
    @JoinColumn(name = "adress_id")
    private Address address;


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
        this.savingAccount = null;
        this.checkingAccount = null;
    }

    public User(UserDTO objDTO) {
        this.id = objDTO.getId();
        this.fullName = objDTO.getFullName();
        this.email = objDTO.getEmail();
        this.cpf = objDTO.getCpf();
        this.password = objDTO.getPassword();
        this.phoneNumber = objDTO.getPhoneNumber();
        this.userType = UserType.fromCode(objDTO.getUserTypeId());
        this.checkingAccount = null;
        this.savingAccount = null;
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

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
