package gustavo.franca.mag_bank.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_checking_account")
public class ChekingAccount extends Account{

    private static final BigDecimal OVERDRAFT_LIMIT = new BigDecimal("1000.00");

    public ChekingAccount(){

    }

    public ChekingAccount(User user, String accountNumber, BigDecimal balance){
        super(user, accountNumber, balance);
    }
}
