package ma.sid.bankaccountservice.service;

import ma.sid.bankaccountservice.dtos.BankAccountRequestDTO;
import ma.sid.bankaccountservice.dtos.BankAccountResponseDTO;
import ma.sid.bankaccountservice.entites.BankAccount;
import ma.sid.bankaccountservice.mappers.AccountMapper;
import ma.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {
    final BankAccountRepository bankAccountRepository;
    final AccountMapper accountMapper;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = accountMapper.fromBankAccounRequestDTO(bankAccountRequestDTO);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        BankAccount savedAccount = bankAccountRepository.save(bankAccount);

        return accountMapper.fromBankAccount(savedAccount);
    }

    @Override
    public BankAccountResponseDTO getAccount(String id) {
        BankAccount bankAccount =  bankAccountRepository.findById(id).orElseThrow(() ->
                new RuntimeException(String.format("Account %s not found", id)));
        return accountMapper.fromBankAccount(bankAccount);
    }

    @Override
    public List<BankAccountResponseDTO> getAccounts() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        List<BankAccountResponseDTO> bankAccountResponseDTOS = new ArrayList<>();
        bankAccounts.forEach(bankAccount -> bankAccountResponseDTOS.add(accountMapper.fromBankAccount(bankAccount)));
        return bankAccountResponseDTOS;
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
        BeanUtils.copyProperties(bankAccountRequestDTO, bankAccount);
        BankAccount updatedAccount = bankAccountRepository.save(bankAccount);
        return accountMapper.fromBankAccount(updatedAccount);
    }

    @Override
    public void deleteAccount(String id) {
        bankAccountRepository.deleteById(id);
    }
}
