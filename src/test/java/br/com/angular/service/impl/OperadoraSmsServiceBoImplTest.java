package br.com.angular.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.angular.recruitment.api.bean.Sms;

@RunWith(MockitoJUnitRunner.class)
public class OperadoraSmsServiceBoImplTest {

	private OperadoraServiceBoImpl service;
	
	@Before
	public void setUp() throws Exception {
		
		service = Mockito.spy(new OperadoraServiceBoImpl());
		
	}
	
	@Test
	public void sendOK(){
		Sms sms = new Sms(1,"5521973448438","5521975405717","Ola tudo bem?",null);
		service.send(sms);
	}
}
