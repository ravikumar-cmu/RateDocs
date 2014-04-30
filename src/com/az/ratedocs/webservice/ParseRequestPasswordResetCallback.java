/************************************************************************************************
 *	18-641 Java for Smart Phone Development
 * 	Authors: 		Shubhang Chaudhary (shubhanc)
 * 					Fiona Britto (fbritto)
 * 					Kyle Verma (ktv)
 * 	Application: 	SmartLend
 * 	Date:			November 30th, 2013 
 ************************************************************************************************/

package com.az.ratedocs.webservice;

import android.app.Activity;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.RequestPasswordResetCallback;

/************************************************************************************************
 * ClassName: ParseRequestPasswordResetCallback.java
 * Description: Parse callback for requesting a password reset
 ************************************************************************************************/

public class ParseRequestPasswordResetCallback extends
RequestPasswordResetCallback {

	private Activity activity;

	public ParseRequestPasswordResetCallback(Activity activity){
		this.activity = activity;
	}
	
	/* Callbacks cannot throw exceptions so we have to do error handling here */
	@Override
	public void done(ParseException e) {
		if (e == null) {
			Toast.makeText(activity.getBaseContext(), "Check your email for Password reset options",
					Toast.LENGTH_SHORT).show();
		} else {
			if(e.getCode()==125)
				Toast.makeText(activity.getBaseContext(), "Please type a valid email address",
						Toast.LENGTH_SHORT).show();
			if(e.getCode()==205)
				Toast.makeText(activity.getBaseContext(), "Email not registered",
						Toast.LENGTH_SHORT).show();
		}
	}

}