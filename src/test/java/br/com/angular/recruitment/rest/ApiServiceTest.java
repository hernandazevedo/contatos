package br.com.angular.recruitment.rest;

import java.lang.reflect.Field;

import javax.ws.rs.core.Response;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.angular.recruitment.api.bean.Sms;
import br.com.angular.recruitment.api.enums.ResponsesEnum;
import br.com.angular.recruitment.api.exceptions.NegocioException;
import br.com.angular.service.SmsServiceBo;

@RunWith(MockitoJUnitRunner.class)
public class ApiServiceTest {

	
	private ApiService service;
	
	@Mock
	private SmsServiceBo smsServiceBo;
	
	@Before
	public void setUp() throws Exception {
		
		service = Mockito.spy(new ApiService());
		
		
		Class<?> clazz = ApiService.class;
		
		Field field = clazz.getDeclaredField("smsServiceBo");
		field.setAccessible(true);
		field.set(service, smsServiceBo);
	}
	
	
	@Test
	public void testeEnviarSmsOK(){
		Sms sms = new Sms(1,"5521973448438","5521975405717","Ola tudo bem?",null);
		
		Response response = service.sendSMS(sms);
		assertEquals(ResponsesEnum.HTTP_CREATED.getCode(), response.getStatus());
	}
	
	@Test
	public void testeEnviarSmsNegocioException(){
		
		Exception e = new NegocioException(ResponsesEnum.VALIDATION_EXCEPTION);
		
		
		Sms sms = new Sms(1,"5521973448438","5521975405717","Ola tudo bem?",null);
		
		Mockito.doThrow(e).when(smsServiceBo).enviar(Mockito.any(Sms.class));
		
		Response response = service.sendSMS(sms);
		
		assertEquals(ResponsesEnum.VALIDATION_EXCEPTION.getCode(), response.getStatus());
		
	}
	
	@Test
	public void testeEnviarSmsRuntimeException(){
		
		Exception e = new RuntimeException();
		
		
		Sms sms = new Sms(1,"5521973448438","5521975405717","Ola tudo bem?",null);
		
		Mockito.doThrow(e).when(smsServiceBo).enviar(Mockito.any(Sms.class));
		
		Response response = service.sendSMS(sms);
		
		assertEquals(ResponsesEnum.INTERNAL_SERVER_ERROR.getCode(), response.getStatus());
		
	}
}
