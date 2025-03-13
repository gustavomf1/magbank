package gustavo.franca.mag_bank.services;

import gustavo.franca.mag_bank.domain.CheckingAccount;
import gustavo.franca.mag_bank.domain.SavingAccount;
import gustavo.franca.mag_bank.domain.User;
import gustavo.franca.mag_bank.domain.dtos.CheckingAccountDTO;
import gustavo.franca.mag_bank.repository.CheckingAccountRepository;
import gustavo.franca.mag_bank.repository.SavingAccountRepository;
import gustavo.franca.mag_bank.repository.UserRepository;
import gustavo.franca.mag_bank.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CheckingAccountService {

    private final CheckingAccountRepository repository;
    private final SavingAccountRepository savingAccountRepository;
    private final UserRepository userRepository;

    public CheckingAccountService(CheckingAccountRepository repository, UserRepository userRepository, SavingAccountRepository savingAccountRepository){
        this.repository = repository;
        this.userRepository = userRepository;
        this.savingAccountRepository = savingAccountRepository;
    }

    public List<CheckingAccount> findAll(){return repository.findAll();}

    public CheckingAccount findById(Long id){
        Optional <CheckingAccount> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public CheckingAccount create(@Valid CheckingAccountDTO objDTO){
        User user = userRepository.findById(objDTO.getUserId()).orElseThrow(() -> new ObjectNotFoundException("User not found! Id: "));
        objDTO.setAccountNumber(accountNumber());

        CheckingAccount checkingAccount = new CheckingAccount(objDTO, user);
        return repository.save(checkingAccount);
    }

    public String accountNumber(){
        String accountNumberChecking;
        Random random = new Random();

        do {
            accountNumberChecking = String.format("%08d", random.nextInt(100000000));
        }while (repository.existsByAccountNumber(accountNumberChecking) && savingAccountRepository.existsByAccountNumber(accountNumberChecking));

        return accountNumberChecking;
    }
}
