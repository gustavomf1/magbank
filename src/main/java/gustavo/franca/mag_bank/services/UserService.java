package gustavo.franca.mag_bank.services;

import gustavo.franca.mag_bank.domain.User;
import gustavo.franca.mag_bank.domain.dtos.UserDTO;
import gustavo.franca.mag_bank.repository.UserRepository;
import gustavo.franca.mag_bank.services.exceptions.DataIntegrityViolationException;
import gustavo.franca.mag_bank.services.exceptions.ObjectNotFoundExcpetion;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {return repository.findAll();}

    public User findByiD(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExcpetion("Objeto não econtrado! Id: " + id));
    }

    public User create(UserDTO objDTO){
        objDTO.setId(null);
        validaCpf(objDTO);

        User newObj = new User(objDTO);
        return repository.save(newObj);
    }

    public User update(Long id, UserDTO objDTO){
        objDTO.setId(id);
        User oldObj = findByiD(id);

        if(oldObj == null){
            throw new ObjectNotFoundExcpetion("Usuário não encontrado com ID: " + id);
        }

        oldObj.setFullName(objDTO.getFullName());
        oldObj.setEmail(objDTO.getEmail());
        oldObj.setCpf(objDTO.getCpf());
        oldObj.setPassword(objDTO.getPassword());
        oldObj.setPhoneNumber(objDTO.getPhoneNumber());

        return repository.save(oldObj);
    }

    public void delete(Long id){
        User obj = findByiD(id);

        repository.deleteById(id);
    }

    private void validaCpf(UserDTO objDTO){
        Optional<User> obj = repository.findByCpf(objDTO.getCpf());
        if(obj.isPresent() && !obj.get().getId().equals(objDTO.getId())){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }
    }
}
