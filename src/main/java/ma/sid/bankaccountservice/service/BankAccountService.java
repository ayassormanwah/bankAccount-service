package ma.sid.bankaccountservice.service;

import ma.sid.bankaccountservice.dtos.BankAccountRequestDTO;
import ma.sid.bankaccountservice.dtos.BankAccountResponseDTO;

public interface BankAccountService {
    BankAccountResponseDTO AddAccount(BankAccountRequestDTO bankAccountRequestDTO);
}
