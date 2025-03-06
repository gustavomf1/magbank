package gustavo.franca.mag_bank.services;

import gustavo.franca.mag_bank.domain.User;
import gustavo.franca.mag_bank.domain.dtos.UserDTO;
import gustavo.franca.mag_bank.repository.UserRepository;
import gustavo.franca.mag_bank.services.exceptions.DataIntegrityViolationException;
import gustavo.franca.mag_bank.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public List<User> findAll() {return repository.findAll();}

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("User not found Id: " + id));
    }

    public User create(UserDTO objDTO){
        objDTO.setId(null);
        validaCpf(objDTO);

        User newObj = new User(objDTO);
        return repository.save(newObj);
    }

    public User update(Long id, UserDTO objDTO){
        objDTO.setId(id);
        User oldObj = findById(id);

        oldObj.setFullName(objDTO.getFullName());
        oldObj.setEmail(objDTO.getEmail());
        oldObj.setCpf(objDTO.getCpf());
        oldObj.setPassword(objDTO.getPassword());
        oldObj.setPhoneNumber(objDTO.getPhoneNumber());
        oldObj.setCheckingAccount(null);
        oldObj.setSavingAccount(null);

        return repository.save(oldObj);
    }

    public void delete(Long id){
        User obj = findById(id);
        if(hasLinkedAccounts(obj)){
            throw new DataIntegrityViolationException("Cannot delete user with linked accounts.");
        }
        repository.deleteById(id);
    }

    private void validaCpf(UserDTO objDTO){
        Optional<User> obj = repository.findByCpf(objDTO.getCpf());
        if(obj.isPresent() && !obj.get().getId().equals(objDTO.getId())){
            throw new DataIntegrityViolationException("CPF already registered!");
        }
    }

    private boolean hasLinkedAccounts(User user){
        return user.getSavingAccount() != null || user.getCheckingAccount() != null;
    }
}
