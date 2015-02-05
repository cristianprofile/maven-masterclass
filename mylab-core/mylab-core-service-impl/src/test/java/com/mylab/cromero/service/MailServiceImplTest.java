package com.mylab.cromero.service;

import javax.mail.MessagingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.subethamail.wiser.Wiser;

import com.mylab.cromero.dto.MailRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "dev")
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext-service-test.xml")
public class MailServiceImplTest {

	// @Autowired
	// private MailService mailService;

	@Autowired
	private Wiser wiser;

	@Before
	public void setup() {
		wiser.start();
	}

	@Transactional
	@Test
	public void testMailOk() throws MessagingException {

		MailRequest mailrequest = new MailRequest();
		mailrequest.setBody("un saludo tio mi primero correo");
		mailrequest.setSubject("mi primero correo de palo");
		mailrequest.setTo("pepito@ole.com");
		// mailService.sendMail(mailrequest);
		// List<WiserMessage> messages = wiser.getMessages();
		// Assert.assertEquals(messages.size(), 1);
		// Assert.assertNotNull(messages.get(0).getMimeMessage());
		// Assert.assertTrue(messages.get(0).getMimeMessage().getSubject()
		// .equalsIgnoreCase("mi primero correo de palo"));

	}

}
