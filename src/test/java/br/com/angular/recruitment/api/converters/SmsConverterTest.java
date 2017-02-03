package br.com.angular.recruitment.api.converters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;

import br.com.angular.recruitment.api.bean.Sms;

@RunWith(MockitoJUnitRunner.class)
public class SmsConverterTest {

	

	@Test
	public void testeConvert(){
		Sms smsBean = new Sms(1,"5521973448438","5521975405717","Ola tudo bem?","24/05/2017");
		br.com.angular.recruitment.api.entidades.Sms smsEntidade = SmsConverter.convert(smsBean);
		
		
		assertNotNull(smsEntidade);
		assertEquals(smsEntidade.getBody(), smsBean.getBody());
		assertEquals(smsEntidade.getFrom(), smsBean.getFrom());
		assertEquals(smsEntidade.getTo(), smsBean.getTo());
		assertEquals(smsEntidade.getValidade(), smsBean.getValidade());
		
		
	}
	
	
}
