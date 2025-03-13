package gustavo.franca.mag_bank.domain;

import gustavo.franca.mag_bank.domain.dtos.CheckingAccountDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_checking_account")
public class CheckingAccount extends Account{

    private static final BigDecimal OVERDRAFT_LIMIT = new BigDecimal("1000.00");

    public CheckingAccount(){

    }

    public CheckingAccount(User user, String accountNumber, BigDecimal balance){
        super(user, accountNumber, balance);
    }

    public CheckingAccount(CheckingAccountDTO objDTO, User user) {
        this.id = objDTO.getId();
        this.accountNumber = objDTO.getAccountNumber();
        this.user = user;
        this.balance = objDTO.getBalance();
    }
}
