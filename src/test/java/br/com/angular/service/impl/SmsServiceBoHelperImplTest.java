package br.com.angular.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.angular.recruitment.api.bean.Sms;
import br.com.angular.recruitment.api.exceptions.NegocioException;

@RunWith(MockitoJUnitRunner.class)
public class SmsServiceBoHelperImplTest {

	private SmsServiceBoHelperImpl service;
	
	
	@Before
	public void setUp() throws Exception {
		
		service = Mockito.spy(new SmsServiceBoHelperImpl());
		
	}
	
	
	@Test
	public void validarOk(){
		Sms sms = new Sms(1,"5521973448438","5521975405717","Ola tudo bem?","24/05/2017");
		service.validar(sms);
	}
	
	@Test(expected=NegocioException.class)
	public void validarBodyInvalido(){
		StringBuilder sbTamanhoInvalido = new StringBuilder();
		sbTamanhoInvalido.append("� um fato conhecido de todos que um leitor se distrair� com o conte�do de texto leg�vel de uma p�gina quando estiver examinando sua diagrama��o. A vantagem de usar Lorem Ipsum �");
		
		Sms sms = new Sms(1,"5521973448438","5521975405717",sbTamanhoInvalido.toString(),"24/05/2017");
		service.validar(sms);
	}

	@Test(expected=NegocioException.class)
	public void validarBodyNull(){
		
		Sms sms = new Sms(1,"5521973448438","5521975405717",null,"24/05/2017");
		service.validar(sms);
	}
	
	@Test(expected=NegocioException.class)
	public void validarBodyEmpty(){
		
		Sms sms = new Sms(1,"5521973448438","5521975405717","","24/05/2017");
		service.validar(sms);
	}
	
	
	@Test
	public void validarDataValidadeNull(){
		
		Sms sms = new Sms(1,"5521973448438","5521975405717","Ola tudo bem?",null);
		service.validar(sms);
	}
	
	@Test
	public void validarDataValidadeEmpty(){
		
		Sms sms = new Sms(1,"5521973448438","5521975405717","Ola tudo bem?","");
		service.validar(sms);
	}
	
	@Test(expected=NegocioException.class)
	public void validarDataValidadeInexistente(){
		
		Sms sms = new Sms(1,"5521973448438","5521975405717","Ola tudo bem?","9999/99/99");
		service.validar(sms);
	}
	
	@Test(expected=NegocioException.class)
	public void validarDataValidadeExpirada(){
		
		Sms sms = new Sms(1,"5521973448438","5521975405717","Ola tudo bem?","20/01/2016");
		service.validar(sms);
	}
	
	@Test(expected=NegocioException.class)
	public void validarFromNull(){
		
		Sms sms = new Sms(1,null,"5521975405717","Ola tudo bem?",null);
		service.validar(sms);
	}
	
	@Test(expected=NegocioException.class)
	public void validarFromEmpty(){
		
		Sms sms = new Sms(1,"","5521975405717","Ola tudo bem?",null);
		service.validar(sms);
	}
	
	@Test(expected=NegocioException.class)
	public void validarToNull(){
		
		Sms sms = new Sms(1,"5521973448438",null,"Ola tudo bem?",null);
		service.validar(sms);
	}
	
	@Test(expected=NegocioException.class)
	public void validarToEmpty(){
		
		Sms sms = new Sms(1,"5521973448438","","Ola tudo bem?",null);
		service.validar(sms);
	}
}
