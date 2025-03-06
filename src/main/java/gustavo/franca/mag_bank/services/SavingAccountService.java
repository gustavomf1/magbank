package gustavo.franca.mag_bank.services;

import gustavo.franca.mag_bank.domain.SavingAccount;
import gustavo.franca.mag_bank.domain.User;
import gustavo.franca.mag_bank.domain.dtos.SavingAccountDTO;
import gustavo.franca.mag_bank.repository.SavingAccountRepository;
import gustavo.franca.mag_bank.repository.UserRepository;
import gustavo.franca.mag_bank.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingAccountService {

    private final SavingAccountRepository repository;
    private final UserRepository userRepository;

    public SavingAccountService(SavingAccountRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public List<SavingAccount> findAll(){ return repository.findAll();}

    public SavingAccount finById(Long id){
        Optional<SavingAccount> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não econtrado! Id: " + id));
    }

    public SavingAccount create(@Valid SavingAccountDTO objDTO){
        User user = userRepository.findById(objDTO.getUserId()).orElseThrow(() -> new ObjectNotFoundException("User not Found"));

        SavingAccount savingAccount = new SavingAccount(objDTO, user);
        return repository.save(savingAccount);
    }


}
