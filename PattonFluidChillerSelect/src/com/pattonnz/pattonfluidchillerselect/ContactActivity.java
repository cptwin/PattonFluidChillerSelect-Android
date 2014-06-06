package com.pattonnz.pattonfluidchillerselect;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 
 * @author Dajne Win
 */
public class ContactActivity extends Activity {
	
	//setup the New Zealand Contact Details
	private String NZLPhoneNumber = "006495730060";
	private String NZLEmail = "sales@pattonnz.com";
	private String NZLWebsite = "http://www.pattonnz.com";
	private TextView textViewNZLPhone;
	private TextView textViewNZLWeb;
	private TextView textViewNZLEmail;
	private ImageView imageViewNZLPhone;
	private ImageView imageViewNZLWeb;
	private ImageView imageViewNZLEmail;
	
	//setup the Australian Contact Details
	private String AUSPhoneNumber = "0061732555933";
	private String AUSEmail = "sales@pattonau.com";
	private String AUSWebsite = "http://www.pattonau.com";
	private TextView textViewAUSPhone;
	private TextView textViewAUSWeb;
	private TextView textViewAUSEmail;
	private ImageView imageViewAUSPhone;
	private ImageView imageViewAUSWeb;
	private ImageView imageViewAUSEmail;
	
	//setup the Thai Contact Details
	private String THAPhoneNumber = "006627096991";
	private String THAEmail = "sales@pattonth.com";
	private String THAWebsite = "http://www.pattonth.com";
	private TextView textViewTHAPhone;
	private TextView textViewTHAWeb;
	private TextView textViewTHAEmail;
	private ImageView imageViewTHAPhone;
	private ImageView imageViewTHAWeb;
	private ImageView imageViewTHAEmail;
	
	//setup the Indian Contact Details
	private String INDPhoneNumber = "00911204325001";
	private String INDEmail = "sales@pattonin.com";
	private String INDWebsite = "http://www.pattonin.com";
	private TextView textViewINDPhone;
	private TextView textViewINDWeb;
	private TextView textViewINDEmail;
	private ImageView imageViewINDPhone;
	private ImageView imageViewINDWeb;
	private ImageView imageViewINDEmail;
	

