package com.abc.bankapp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Model 
{
	private Connection con=null;//import from java.sql
	private ResultSet res=null;//java.sql
	private PreparedStatement pstmt=null;//java.sql
	
	private int id=0;
	private int accno=0;
	private String password=null;
	private String name=null;
	
	private int tpaccno=0;
	private int transamt=0;
	private int balance=0;
	
	private String op=null;
	private String np=null;
	
	private String newpassword=null;
	private String toEmail=null;
	
	
	public String getOp() {
		return op;
	}


	public String getNp() {
		return np;
	}


	public void setOp(String op) {
		this.op = op;
	}


	public void setNp(String np) {
		this.np = np;
	}


	public void setCon(Connection con) {
		this.con = con;
	}


	public void setRes(ResultSet res) {
		this.res = res;
	}


	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setAccno(int accno) {
		this.accno = accno;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Connection getCon() {
		return con;
	}


	public ResultSet getRes() {
		return res;
	}


	public PreparedStatement getPstmt() {
		return pstmt;
	}


	public int getId() {
		return id;
	}


	public int getAccno() {
		return accno;
	}


	public String getPassword() {
		return password;
	}


	public String getName() {
		return name;
	}

	public int getTpaccno() {
		return tpaccno;
	}


	public void setTpaccno(int tpaccno) {
		this.tpaccno = tpaccno;
	}


	public int getTransamt() {
		return transamt;
	}


	public void setTransamt(int transamt) {
		this.transamt = transamt;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}


	public String getNewpassword() {
		return newpassword;
	}


	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}


	public String getToEmail() {
		return toEmail;
	}


	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}


	Model()
	{
		try
		{
		    DAOModel d=new DAOModel();
			con=d.getConnection();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	boolean login()
	{
		try
		{
		pstmt=con.prepareStatement(" select * from BANK1 where CUSTOMERID=?  and PASSWORD=?");
		pstmt.setInt(1, id);
		pstmt.setString(2, password);
		res=pstmt.executeQuery();
		
		while(res.next()==true)
		{
			name=res.getString(5);
			accno=res.getInt(1);
			return true;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return false;
	}
	
	boolean transfer()
	{
		try
		{
			pstmt=con.prepareStatement("update BANK1 set BALANCE = BALANCE - ? where ACCNO=?");//sender
			pstmt.setInt(1, transamt);
			pstmt.setInt(2, accno);
			pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("update BANK1 set BALANCE = BALANCE + ? where ACCNO=?");//reciepient
			pstmt.setInt(1, transamt);
			pstmt.setInt(2, tpaccno);
			pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("insert into TRANSACTION values(?,?)"); //reciepient
			pstmt.setInt(1, accno);
			pstmt.setInt(2, transamt);
			pstmt.executeUpdate();
			return true;
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	boolean checkBalance()
	{
		try
		{
			pstmt=con.prepareStatement("select * from BANK1 where ACCNO=?");
			pstmt.setInt(1, accno);
			res=pstmt.executeQuery();
			while(res.next()==true)
			{
				balance=res.getInt(9);
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	boolean changePassword()
	{
		try
		{
			pstmt=con.prepareStatement(" update BANK1 set PASSWORD=? where PASSWORD=?");
			pstmt.setString(1, np);
			pstmt.setString(2, op);
			pstmt.executeUpdate();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	boolean forgotPassword()
	{
		try
		{
			pstmt=con.prepareStatement("update BANK1 set PASSWORD=? where EMAIL=?");
			pstmt.setString(1, newpassword);
			pstmt.setString(2, toEmail);
			pstmt.executeQuery();
			return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	ArrayList Statement()
	{
		try
		{
			pstmt=con.prepareStatement("select * from TRANSACTION where ACCNO=?");
			pstmt.setInt(1, accno);
			res=pstmt.executeQuery();
			ArrayList al=new ArrayList();
			while(res.next()==true)
			{
				al.add(res.getInt(2));
			}
			return al;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


}

