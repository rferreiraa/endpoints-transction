package com.example.transactions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.transactions.enums.CardApplicationEnum;
import com.example.transactions.enums.StatusEnum;
import com.example.transactions.facade.TransactionFacade;
import com.example.transactions.vo.TransactionVO;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionFacade txnFacade;
	
	@PostMapping("/save")
	public @ResponseBody ResponseEntity<Object> saveTxn(@RequestBody TransactionVO vo) {
		try{
			vo.setCardApplication(CardApplicationEnum.getByKey(vo.getCardApplication()));
			vo.setStatus(StatusEnum.getByKey(vo.getStatus()));
			txnFacade.saveTxn(vo);
			return ResponseEntity.ok("Inserido com sucesso");
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping("/update")
	public @ResponseBody ResponseEntity<Object> updateTxn(@RequestBody TransactionVO vo) {
		try{
			vo.setCardApplication(CardApplicationEnum.getByKey(vo.getCardApplication()));
			vo.setStatus(StatusEnum.getByKey(vo.getStatus()));
			txnFacade.saveTxn(vo);
			return ResponseEntity.ok("Atualizado com sucesso");
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/all")
	public Iterable<TransactionVO> listAllTransactions(){
		return txnFacade.listTxns();
	}
}
