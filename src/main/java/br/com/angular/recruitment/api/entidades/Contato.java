package br.com.angular.recruitment.api.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contato")
public class Contato implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
 
  <td>{{contato.serial}}</td>
				<td>{{contato.nome | name | ellipsis:10}}</td>
				<td>{{contato.telefone}}</td>
				<td>{{contato.operadora.nome}}</td>
				<td>{{contato.data | date:'dd/MM/yyyy'}}</td>
 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="contato_id")
	private Long id;
	
	@Column(name="contato_serial")
	private String serial;
	
	@Column(name="contato_nome")
	private String nome;
	@Column(name="contato_telefone")
	private String telefone;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="contato_operadora_id")
	private Operadora operadora;
	
	@Column(name="contato_data")
	private Date data;

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

	public Operadora getOperadora() {
		return operadora;
	}

	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", serial=" + serial + ", nome=" + nome + ", telefone=" + telefone + ", operadora="
				+ operadora + ", data=" + data + "]";
	}
	
	
}
