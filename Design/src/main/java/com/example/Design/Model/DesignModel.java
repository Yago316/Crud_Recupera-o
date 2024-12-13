package com.example.Design.Model;

import com.example.Design.Dto.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "design")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DesignModel {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String tipo;
	private String descricao;
	private String criador;
	
	public DesignModel(Dto Resquest) {
		this.criador = Resquest.criador();
		this.descricao = Resquest.descricao();
		this.nome = Resquest.nome();
		this.tipo = Resquest.tipo();
	}
	
	
}
