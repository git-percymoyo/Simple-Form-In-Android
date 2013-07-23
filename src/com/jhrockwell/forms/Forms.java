package com.jhrockwell.forms;

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
	private EditText nameText;
	private EditText addrText;
	private EditText foneText;
	private EditText emailText;
	
	private CheckBox newsLetterCheckBox;
	
	private Button submitButton;
	private Button resetButton;
	
	private Passer mPasser = new Passer();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);
        
        nameText = (EditText)findViewById(R.id.nameText);
        addrText = (EditText)findViewById(R.id.addrText);
        foneText = (EditText)findViewById(R.id.foneText);
        emailText = (EditText)findViewById(R.id.emailText);
        
        newsLetterCheckBox = (CheckBox)findViewById(R.id.NewsLetter);
        
        submitButton = (Button)findViewById(R.id.submitButton);
        submitButton.setOnClickListener(submitButtonListener);
        
        resetButton = (Button)findViewById(R.id.resetButton);
        resetButton.setOnClickListener(resetButtonListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_forms, menu);
        return true;
    }
    
    private OnClickListener submitButtonListener = new OnClickListener()
    {
    	public void onClick(View v)
    	{   		
    		String name = nameText.getText().toString();
    		String addr = addrText.getText().toString();
    		String fone = foneText.getText().toString();
    		String email = emailText.getText().toString();
    		
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
    		else {
    		Intent i = new Intent(Forms.this, Post.class);
    		
    		mPasser.setName(name);
    		mPasser.setAddress(addr);
    		mPasser.setPhone(fone);
    		mPasser.setEmail(email);
    		mPasser.setNewsLetters(newsLetterCheckBox.isChecked());
    		i.putExtra("Forms", mPasser);
 
    		startActivity(i); }
    	}
    };
    
    private OnClickListener resetButtonListener = new OnClickListener()
    {
    	public void onClick(View view)
    	{
    		nameText.setText("");
    		addrText.setText("");
    		foneText.setText("");
    		emailText.setText("");
    		newsLetterCheckBox.setChecked(false);
    		
    	}
    };
}
