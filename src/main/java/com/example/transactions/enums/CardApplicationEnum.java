package com.example.transactions.enums;

import lombok.Getter;

@Getter
public enum CardApplicationEnum {

	DEBITO(1L, "DEBITO"),
	CREDITO(2L, "CREDITO"),
	VOUCHER(3L, "VOUCHER");

	private Long idCardApp;
	private String dscCardApp;
	
	CardApplicationEnum(long codigo, String chave) {
		this.idCardApp = codigo;
		this.dscCardApp = chave;		
	}
	
	public static CardApplicationEnum getByChave(String chave) {
		for (CardApplicationEnum c : CardApplicationEnum.values()) {
			if(c.toString().equals(chave))
				return c;
		}
		return null;
	}
}
