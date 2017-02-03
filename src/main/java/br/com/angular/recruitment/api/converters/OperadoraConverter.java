package br.com.angular.recruitment.api.converters;

import br.com.angular.recruitment.api.bean.OperadoraBean;
import br.com.angular.recruitment.api.entidades.Operadora;

public class OperadoraConverter {

	
	public static Operadora convert(OperadoraBean bean){
		Operadora e = new Operadora();
		e.setId(bean.getId());
		e.setNome(bean.getNome());
		e.setPreco(bean.getPreco());
		return e;
	}
	
	public static OperadoraBean convert(Operadora e1){
		OperadoraBean bean = new OperadoraBean();
		bean.setId(e1.getId());
		bean.setNome(e1.getNome());
		bean.setPreco(e1.getPreco());
		return bean;
	}
}
