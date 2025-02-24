package gustavo.franca.mag_bank.services;

import gustavo.franca.mag_bank.domain.SavingAccount;
import gustavo.franca.mag_bank.repository.SavingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingAccountService {

    @Autowired
    private SavingAccountRepository repository;

    public List<SavingAccount> findAll(){ return repository.findAll();}

}
