package com.example.transactions.facade;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.transactions.repository.TransactionRepository;
import com.example.transactions.vo.TransactionVO;


@Service
public class TransactionFacade {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionFacade.class);
	
	@Autowired
	private TransactionRepository txnRepo;
	
	public void saveTxn(TransactionVO vo) throws Exception {
		try {
			txnRepo.save(vo);
		}catch(DataIntegrityViolationException e){
			LOGGER.error("Não foi possível salvar a transação: {} ", e);
			throw new DataIntegrityViolationException("Dados da transação inconsistentes.");
		}catch(Exception e) {
			throw new Exception("Não foi possível inserir transação. Tente novamente mais tarde.");
		}
	}
}
