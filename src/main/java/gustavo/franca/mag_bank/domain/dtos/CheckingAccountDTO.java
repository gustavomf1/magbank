package gustavo.franca.mag_bank.domain.dtos;

import gustavo.franca.mag_bank.domain.CheckingAccount;
import gustavo.franca.mag_bank.domain.SavingAccount;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CheckingAccountDTO {
    private Long id;

    @NotNull(message = "The userId field is required")
    private Long userId;

    private String accountNumber;

    @NotNull(message = "The balance field is required")
    private BigDecimal balance;

    public CheckingAccountDTO(){}

    public CheckingAccountDTO(CheckingAccount obj){
        this.id = obj.getId();
        this.userId = obj.getUser().getId();
        this.accountNumber = obj.getAccountNumber();
        this.balance = obj.getBalance();
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
