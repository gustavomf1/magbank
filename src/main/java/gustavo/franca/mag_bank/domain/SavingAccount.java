package gustavo.franca.mag_bank.domain;

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
}
