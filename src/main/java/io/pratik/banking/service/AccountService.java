package io.pratik.banking.service;

import io.pratik.banking.dto.AccountDto;

public interface AccountService {

    AccountDto createAccount(AccountDto accountSDto);
}
