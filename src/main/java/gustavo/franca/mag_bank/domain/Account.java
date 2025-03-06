package gustavo.franca.mag_bank.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@MappedSuperclass
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    protected User user;

    @Column(name = "account_number", unique = true, nullable = false)
    protected String accountNumber;

    @Column(name = "balance", nullable = false)
    protected BigDecimal balance = BigDecimal.ZERO;

    public Account(){}

    public Account(User user, String accountNumber, BigDecimal balance) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.balance = BigDecimal.ZERO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
