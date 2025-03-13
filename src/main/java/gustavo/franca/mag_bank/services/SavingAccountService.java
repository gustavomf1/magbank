package gustavo.franca.mag_bank.services;

import gustavo.franca.mag_bank.domain.CheckingAccount;
import gustavo.franca.mag_bank.domain.SavingAccount;
import gustavo.franca.mag_bank.domain.User;
import gustavo.franca.mag_bank.domain.dtos.SavingAccountDTO;
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
public class SavingAccountService {

    private final SavingAccountRepository repository;
    private final CheckingAccountRepository checkingAccountRepository;
    private final UserRepository userRepository;

    public SavingAccountService(SavingAccountRepository repository, UserRepository userRepository, CheckingAccountRepository checkingAccountRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.checkingAccountRepository = checkingAccountRepository;
    }
    public List<SavingAccount> findAll(){ return repository.findAll();}

    public SavingAccount finById(Long id){
        Optional<SavingAccount> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não econtrado! Id: " + id));
    }

    public SavingAccount create(@Valid SavingAccountDTO objDTO){
        User user = userRepository.findById(objDTO.getUserId()).orElseThrow(() -> new ObjectNotFoundException("User not Found"));
        objDTO.setAccountNumber(accountNumber());

        SavingAccount savingAccount = new SavingAccount(objDTO, user);
        return repository.save(savingAccount);
    }

    public String accountNumber(){
        String accountNumberSaving;
        Random random = new Random();

        do {
            accountNumberSaving = String.format("%08d", random.nextInt(100000000));
        }while (repository.existsByAccountNumber(accountNumberSaving) && checkingAccountRepository.existsByAccountNumber(accountNumberSaving));

        return accountNumberSaving;
    }




}
