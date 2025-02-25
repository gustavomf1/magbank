package gustavo.franca.mag_bank.services;

import gustavo.franca.mag_bank.domain.SavingAccount;
import gustavo.franca.mag_bank.repository.SavingAccountRepository;
import gustavo.franca.mag_bank.services.exceptions.ObjectNotFoundExcpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingAccountService {

    @Autowired
    private SavingAccountRepository repository;

    public List<SavingAccount> findAll(){ return repository.findAll();}

    public SavingAccount finById(Long id){
        Optional<SavingAccount> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExcpetion("Objeto não econtrado! Id: " + id));
    }


}
