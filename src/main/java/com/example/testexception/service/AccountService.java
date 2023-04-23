package com.example.testexception.service;

import com.example.testexception.exception.AccountNotFound;
import com.example.testexception.exception.NotFoundException;
import com.example.testexception.model.Account;
import com.example.testexception.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public void delete(Long id) {
        try {
            accountRepository.deleteById(id);

        }catch (Exception e){
            throw new NotFoundException("123123124", "123", "11", "This is id not found");
        }
    }

    public Account getByInn(String inn) {
           accountRepository.findByInn(inn);
           if (accountRepository.findByInn(inn) != null) {
               return accountRepository.findByInn(inn);
           }else {
               throw new NotFoundException("123123124", inn, "11", "This is inn not found");
           }
    }

    public List<Account> getAll() {
       List<Account> accounts = accountRepository.findAll();
        if (accounts.size()!=0) {
            return accountRepository.findAll();
    }else {
            throw new NotFoundException("123123124", "123", "11", "Accounts not found");
        }
    }

    public Account getById(Long id) throws AccountNotFound{
      return accountRepository.findById(id).orElseThrow(() -> new NotFoundException("123123124", "123", "11", "Account not found"));

    }
}
