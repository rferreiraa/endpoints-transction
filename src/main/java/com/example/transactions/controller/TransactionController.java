package com.example.transactions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.transactions.enums.CardApplicationEnum;
import com.example.transactions.enums.StatusEnum;
import com.example.transactions.facade.TransactionFacade;
import com.example.transactions.vo.TransactionVO;

@RestController
@RequestMapping("/txn")
public class TransactionController {
	
	@Autowired
	private TransactionFacade txnFacade;
	
	@PostMapping("/save")
	public @ResponseBody ResponseEntity<Object> saveTxn(@RequestBody TransactionVO vo) {
		try{
			vo.setStatus(StatusEnum.getByChave(vo.getDscStatus()).getIdStatus());
			vo.setCardApplication(CardApplicationEnum.getByChave(vo.getDscCardApp()).getIdCardApp());
			txnFacade.saveTxn(vo);
			return ResponseEntity.ok("Inserido com sucesso");
		}catch(DataIntegrityViolationException e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados da transação inconsistentes.");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível inserir transação. Tente novamente mais tarde.");
		}

		
	}
}
