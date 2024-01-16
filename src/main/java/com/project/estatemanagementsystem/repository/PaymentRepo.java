package com.project.estatemanagementsystem.repository;

import com.project.estatemanagementsystem.entity.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends CrudRepository<Payment, Long> {
    Payment findByTxnId(String txnId);
}

