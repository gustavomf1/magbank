package gustavo.franca.mag_bank.repository;

import gustavo.franca.mag_bank.domain.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingAccountRepository extends JpaRepository<SavingAccount, Long> {
}
