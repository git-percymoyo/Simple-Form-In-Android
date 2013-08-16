/* Author: J. H. Rockwell
   Forms.java
   
   Description: First Activity to be viewed when the app first launches.
   				It containts Android UI elements to create a basic form
   				asking for the user's name, address, phone number and
   				email. It also includes a checkbox asking for the user's
   				choice of receving a newsletter. Lastly, there are two
   				buttons; one button to sumbit the form and pass the user
   				inputs to the next Activity and the reset button to 
   				enable the user to reset the whole form in just one click.
   				
   				This form will not pass to the next Activity if at least 
   				one requried field is empty. The Intent is used to pass
   				the user information entered with the Java Passer class.
   				
    Needs: 		1. Regex upon submission
    			2. Alert Dialog Box to inform the user the reason as to 
    			   why a submission is not being executed since at least
    			   the required fields are empty.
   				
*/


package com.jhrockwell.forms;

/*** Imports ***/
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class Forms extends Activity {

	private Context context = this;
	
	/*** EditText ***/
	/* Required Fields in the form */
	// EditText to take user's name
	private EditText nameText;
	// EditText to take user's address
	private EditText addrText;
	// EditText to take user's phone number
	private EditText foneText;
	// EditText to take the user's email
	private EditText emailText;
	
	/*** CheckBox ***/
	/* Optional field in the form */
	// Checkbox for the user to check the "newsletter"
	private CheckBox newsLetterCheckBox;
	
	/*** Buttons ***/
	// The submit button
	private Button submitButton;
	// The reset button 
	private Button resetButton;
	
	private Passer mPasser = new Passer();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);
        
        /*** Find View by Id's ***/
        /* Connecting the Views from the XML UI so this Java Class
           can manipulate them to better interact with the user. */
           
        // name EditText connect
        nameText = (EditText)findViewById(R.id.nameText);
        // address EditText connect
        addrText = (EditText)findViewById(R.id.addrText);
        // phone EditText connect
        foneText = (EditText)findViewById(R.id.foneText);
        // email EditText connect
        emailText = (EditText)findViewById(R.id.emailText);
        
        
        // "newsletter" optional checkbox connect
        newsLetterCheckBox = (CheckBox)findViewById(R.id.NewsLetter);
        
        // submit button connect
        submitButton = (Button)findViewById(R.id.submitButton);
        // Set the submit button listener so user can submit the form
        submitButton.setOnClickListener(submitButtonListener);
        
        
        // reset button connect
        resetButton = (Button)findViewById(R.id.resetButton);
        // Set the reset button listener so user can reset the form
        resetButton.setOnClickListener(resetButtonListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_forms, menu);
        return true;
    }
    
    /*** Button Listeners ***/
    
    /* Submit Button Listerner; submitButtonListener */
    private OnClickListener submitButtonListener = new OnClickListener()
    {
    	public void onClick(View v)
    	{   		
    		/* When the submit button is clicked or pressed by the user,
    		   get each EditText value and convert them to strings. 
    		   By taking these strigns and saving them, this Java Class 
    		   can check if they're empty or at least have one character.
    		   Since these are the required fields, they should not be
    		   empty. */
    		String name = nameText.getText().toString();
    		String addr = addrText.getText().toString();
    		String fone = foneText.getText().toString();
    		String email = emailText.getText().toString();
    		
    		/* Check each strings if they're empty. If they are empty,
    		   display a dialog box to inform the user that submission
    		   can't happen because at least one of these required fields
    		   are empty, that the form is incomplete. */
    		if (name.equals("") || addr.equals("") ||
    			fone.equals("") || email.equals("") )
    		{
    			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
    					context);
    	
    				alertDialogBuilder.setTitle("Error");
    	 
    			
    				alertDialogBuilder
    					.setMessage("This form is not complete.")
    					.setCancelable(false)
    					.setPositiveButton("Okay",new DialogInterface.OnClickListener() {
    						public void onClick(DialogInterface dialog,int id) {
    							
    							dialog.cancel();
    						}
    					  });
    	 
    					AlertDialog alertDialog = alertDialogBuilder.create();

    					alertDialog.show();
    		}
    		/* If all the required EditText's are not empty, meaning the form is complete,
    		   invoke the Intent and pass the user's information to the Passer Class and
    		   start the next Activity, Class Post. */
    		else 
    		{
    			Intent i = new Intent(Forms.this, Post.class);
    		
    			mPasser.setName(name);
    			mPasser.setAddress(addr);
    			mPasser.setPhone(fone);
    			mPasser.setEmail(email);
    			mPasser.setNewsLetters(newsLetterCheckBox.isChecked());
    			i.putExtra("Forms", mPasser);
 
    			startActivity(i); 
    		}
    	}
    };
    
    /* Reset Button Listener; resetButtonListener */
    private OnClickListener resetButtonListener = new OnClickListener()
    {
    	public void onClick(View view)
    	{
    		/* The user pressed the reset button, so this function
    		   clears any contents of the EditText's and uncheck 
    		   the "newsletter" checkbox. */
    		nameText.setText("");
    		addrText.setText("");
    		foneText.setText("");
    		emailText.setText("");
    		newsLetterCheckBox.setChecked(false);
    		
    	}
    };
}
