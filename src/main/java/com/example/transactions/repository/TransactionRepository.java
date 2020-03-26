package com.example.transactions.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.transactions.vo.TransactionVO;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionVO, Integer> {

}
