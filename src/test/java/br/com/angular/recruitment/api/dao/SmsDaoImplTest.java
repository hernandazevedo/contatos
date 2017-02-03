package br.com.angular.recruitment.api.dao;

import java.lang.reflect.Field;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.angular.recruitment.api.dao.impl.SmsDaoImpl;
import br.com.angular.recruitment.api.entidades.Sms;
import br.com.angular.recruitment.api.exceptions.PersistenciaException;

@RunWith(MockitoJUnitRunner.class)
public class SmsDaoImplTest {

	
	private SmsDaoImpl service;
	
	@Mock
	private EntityManager entityManager;
	
	
	
	@Before
	public void setUp() throws Exception {
		
		service = Mockito.spy(new SmsDaoImpl());
		
		
		Class<?> clazz = SmsDaoImpl.class;
		
		Field field = clazz.getDeclaredField("entityManager");
		field.setAccessible(true);
		field.set(service, entityManager);
	}
	
	@Test
	public void saveOK(){
		Sms sms = getSmsValido();
		service.save(sms);
		
		Mockito.verify(entityManager,Mockito.times(1)).persist(sms);
		Mockito.verify(entityManager,Mockito.times(1)).flush();
	}
	
	@Test(expected=PersistenciaException.class)
	public void saveException(){
		Sms sms = getSmsValido();
		Mockito.doThrow(new PersistenciaException()).when(entityManager).persist(Mockito.any(Sms.class));
		service.save(sms);

	}


	private Sms getSmsValido() {

		Sms sms = new Sms();
		sms.setBody("Ola tudo bem?");
		sms.setId(1);
		sms.setFrom("5521973448438");
		sms.setTo("5521975405717");
		return sms;
	}
	
}
