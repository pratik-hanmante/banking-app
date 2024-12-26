package io.pratik.banking.mapper;

import io.pratik.banking.dto.AccountDto;
import io.pratik.banking.entity.Account;

import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * A utility class for mapping between Account and AccountDto.
 */
public final class AccountMapper {

    private static final Logger LOGGER = Logger.getLogger(AccountMapper.class.getName());

    
    private AccountMapper() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    
    public static Optional<Account> mapToAccount(AccountDto accountDto) {
        if (accountDto == null) {
            LOGGER.warning("AccountDto is null, returning empty Optional");
            return Optional.empty();
        }

        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );

        LOGGER.info("Mapped AccountDto to Account: " + account);
        return Optional.of(account);
    }

   
    public static Optional<AccountDto> mapToAccountDto(Account account) {
        if (account == null) {
            LOGGER.warning("Account is null, returning empty Optional");
            return Optional.empty();
        }

        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );

        LOGGER.info("Mapped Account to AccountDto: " + accountDto);
        return Optional.of(accountDto);
    }
}