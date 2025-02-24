package gustavo.franca.mag_bank.controllers;

import gustavo.franca.mag_bank.domain.SavingAccount;
import gustavo.franca.mag_bank.domain.dtos.SavingAccountDTO;
import gustavo.franca.mag_bank.services.SavingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/savingaccounts")
public class SavingAccountController {

    @Autowired
    private SavingAccountService service;

    @GetMapping
    public ResponseEntity<List<SavingAccountDTO>> findAll(){
        List<SavingAccount> list = service.findAll();
        List<SavingAccountDTO> listDTO = list.stream().map(obj -> new SavingAccountDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);
    }


}
