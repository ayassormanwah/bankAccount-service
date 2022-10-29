package ma.sid.bankaccountservice.web;

import ma.sid.bankaccountservice.dtos.BankAccountRequestDTO;
import ma.sid.bankaccountservice.dtos.BankAccountResponseDTO;
import ma.sid.bankaccountservice.entites.BankAccount;
import ma.sid.bankaccountservice.mappers.AccountMapper;
import ma.sid.bankaccountservice.repositories.BankAccountRepository;
import ma.sid.bankaccountservice.service.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/epi")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private BankAccountService bankAccountService;
    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepository bankAccountRepository, BankAccountService bankAccountService) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/bankaccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankaccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Account %s not found", id)
                ));
    }

    @PostMapping("/bankaccount")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO) {
        return bankAccountService.AddAccount(requestDTO);
    }

    @PatchMapping("/bankaccount/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount account = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Account %s not found", id)
                ));
        return bankAccountRepository.save(bankAccount);
    }

    @DeleteMapping("bankaccount/{id}")
    public void delete(@PathVariable String id) {
        bankAccountRepository.deleteById(id);
    }
}