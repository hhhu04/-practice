package com.example.security.repository;

import com.example.security.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {

    Account findByUsername(String username);



}
