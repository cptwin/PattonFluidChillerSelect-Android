package com.pattonnz.pattonfluidchillerselect;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.Toast;

/**
*
* @author MingHsuan Lee, Dajne Win, Kerry Powell
*/
public class MainActivity extends Activity implements OnItemSelectedListener {
	
	//All the elements that are used in the activity.
	private EditText tempInTextBox;
	private EditText tempOutTextBox;
	private EditText volumeTextBox;
	private EditText runtimeTextBox;
	private EditText capacityTextBox;
	private EditText modelTextBox;
	private ImageButton resetButton;
	private ImageButton phoneButton;
	private ImageButton downloadButton;
	private Spinner fluidSpinner;
	private TableRow tempInLayout;
	private TableRow tempOutLayout;
	private TableRow volumeLayout;
	private TableRow runtimeLayout;
	private TableRow modelLayout;
	
	//Variables used in calculation and user input
	private int tempIn;
	private int tempOut;
	private int volume;
	private int runtime;
	private F_Type fluidType;
	private String countryCode;
	
	//Logic Limits for inputs
	private int tempInLimit = 99;
	private int tempOutLimit = -99;
	private int volumeLowerLimit = 1;
	private int volumeUpperLimit = 100000;
	private int runtimeLowerLimit = 1;
	private int runtimeUpperLimit = 24;
	
	public static final int LIGHT_BLUE = Color.parseColor("#00a1e1");
	public static final int DARK_BLUE = Color.parseColor("#0979bf");
	
	//Prevents errors or other popus when the app is first started.
	private boolean startUp = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /**
     * Sets everything up for this activity.
     */
    private void setup()
    {
    	//setup access to objects
    	tempInTextBox = (EditText) findViewById(R.id.tempInTextBox);
    	tempOutTextBox = (EditText) findViewById(R.id.tempOutTextBox);
    	volumeTextBox = (EditText) findViewById(R.id.volumeTextBox);
    	runtimeTextBox = (EditText) findViewById(R.id.runtimeTextBox);
    	capacityTextBox = (EditText) findViewById(R.id.capacityTextBox);
    	modelTextBox = (EditText) findViewById(R.id.modelTextBox);
    	
    	tempInLayout = (TableRow) findViewById(R.id.tempInLayout);
    	tempOutLayout = (TableRow) findViewById(R.id.tempOutLayout);
    	volumeLayout = (TableRow) findViewById(R.id.volumeLayout);
    	runtimeLayout = (TableRow) findViewById(R.id.runtimeLayout);
    	modelLayout = (TableRow) findViewById(R.id.modelLayout);
    	
    	resetButton = (ImageButton) findViewById(R.id.resetButton);
    	phoneButton = (ImageButton) findViewById(R.id.phoneButton);
    	downloadButton = (ImageButton) findViewById(R.id.downloadButton);
    	
    	fluidSpinner = (Spinner) findViewById(R.id.fluidSpinner);
    	
    	countryCode = getApplicationContext().getResources().getConfiguration().locale.getISO3Country();
    	
    	//setup spinner
    	
    	int fluidArraySize = F_Type.values().length - 1;
    	F_Type[] fluidArray = new F_Type[fluidArraySize];
    	
    	for(int i = 0; i < (fluidArraySize); i++)
    	{
    		fluidArray[i] = F_Type.values()[i];
    	}
    	
    	ArrayAdapter<F_Type> spinnerArrayAdapter = new ArrayAdapter<F_Type>(this, R.layout.spinner_dropdown_item, fluidArray);
    	fluidSpinner.setAdapter(spinnerArrayAdapter);
    	
    	//setup object listeners
    	setupListeners();
    	
    	//reset all objects to default values
    	resetDefaults();
    	
    	startUp = true;
    }
    
