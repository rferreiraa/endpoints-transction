package com.example.transactions.enums;

import lombok.Getter;

@Getter
public enum CardApplicationEnum {

	DEBITO,
	CREDITO,
	VOUCHER;
	
	
	public static String getByKey(String chave) {
		for (CardApplicationEnum c : CardApplicationEnum.values()) {
			if(c.toString().equals(chave))
				return c.name();
		}
		return null;
	}
}
