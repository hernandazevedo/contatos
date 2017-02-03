package br.com.angular.recruitment.api.converters;

import java.util.Date;

import br.com.angular.recruitment.api.bean.ContatoBean;
import br.com.angular.recruitment.api.entidades.Contato;

public class ContatoConverter {

	
	public static Contato convert(ContatoBean bean){
		Contato e = new Contato();
		e.setId(bean.getId());
		e.setNome(bean.getNome());
		if(bean.getOperadora() != null)
		e.setOperadora(OperadoraConverter.convert(bean.getOperadora()));
		
		e.setSerial(bean.getSerial());
		e.setTelefone(bean.getTelefone());
		e.setData(new Date(bean.getData()));
		
		return e;
	}
	
	public static ContatoBean convert(Contato e1){
		ContatoBean bean = new ContatoBean();
		bean.setId(e1.getId());
		bean.setNome(e1.getNome());
		if(e1.getOperadora() != null)
		bean.setOperadora(OperadoraConverter.convert(e1.getOperadora()));
		
		bean.setSerial(e1.getSerial());
		bean.setTelefone(e1.getTelefone());
		if(e1.getData() != null)
			bean.setData(e1.getData().getTime());
		
		return bean;
	}
}