    /**
     * Sets all the listeners up for buttons and other items in the activity.
     */
    private void setupListeners()
    {
    	fluidSpinner.setOnItemSelectedListener(this);
    	
    	resetButton.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	        resetDefaults();
    	    }
    	});
    	
    	phoneButton.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
    	        startActivity(intent);
    	    }
    	});
    	
    	downloadButton.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	    	Uri uriUrl;
    	    	if(countryCode.equalsIgnoreCase("NZL"))
    	    	{
    	    		uriUrl = Uri.parse("http://www.pattonnz.com/pdf/techBrochure/PattonPak_PZB%20Water%20Chiller_NZ.pdf");
    	    		Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
    	    		startActivity(launchBrowser);
    	    	}
    	    	else if(countryCode.equalsIgnoreCase("AUS"))
    	    	{
    	    		uriUrl = Uri.parse("http://www.pattonau.com/pdf/techBrochure/PattonPak_PZB%20Water%20Chiller_NZ.pdf");
    	    		Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
    	    		startActivity(launchBrowser);
    	    	}
    	    	else if(countryCode.equalsIgnoreCase("THA"))
    	    	{
    	    		uriUrl = Uri.parse("http://www.pattonth.com/pdf/techBrochure/PattonPak_PZB%20Water%20Chiller_NZ.pdf");
    	    		Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
    	    		startActivity(launchBrowser);
    	    	}
    	    	else if(countryCode.equalsIgnoreCase("IND"))
    	    	{
    	    		uriUrl = Uri.parse("http://www.pattonin.com/pdf/techBrochure/PattonPak_PZB%20Water%20Chiller_NZ.pdf");
    	    		Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
    	    		startActivity(launchBrowser);
    	    	}
    	    	else
    	    	{
    	    		uriUrl = Uri.parse("http://www.pattonnz.com/pdf/techBrochure/PattonPak_PZB%20Water%20Chiller_NZ.pdf");
    	    		Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
    	    		startActivity(launchBrowser);
    	    	}
    	    }
    	});
    	
    	tempInTextBox.addTextChangedListener(new TextWatcher() { 		 
    		   public void afterTextChanged(Editable s) {
    			   performCalculation();
    		   }		 
    		   public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    		   }   		 
    		   public void onTextChanged(CharSequence s, int start, int before, int count) {
    		   }
		});
    	
    	tempOutTextBox.addTextChangedListener(new TextWatcher() { 		 
 		   public void afterTextChanged(Editable s) {
 			   performCalculation();
 		   }		 
 		   public void beforeTextChanged(CharSequence s, int start, int count, int after) {
 		   }   		 
 		   public void onTextChanged(CharSequence s, int start, int before, int count) {
 		   }
		});
    	
    	volumeTextBox.addTextChangedListener(new TextWatcher() { 		 
 		   public void afterTextChanged(Editable s) {
 			   performCalculation();
 		   }		 
 		   public void beforeTextChanged(CharSequence s, int start, int count, int after) {
 		   }   		 
 		   public void onTextChanged(CharSequence s, int start, int before, int count) {
 		   }
		});
    	
    	runtimeTextBox.addTextChangedListener(new TextWatcher() { 		 
 		   public void afterTextChanged(Editable s) {
 			   performCalculation();
 		   }		 
 		   public void beforeTextChanged(CharSequence s, int start, int count, int after) {
 		   }   		 
 		   public void onTextChanged(CharSequence s, int start, int before, int count) {
 		   }
		});
    	
    }
    
    /**
     * Resets all inputs to defaults.
     */
    private void resetDefaults()
    {
    	tempInTextBox.setText("4");
    	tempOutTextBox.setText("2");
    	volumeTextBox.setText("10000");
    	runtimeTextBox.setText("1");
    	//capacityTextBox.setText("");
    	//modelTextBox.setText("");
    	fluidSpinner.setSelection(0);
    }
    
    /**
     * Clears the Capacity and Model calcuations from their textboxes.
     */
    private void clearCalculated()
    {
    	capacityTextBox.setText("");
    	modelTextBox.setText("");
    }


    /**
     * Performs calculation when an item is selected from the dropdown selection.
     */
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		performCalculation();
	}


	//Required override for dropdown selection.
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		//We don't need to do anything in here.
	}
	
	/**
	 * Method called when an action such as the user changing the input temperature has occured.
	 * Checks for errors first and then performs the calculation based on input values.
	 */
	private void performCalculation()
	{
		setDefaultColor();
		fluidType = (F_Type) fluidSpinner.getSelectedItem();
		if(!isErrors())
		{
			Model m = new Model(fluidType.getName(), tempIn, tempOut, volume, runtime);
			capacityTextBox.setText(String.format("%.2f %n", m.getCapacity()));
			
			//BigDecimal bd = new BigDecimal("" + m.getCapacity());
			//capacityTextBox.setText("" + bd.setScale(2, RoundingMode.HALF_UP).toString());
			
			String modelOutput = m.findEngine();
			if(modelOutput.contains("ERROR") && startUp == true)
			{
				//clearCalculated();
				//modelTextBox.setText(modelOutput.replace("ERROR", ""));
				modelTextBox.setText("ERROR");
				modelLayout.setBackgroundColor(Color.RED);
				Model.setSelectModel("");
				showAlert("Capacity is too high! Please contact us for your best solution.");
			}
			else
			{
				modelTextBox.setText(modelOutput);
				Model.setSelectModel(modelOutput);
			}
		}
		else
		{
			clearCalculated();
			Model.setSelectModel("");
			modelTextBox.setText("");
		}
	}
	
	/**
	 * Sets up our default colours for the alternating light blue, dark blue layout.
	 */
	private void setDefaultColor() {
		tempInLayout.setBackgroundColor(LIGHT_BLUE);
		tempOutLayout.setBackgroundColor(DARK_BLUE);
		volumeLayout.setBackgroundColor(LIGHT_BLUE);
		runtimeLayout.setBackgroundColor(DARK_BLUE);
		modelLayout.setBackgroundColor(DARK_BLUE);
	}
	
	/**
	 * Checks if there are any errors with the input used for calculation.
	 * @return True If there are any input errors.
	 */
	private boolean isErrors()
	{
		try {
			boolean hasErrors = false;
			
			tempIn = Integer.parseInt(tempInTextBox.getText().toString());
			tempOut = Integer.parseInt(tempOutTextBox.getText().toString());
			volume = Integer.parseInt(volumeTextBox.getText().toString());
			runtime = Integer.parseInt(runtimeTextBox.getText().toString());
			
			if((runtime > runtimeUpperLimit) || runtime < runtimeLowerLimit)
			{
				showAlert("Invalid Runtime");
				runtimeLayout.setBackgroundColor(Color.RED);
				hasErrors = true;
			}
			if(volume < volumeLowerLimit)
			{
				showAlert("Invalid Volume");
				volumeLayout.setBackgroundColor(Color.RED);
				hasErrors = true;
			}
			if(volume > volumeUpperLimit)
			{
				showAlert("Volume is too high! Please contact us for your best solution.");
				volumeLayout.setBackgroundColor(Color.RED);
				hasErrors = true;
			}
			if(tempIn > tempInLimit)
			{
				showAlert("Temp in is too high! Please contact us for your best solution.");
				tempInLayout.setBackgroundColor(Color.RED);
				hasErrors = true;
			}
			if(tempOut < tempOutLimit)
			{
				showAlert("Temp out is too high! Please contact us for your best solution.");
				tempOutLayout.setBackgroundColor(Color.RED);
				hasErrors = true;
			}
			if(tempIn <= tempOut)
			{
				showAlert("Temp In must be higher than Temp Out");
				tempInLayout.setBackgroundColor(Color.RED);
				hasErrors = true;
			}
			if(tempOut < fluidType.getlowestAllowedTemp())
			{
				showAlert("Temp out is too low for " + fluidType.getName());
				tempOutLayout.setBackgroundColor(Color.RED);
				hasErrors = true;
			}
			
			return hasErrors;
			
		} catch(NumberFormatException nfe) {
		   return true;
		}
	}
	
	/**
	 * Creates an Android Toast, used for error messages and requires no user interaction to dismiss.
	 * @param message
	 */
	private void showAlert(String message){
		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
	}
    
}
