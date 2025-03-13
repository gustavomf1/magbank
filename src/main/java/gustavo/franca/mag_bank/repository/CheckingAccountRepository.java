package gustavo.franca.mag_bank.repository;

import gustavo.franca.mag_bank.domain.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long> {
    boolean existsByAccountNumber(String number);
}
