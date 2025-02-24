package gustavo.franca.mag_bank.repository;

import gustavo.franca.mag_bank.domain.ChekingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckingAccountRepository extends JpaRepository<ChekingAccount, Long> {
}
