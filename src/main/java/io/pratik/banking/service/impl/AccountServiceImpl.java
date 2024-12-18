package io.pratik.banking.service.impl;

import io.pratik.banking.AccountRepository;
import io.pratik.banking.dto.AccountDto;
import io.pratik.banking.entity.Account;
import io.pratik.banking.mapper.AccountMapper;
import io.pratik.banking.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;


    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.mapTOAccount(accountDto);
       Account savedAccount = accountRepository.save(account);
        return null;
    }
}
