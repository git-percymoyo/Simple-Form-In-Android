/* Author: J. H. Rockwell

   Description: This class receives the user's input information from the previous activity, Forms.java.
   				All this class does is to display the user's information by concatenating it to the 
   				appropriate locations in the set paragraph. 
   				
   				There is navigation back-button in this Activity to enable the user to go back to the 
   				previous Activity, Forms.java.
   				
*/

package com.jhrockwell.forms;

/*** Imports ***/
import android.app.ActionBar; // Enables the back-button navigation
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Post extends Activity {

	/*** TextView(s) ***/
	// TextView postInfos initialization
	private TextView postInfos;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.post);
        
        /* Connecting to the ActionBar and enabling it. */
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        
        /* Connect the postInfos TextView from the XML UI to
           display the paragraph to the user. */ 
        postInfos = (TextView)findViewById(R.id.postInfos);
        
        /* Create a Class Passer object to get the information from the
           previous Activity, Forms.java, in order to concatenate it to 
           paragraph. */
        Passer obj = (Passer)getIntent().getSerializableExtra("Forms");
        
        String msg; // Holds the response of the user's indication of wanting "newsletters"
        // If Newsletters boolean value is true, indicate a response that the user will
        // be sent "newsletters"
        if (obj.Newsletters()) msg = "We will send you newsletters.";
        // Else if the Newsletters boolean value is false, indicate a response that the user
        // will NOT be senst "newsletters"
        else msg = "You have chosen not to receive newsletters";
        
        /* Concatenate the appropriate user information to the paragraph and set the whole
           string to postInfos TextView. */
        postInfos.setText("Hello there " + obj.Name() + 
        		          "! You live at " + obj.Address() +
        		          ". Your number is " + obj.Phone() +
        		          " and your email is " + obj.Email() +
        		          ". " + msg);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	/* Inflate the menu */
        getMenuInflater().inflate(R.menu.activity_post, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	/* The back-button navigation was pressed. Redirect to the
    	   previous Activity, Forms.java. */
    	switch (item.getItemId())
    	{
    		case android.R.id.home:
    			Intent intent = new Intent(this, Forms.class);
    			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    			startActivity(intent);
    			return true;
    		default: return super.onOptionsItemSelected(item); break;
    	}
    }
    
}
