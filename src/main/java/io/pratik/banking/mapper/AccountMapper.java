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

    // Private constructor to prevent instantiation
    private AccountMapper() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Maps an AccountDto to an Account entity.
     *
     * @param accountDto the DTO to map from (must not be null).
     * @return the corresponding Account entity, or an empty Optional if accountDto is null.
     */
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

    /**
     * Maps an Account entity to an AccountDto.
     *
     * @param account the entity to map from (must not be null).
     * @return the corresponding AccountDto, or an empty Optional if account is null.
     */
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