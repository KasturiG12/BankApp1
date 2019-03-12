package com.abc.bankapp1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class BalanceController extends HttpServlet
{
	public void service(HttpServletRequest x, HttpServletResponse y)
	{
		try
		{
			HttpSession hs=x.getSession();
			int accno=(int) hs.getAttribute("ACCNO");
			Model m=new Model();
			m.setAccno(accno);
			boolean b=m.checkBalance();
			if(b==true)
			{
				hs=x.getSession();
				hs.setAttribute("BALANCE", m.getBalance());
				y.sendRedirect("/BankApp1/BalanceSuccess.jsp");
			}
			else
			{
				y.sendRedirect("/BankApp1/BalanceFailure.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		}
}