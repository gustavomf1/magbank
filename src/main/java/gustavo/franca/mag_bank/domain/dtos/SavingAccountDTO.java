package gustavo.franca.mag_bank.domain.dtos;

import gustavo.franca.mag_bank.domain.SavingAccount;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class SavingAccountDTO {

    private Long id;

    @NotNull(message = "The userId field is required")
    private Long userId;

    private String accountNumber;

    @NotNull(message = "The balance field is required")
    private BigDecimal balance;

    public SavingAccountDTO(){}

    public SavingAccountDTO(SavingAccount account){
        this.id = account.getId();
        this.userId = account.getUser().getId();
        this.accountNumber = account.getAccountNumber();
        this.balance = account.getBalance();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
