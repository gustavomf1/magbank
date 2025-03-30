package gustavo.franca.mag_bank.repository;

import gustavo.franca.mag_bank.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository <Address, Long>{
    Optional<Address> findByCep(String cep);
}
