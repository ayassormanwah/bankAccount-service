package ma.sid.bankaccountservice.service;

import ma.sid.bankaccountservice.dtos.BankAccountRequestDTO;
import ma.sid.bankaccountservice.dtos.BankAccountResponseDTO;

import java.util.List;

public interface BankAccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);
    BankAccountResponseDTO getAccount(String id);
    List<BankAccountResponseDTO> getAccounts();
    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO);
    void deleteAccount(String id);
}
