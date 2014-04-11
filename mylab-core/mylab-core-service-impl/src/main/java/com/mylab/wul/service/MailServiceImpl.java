package com.mylab.wul.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.mylab.wul.dto.MailRequest;

@Service
public class MailServiceImpl implements MailService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MailSender mailSender;

	@Override
	public void sendMail(MailRequest mailrequest) {
		this.logger.debug("Begin operation: sending mail, request:{} ",mailrequest);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mailrequest.getTo());
		message.setSubject(mailrequest.getSubject());
		message.setText(mailrequest.getBody());
		mailSender.send(message);
		this.logger.debug("End operation: sending mail, request:{} ",mailrequest);
	}
}
