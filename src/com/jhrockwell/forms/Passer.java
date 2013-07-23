package com.jhrockwell.forms;
import java.io.Serializable;

public class Passer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	String _name;
	String _address;
	String _phone;
	String _email;
	Boolean _newsletters;
	
	public void setName(String name)
	{
		_name = name;
	}
	public String Name()
	{
		return _name;
	}
	
	public void setAddress(String address)
	{
		_address = address;
	}
	public String Address()
	{
		return _address;
	}
	
	public void setPhone(String phone)
	{
		_phone = phone;
	}
	public String Phone()
	{
		return _phone;
	}
	public void setEmail(String email)
	{
		_email = email;
	}
	public String Email()
	{
		return _email;
	}
	
	public void setNewsLetters(Boolean newsletters)
	{
		_newsletters = newsletters;
	}
	public Boolean Newsletters()
	{
		return _newsletters;
	}
	
}
