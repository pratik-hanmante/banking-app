package io.pratik.banking.mapper;

import io.pratik.banking.dto.AccountDto;
import io.pratik.banking.entity.Account;

import java.util.Objects;

/**
 * A utility class for mapping between Account and AccountDto.
 */
public class AccountMapper {

    /**
     * Maps an AccountDto to an Account entity.
     *
     * @param accountDto the DTO to map from (must not be null).
     * @return the corresponding Account entity.
     * @throws NullPointerException if accountDto is null.
     */
    public static Account mapToAccount(AccountDto accountDto) {
        Objects.requireNonNull(accountDto, "AccountDto must not be null");

        return new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
    }

    /**
     * Maps an Account entity to an AccountDto.
     *
     * @param account the entity to map from (must not be null).
     * @return the corresponding AccountDto.
     * @throws NullPointerException if account is null.
     */
    public static AccountDto mapToAccountDto(Account account) {
        Objects.requireNonNull(account, "Account must not be null");

        return new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
    }
}