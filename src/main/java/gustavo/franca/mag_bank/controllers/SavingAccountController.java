package gustavo.franca.mag_bank.controllers;

import gustavo.franca.mag_bank.domain.SavingAccount;
import gustavo.franca.mag_bank.domain.dtos.SavingAccountDTO;
import gustavo.franca.mag_bank.services.SavingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/savingaccounts")
public class SavingAccountController {

    private final SavingAccountService service;

    public SavingAccountController(SavingAccountService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SavingAccountDTO>> findAll(){
        List<SavingAccount> list = service.findAll();
        List<SavingAccountDTO> listDTO = list.stream().map(obj -> new SavingAccountDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SavingAccountDTO> findById(@PathVariable Long id){
        SavingAccount obj = service.finById(id);

        return ResponseEntity.ok().body(new SavingAccountDTO(obj));
    }

    @PostMapping
    public ResponseEntity<SavingAccountDTO> create(@RequestBody SavingAccountDTO objDTO){
        SavingAccount newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }



}
