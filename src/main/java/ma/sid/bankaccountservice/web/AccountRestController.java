package ma.sid.bankaccountservice.web;

import ma.sid.bankaccountservice.dtos.BankAccountRequestDTO;
import ma.sid.bankaccountservice.dtos.BankAccountResponseDTO;
import ma.sid.bankaccountservice.service.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/epi")
public class AccountRestController {
    final BankAccountService bankAccountService;

    public AccountRestController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/accounts")
    public List<BankAccountResponseDTO> getBankAccounts() {
        return bankAccountService.getAccounts();
    }

    @GetMapping("/accounts/{id}")
    public BankAccountResponseDTO getBankAccount(@PathVariable String id) {
        return bankAccountService.getAccount(id);
    }

    @PostMapping("/account")
    public BankAccountResponseDTO saveBankAccount(@RequestBody BankAccountRequestDTO requestDTO) {
        return bankAccountService.addAccount(requestDTO);
    }

    @PatchMapping("/account/{id}")
    public BankAccountResponseDTO updateBankAccount(@PathVariable String id, @RequestBody BankAccountRequestDTO requestDTO) {
        return bankAccountService.updateAccount(id, requestDTO);
    }

    @DeleteMapping("account/{id}")
    public void deleteBankAccount(@PathVariable String id) {
        bankAccountService.deleteAccount(id);
    }
}