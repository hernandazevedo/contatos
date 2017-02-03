package br.com.angular.recruitment.api.bean;

import java.io.Serializable;

public class ContatoBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String serial;
	
	private String nome;
	private String telefone;
	
	private OperadoraBean operadora;
	
	private long data;//milis

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public OperadoraBean getOperadora() {
		return operadora;
	}

	public void setOperadora(OperadoraBean operadora) {
		this.operadora = operadora;
	}

	public long getData() {
		return data;
	}

	public void setData(long data) {
		this.data = data;
	}
	
	
}
