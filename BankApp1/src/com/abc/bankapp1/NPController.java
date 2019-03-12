package com.abc.bankapp1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NPController extends HttpServlet
{
	public void service(HttpServletRequest x, HttpServletResponse y)
	{
		try
		{
			String newpassword=x.getParameter("newpassword");
			String confirmnewpassword=x.getParameter("confirmnewpassword");
			if(newpassword.equals(confirmnewpassword)==true)
			{
				HttpSession hs=x.getSession();
				String toEmail=(String) hs.getAttribute("toEmail");
				Model m=new Model();
				m.setNewpassword(newpassword);
				m.setToEmail(toEmail);
				boolean b=m.forgotPassword();
				if(b==true)
				{
					y.sendRedirect("/BankApp1/NewPasswordSuccess.jsp");
				}
				else
				{
					y.sendRedirect("/BankApp1/NewPasswordFailure.jsp");
				}
			}
			else
			{
				y.sendRedirect("/BankApp1/ErrorNewPassword.jsp");
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
}