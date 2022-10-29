package ma.sid.bankaccountservice.service;

import ma.sid.bankaccountservice.dtos.BankAccountRequestDTO;
import ma.sid.bankaccountservice.dtos.BankAccountResponseDTO;
import ma.sid.bankaccountservice.entites.BankAccount;
import ma.sid.bankaccountservice.mappers.AccountMapper;
import ma.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {
    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public BankAccountResponseDTO AddAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = accountMapper.formBankAccounRequestDTO(bankAccountRequestDTO);

        BankAccount savedAccount = bankAccountRepository.save(bankAccount);

        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedAccount);
        return bankAccountResponseDTO;
    }
}
