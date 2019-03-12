package com.abc.bankapp1;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class FPController extends HttpServlet 
{
	public void service(HttpServletRequest x, HttpServletResponse y)
	{
		try
		{
		String toEmailID=x.getParameter("toEmail");
		final String fromEmail="kasturi.shekar12@gmail.com";
		final String password="GeekMachineS";
		//final String toEmail="toEmailID";
		HttpSession hs=x.getSession();
		hs.setAttribute("toEmail", toEmailID);
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");//ipaddress
		prop.put("mail.smtp.port", 587);//port number
		prop.put("mail.smtp.auth", "true");//authentication
		prop.put("mail.smtp.starttls.enable", "true");//encryption

		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(fromEmail, password);
			}
		});
		
		MimeMessage mesg = new MimeMessage(session);
		mesg.setFrom(new InternetAddress(fromEmail));
		mesg.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmailID));
		mesg.setSubject("DO NOT REPLY TO THIS EMAIL");  
		mesg.setText("http://localhost:9090/BankApp1/NewPassword.jsp");  
		Transport.send(mesg);
		y.sendRedirect("/BankApp1/SuccessMail.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}