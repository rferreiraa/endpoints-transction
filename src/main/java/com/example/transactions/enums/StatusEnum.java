package com.example.transactions.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {
	
	SUCCESS(1L, "SUCESS"),
	PENDING(2L, "PENDING"),
	CANCELED(3L, "CANCELED"),
	FAILED(4L, "FAILED");

	private Long idStatus;
	private String dscStatus;
	
	StatusEnum(long codigo, String chave) {
		this.idStatus = codigo;
		this.dscStatus = chave;		
	}
	
	public static StatusEnum getByChave(String chave) {
		for (StatusEnum s : StatusEnum.values()) {
			if(s.toString().equals(chave))
				return s;
		}
		return null;
	}
}
