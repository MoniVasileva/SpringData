package com.example.springinitboot.services;

import com.example.springinitboot.models.Account;
import com.example.springinitboot.repositorities.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isEmpty()) {
            throw new RuntimeException("Account doesn't exist");
        }
        BigDecimal current = account.get().getBalance();
        if (amount.compareTo(current) > 0) {
            throw new RuntimeException("Cannot withdraw");
        }
        account.get().setBalance(current.subtract(amount));
        this.accountRepository.save(account.get());

    }

    @Override
    public void depositMoney(BigDecimal amount, Long id) {
        Account account = this.accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sorry no account"));

        BigDecimal balance = account.getBalance();
        BigDecimal add = balance.add(amount);
        account.setBalance(add);

        this.accountRepository.save(account);
    }
}
