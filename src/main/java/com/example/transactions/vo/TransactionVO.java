package com.example.transactions.vo;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="transaction")
public class TransactionVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TXN_SEQUENCE_ID")
	@Column(name="ID_TXN")
	private Long idTxn;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name="DATE")
	private LocalDate date;
	
	@JsonFormat(pattern = "HH:mm:ss")
	@Column(name="TIME")
	private LocalTime time;
	
	@Column(name="VALUE")
	private Double value;
	
	@Column(name="ID_CARD_APPLICATION")
	private Long cardApplication;
	
	@Column(name="ID_STATUS")
	private Long status;

	@Transient
	private String dscStatus;
	
	@Transient
	private String dscCardApp;
	
}
