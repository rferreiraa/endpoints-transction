package com.example.transactions.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {
	
	SUCCESS,
	PENDING,
	CANCELED,
	FAILED;

	public static String getByKey(String chave) {
		for (StatusEnum s : StatusEnum.values()) {
			if(s.toString().equals(chave))
				return s.name();
		}
		return null;
	}
}
