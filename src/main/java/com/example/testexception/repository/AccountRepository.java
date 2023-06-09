package com.example.testexception.repository;

import com.example.testexception.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

        Account findByInn(String inn);

}
