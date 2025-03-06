package gustavo.franca.mag_bank.domain;

import gustavo.franca.mag_bank.domain.dtos.SavingAccountDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_saving_account")
public class SavingAccount extends Account{
    private static final BigDecimal WITHDRAWAL_FEE = BigDecimal.valueOf(0.05);

    public SavingAccount(){}
    public SavingAccount(User user, String accountNumber, BigDecimal balance){
        super(user, accountNumber, balance);
    }

    public SavingAccount(SavingAccountDTO objDTO, User user) {
        this.id = objDTO.getId();
        this.accountNumber = objDTO.getAccountNumber();
        this.user = user;
        this.balance = objDTO.getBalance();
    }
}
