package br.com.angular.service.impl;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.angular.recruitment.api.bean.Sms;
import br.com.angular.recruitment.api.dao.SmsDao;
import br.com.angular.recruitment.api.enums.ResponsesEnum;
import br.com.angular.recruitment.api.exceptions.NegocioException;
import br.com.angular.recruitment.api.exceptions.PersistenciaException;
import br.com.angular.service.OperadoraServiceBo;
import br.com.angular.service.SmsServiceBoHelper;

@RunWith(MockitoJUnitRunner.class)
public class SmsServiceBoImplTest {

	
	private SmsServiceBoImpl service;
	
	@Mock
	private SmsDao smsDao;
	@Mock
	private OperadoraServiceBo operadoraSmsServiceBo;
	
	@Mock
	SmsServiceBoHelper smsServiceBoHelper;
	
	@Before
	public void setUp() throws Exception {
		
		service = Mockito.spy(new SmsServiceBoImpl());
		
		
		Class<?> clazz = SmsServiceBoImpl.class;
		
		Field field = clazz.getDeclaredField("smsDao");
		field.setAccessible(true);
		field.set(service, smsDao);
		
		field = clazz.getDeclaredField("operadoraSmsServiceBo");
		field.setAccessible(true);
		field.set(service, operadoraSmsServiceBo);
		
		field = clazz.getDeclaredField("smsServiceBoHelper");
		field.setAccessible(true);
		field.set(service, smsServiceBoHelper);
	}
	

	
	@Test
	public void enviarOK(){

		Sms sms = new Sms(1,"5521973448438","5521975405717","Ola tudo bem?",null);
		
		service.enviar(sms);

		
		Mockito.verify(smsServiceBoHelper,Mockito.times(1)).validar(Mockito.any(Sms.class));
		Mockito.verify(operadoraSmsServiceBo,Mockito.times(1)).send(Mockito.any(Sms.class));
		Mockito.verify(smsDao,Mockito.times(1)).save(Mockito.any(br.com.angular.recruitment.api.entidades.Sms.class));
		
	}
	

	@Test(expected=NegocioException.class)
	public void enviarPersistenceException(){
		Exception e = new PersistenciaException();
		Sms sms = new Sms(1,"5521973448438","5521975405717","Ola tudo bem?",null);
		
		Mockito.doThrow(e).when(smsDao).save(Mockito.any(br.com.angular.recruitment.api.entidades.Sms.class));
		service.enviar(sms);
		
	}
	
	@Test(expected=NegocioException.class)
	public void enviarNegocioException(){
		Exception e = new NegocioException(ResponsesEnum.MOBILE_USER_NOT_FOUND);
		Sms sms = new Sms(1,"5521973448438","5521975405717","Ola tudo bem?",null);
		
		Mockito.doThrow(e).when(smsDao).save(Mockito.any(br.com.angular.recruitment.api.entidades.Sms.class));
		service.enviar(sms);
		
	}
	

	@Test(expected=NegocioException.class)
	public void enviarRuntimeException(){
		Exception e = new RuntimeException();
		Sms sms = new Sms(1,"5521973448438","5521975405717","Ola tudo bem?",null);
		
		Mockito.doThrow(e).when(smsDao).save(Mockito.any(br.com.angular.recruitment.api.entidades.Sms.class));
		service.enviar(sms);
		
	}

}
