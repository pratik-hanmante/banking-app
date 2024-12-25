package io.pratik.banking.service.impl;

import io.pratik.banking.AccountRepository;
import io.pratik.banking.dto.AccountDto;
import io.pratik.banking.entity.Account;
import io.pratik.banking.mapper.AccountMapper;
import io.pratik.banking.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(@Valid AccountDto accountDto) {
        log.info("Creating account for: {}", accountDto);

        // Validate input
        if (accountDto == null) {
            log.error("AccountDto cannot be null");
            throw new IllegalArgumentException("AccountDto cannot be null");
        }

        try {
            // Map DTO to entity
            Account account = AccountMapper.mapToAccount(accountDto);
            
            // Save account entity
            Account savedAccount = accountRepository.save(account);
            log.info("Account successfully created with ID: {}", savedAccount.getId());
            
            
            return AccountMapper.mapToAccountDto(savedAccount);
        } catch (Exception e) {
            log.error("following error occurred : {}", e.getMessage(), e);
            throw new RuntimeException("Error creating account", e);
        }
    }
}