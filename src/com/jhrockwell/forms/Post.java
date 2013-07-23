package com.jhrockwell.forms;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Post extends Activity {

	private TextView postInfos;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        
        postInfos = (TextView)findViewById(R.id.postInfos);
        
        Passer obj = (Passer)getIntent().getSerializableExtra("Forms");
        
        String msg;
        if (obj.Newsletters()) msg = "We will send you newsletters.";
        else msg = "You have chosen not to receive newsletters";
        
        postInfos.setText("Hello there " + obj.Name() + 
        		          "! You live at " + obj.Address() +
        		          ". Your number is " + obj.Phone() +
        		          " and your email is " + obj.Email() +
        		          ". " + msg);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_post, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	switch (item.getItemId())
    	{
    	case android.R.id.home:
    		Intent intent = new Intent(this, Forms.class);
    		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    		startActivity(intent);
    		return true;
    	default:
    		return super.onOptionsItemSelected(item);
    	}
    }
    
}
