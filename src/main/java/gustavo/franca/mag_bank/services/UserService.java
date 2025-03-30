package gustavo.franca.mag_bank.services;

import gustavo.franca.mag_bank.domain.Address;
import gustavo.franca.mag_bank.domain.User;
import gustavo.franca.mag_bank.domain.dtos.UserDTO;
import gustavo.franca.mag_bank.repository.AddressRepository;
import gustavo.franca.mag_bank.repository.UserRepository;
import gustavo.franca.mag_bank.services.exceptions.AddressServiceException;
import gustavo.franca.mag_bank.services.exceptions.DataIntegrityViolationException;
import gustavo.franca.mag_bank.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;
    private final AddressRepository addressRepository;
    private final ApiViaCepService apiViaCepService;

    public UserService(UserRepository repository, AddressRepository addressRepository, ApiViaCepService apiViaCepService){
        this.repository = repository;
        this.addressRepository = addressRepository;
        this.apiViaCepService = apiViaCepService;
    }

    public List<User> findAll() {return repository.findAll();}

    public User findById(@Valid Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("User not found Id: " + id));
    }

    public User create(@Valid UserDTO objDTO) {
        objDTO.setId(null);
        validCpf(objDTO);
        User newObj = new User(objDTO);


        if (objDTO.getCep() != null && !objDTO.getCep().isEmpty()) {
            try {
                Address addressApi = apiViaCepService.getAddress(objDTO.getCep());

                Address address = addressRepository.findByCep(objDTO.getCep())
                        .orElseGet(() -> {
                            Address newAddress = new Address();
                            newAddress.setCep(objDTO.getCep());
                            newAddress.setLogradouro(addressApi.getLogradouro());
                            newAddress.setComplemento(addressApi.getComplemento());
                            newAddress.setBairro(addressApi.getBairro());
                            newAddress.setLocalidade(addressApi.getLocalidade());
                            newAddress.setUf(addressApi.getUf());
                            newAddress.setNumber(objDTO.getNumber());

                            return addressRepository.save(newAddress);
                        });

                newObj.setAddress(address);
            } catch (IOException | InterruptedException e) {
                throw new AddressServiceException("Erro ao buscar endereço na API ViaCEP", e);
            }
        }

        return repository.save(newObj);
    }

    public User update(@Valid Long id, UserDTO objDTO){
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

    public void delete(@Valid Long id){
        User obj = findById(id);
        if(hasLinkedAccounts(obj)){
            throw new DataIntegrityViolationException("Cannot delete user with linked accounts.");
        }
        repository.deleteById(id);
    }

    private void validCpf(UserDTO objDTO){
        Optional<User> obj = repository.findByCpf(objDTO.getCpf());
        if(obj.isPresent() && !obj.get().getId().equals(objDTO.getId())){
            throw new DataIntegrityViolationException("CPF already registered!");
        }
    }

    private boolean hasLinkedAccounts(User user){
        return user.getSavingAccount() != null || user.getCheckingAccount() != null;
    }
}
