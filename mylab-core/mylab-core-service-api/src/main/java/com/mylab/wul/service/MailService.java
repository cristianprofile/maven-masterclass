package com.mylab.wul.service;

import com.mylab.wul.dto.MailRequest;

public interface MailService {

    /**
     * Method to send an email whith information request
     * @param mailrequest mail request to send by email protocol
     */
    public void sendMail(MailRequest mailrequest);

}