	/**
	 * Sets up access to all of the objects that we need to be able to set data for.
	 * @author Dajne Win
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_contact);
	    
	    textViewNZLPhone = (TextView) findViewById(R.id.textViewNZLPhone);
	    textViewNZLEmail = (TextView) findViewById(R.id.textViewNZLEmail);
	    textViewNZLWeb = (TextView) findViewById(R.id.textViewNZLWeb);
	    imageViewNZLPhone = (ImageView) findViewById(R.id.imageViewNZLPhone);
	    imageViewNZLEmail = (ImageView) findViewById(R.id.imageViewNZLEmail);
	    imageViewNZLWeb = (ImageView) findViewById(R.id.imageViewNZLWeb);
	    
	    textViewAUSPhone = (TextView) findViewById(R.id.textViewAUSPhone);
	    textViewAUSEmail = (TextView) findViewById(R.id.textViewAUSEmail);
	    textViewAUSWeb = (TextView) findViewById(R.id.textViewAUSWeb);
	    imageViewAUSPhone = (ImageView) findViewById(R.id.imageViewAUSPhone);
	    imageViewAUSEmail = (ImageView) findViewById(R.id.imageViewAUSEmail);
	    imageViewAUSWeb = (ImageView) findViewById(R.id.imageViewAUSWeb);
	    
	    textViewTHAPhone = (TextView) findViewById(R.id.textViewTHAPhone);
	    textViewTHAEmail = (TextView) findViewById(R.id.textViewTHAEmail);
	    textViewTHAWeb = (TextView) findViewById(R.id.textViewTHAWeb);
	    imageViewTHAPhone = (ImageView) findViewById(R.id.imageViewTHAPhone);
	    imageViewTHAEmail = (ImageView) findViewById(R.id.imageViewTHAEmail);
	    imageViewTHAWeb = (ImageView) findViewById(R.id.imageViewTHAWeb);
	    
	    textViewINDPhone = (TextView) findViewById(R.id.textViewINDPhone);
	    textViewINDEmail = (TextView) findViewById(R.id.textViewINDEmail);
	    textViewINDWeb = (TextView) findViewById(R.id.textViewINDWeb);
	    imageViewINDPhone = (ImageView) findViewById(R.id.imageViewINDPhone);
	    imageViewINDEmail = (ImageView) findViewById(R.id.imageViewINDEmail);
	    imageViewINDWeb = (ImageView) findViewById(R.id.imageViewINDWeb);
	    
	    setupListeners();
	}
	
	/**
	 * Creates the listeners for onClick events to initiate an action dependent on if phone, email or web is clicked.
	 */
	private void setupListeners()
	{
		//New Zealand
		textViewNZLPhone.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	Intent callIntent = new Intent(Intent.ACTION_CALL);
    	        callIntent.setData(Uri.parse("tel:" + NZLPhoneNumber));
    	        startActivity(callIntent);
    	    }
    	});	
		textViewNZLEmail.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	sendEmail(NZLEmail);
    	    }
    	});	
		textViewNZLWeb.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	openWebsite(NZLWebsite);
    	    }
    	});
		imageViewNZLPhone.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	Intent callIntent = new Intent(Intent.ACTION_CALL);
    	        callIntent.setData(Uri.parse("tel:" + NZLPhoneNumber));
    	        startActivity(callIntent);
    	    }
    	});	
		imageViewNZLEmail.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	sendEmail(NZLEmail);
    	    }
    	});	
		imageViewNZLWeb.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	openWebsite(NZLWebsite);
    	    }
    	});
		
		//Australia
		textViewAUSPhone.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	Intent callIntent = new Intent(Intent.ACTION_CALL);
    	        callIntent.setData(Uri.parse("tel:" + AUSPhoneNumber));
    	        startActivity(callIntent);
    	    }
    	});	
		textViewAUSEmail.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	sendEmail(AUSEmail);
    	    }
    	});	
		textViewAUSWeb.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	openWebsite(AUSWebsite);
    	    }
    	});
		imageViewAUSPhone.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	Intent callIntent = new Intent(Intent.ACTION_CALL);
    	        callIntent.setData(Uri.parse("tel:" + AUSPhoneNumber));
    	        startActivity(callIntent);
    	    }
    	});	
		imageViewAUSEmail.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	sendEmail(AUSEmail);
    	    }
    	});	
		imageViewAUSWeb.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	openWebsite(AUSWebsite);
    	    }
    	});
		
		//Thailand
		textViewTHAPhone.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	Intent callIntent = new Intent(Intent.ACTION_CALL);
    	        callIntent.setData(Uri.parse("tel:" + THAPhoneNumber));
    	        startActivity(callIntent);
    	    }
    	});	
		textViewTHAEmail.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	sendEmail(THAEmail);
    	    }
    	});	
		textViewTHAWeb.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	openWebsite(THAWebsite);
    	    }
    	});
		imageViewTHAPhone.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	Intent callIntent = new Intent(Intent.ACTION_CALL);
    	        callIntent.setData(Uri.parse("tel:" + THAPhoneNumber));
    	        startActivity(callIntent);
    	    }
    	});	
		imageViewTHAEmail.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	sendEmail(THAEmail);
    	    }
    	});	
		imageViewTHAWeb.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	openWebsite(THAWebsite);
    	    }
    	});
		
		//India
		textViewINDPhone.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	Intent callIntent = new Intent(Intent.ACTION_CALL);
    	        callIntent.setData(Uri.parse("tel:" + INDPhoneNumber));
    	        startActivity(callIntent);
    	    }
    	});	
		textViewINDEmail.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	sendEmail(INDEmail);
    	    }
    	});	
		textViewINDWeb.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	openWebsite(INDWebsite);
    	    }
    	});
		imageViewINDPhone.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	Intent callIntent = new Intent(Intent.ACTION_CALL);
    	        callIntent.setData(Uri.parse("tel:" + INDPhoneNumber));
    	        startActivity(callIntent);
    	    }
    	});	
		imageViewINDEmail.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	sendEmail(INDEmail);
    	    }
    	});	
		imageViewINDWeb.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	openWebsite(INDWebsite);
    	    }
    	});
		
	}
	
	/**
	 * Opens a website in the default android browser.
	 * @param url
	 */
	private void openWebsite(String url)
	{
		Uri uriUrl = Uri.parse(url);
		Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
		startActivity(launchBrowser);
	}
	
	/**
	 * Creates an email to send to a reciever.
	 * @param reciever
	 */
	private void sendEmail(String reciever)
	{
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		String[] recieverArray = new String[1];
		recieverArray[0] = reciever;
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, recieverArray);		
		if(Model.getSelectedModel().equals(""))
		{
			emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Chiller Select Enquiry");
		}
		else
		{
			emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Chiller Select Model: " + Model.getSelectedModel());
		}
		emailIntent.setType("plain/text");	
		startActivity(emailIntent);
		
	}

}
