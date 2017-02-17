/**
 * 
 */
package me.paddingdun.gen.code;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

/**
 * @author paddingdun
 *
 * Feb 17, 2017
 * @since 1.0
 * @version 1.0
 */
public class TestMail {

	public static void main(String[] args)throws Exception {
		Email email = new SimpleEmail();
		email.setHostName("smtp.isoftstone.com");
		email.setSmtpPort(25);
		email.setAuthenticator(new DefaultAuthenticator("kungaoa@isoftstone.com", ""));
//		email.setSSLOnConnect(true);
		email.setFrom("kungaoa@isoftstone.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("myzhangc@isoftstone.com");
		email.send();
	}
}
