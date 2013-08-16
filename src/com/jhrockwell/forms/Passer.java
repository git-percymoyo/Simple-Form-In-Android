/* Author: J. H. Rockwell
   Passer.java
   
   Description: This class is used to pass user information from the Forms.java
                to the next Activity, Post.java. 
                
                From the first Activity, the Intent is used to indicate the designated Activity and the values to pass 					
                are set here and this Class returns those set values when they are called in the designated Activity.
*/

package com.jhrockwell.forms;
import java.io.Serializable;

public class Passer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	String _name;			// Holds the string of user's name
	String _address;		// Holds the string of user's address
	String _phone;			// Holds the string of user's phone
	String _email;			// Holds the string of user's email
	Boolean _newsletters;	// Holds the boolean value of the "newsletter" optional checkbox
	
	public void setName(String name)
	{
		/* Sets the string of the user's name */
		_name = name;
	}
	public String Name()
	{
		/* Returns the string of the user's name */
		return _name;
	}
	
	public void setAddress(String address)
	{
		/* Sets the string fo the user's address */
		_address = address;
	}
	public String Address()
	{
		/* Returns the string of the user's address */ 
		return _address;
	}
	
	public void setPhone(String phone)
	{
		/* Sets the string of the user's phone */ 
		_phone = phone;
	}
	public String Phone()
	{
		/* Returns the string of the user's phone */
		return _phone;
	}
	public void setEmail(String email)
	{
		/* Sets the string of the user's email */ 
		_email = email;
	}
	public String Email()
	{
		/* Returns the string of the user's email */
		return _email;
	}
	
	public void setNewsLetters(Boolean newsletters)
	{
		/* Sets the Boolean of the user's optional "newsletter" checkbox */
		_newsletters = newsletters;
	}
	public Boolean Newsletters()
	{
		/* Returns the Boolean value of the optional "newsletter" checkbox */
		return _newsletters;
	}
	
}
