/************************************************************************************************
 *	18-641 Java for Smart Phone Development
 * 	Authors: 		Shubhang Chaudhary (shubhanc)
 * 					Fiona Britto (fbritto)
 * 					Kyle Verma (ktv)
 * 	Application: 	SmartLend
 * 	Date:			November 30th, 2013 
 ************************************************************************************************/

package com.az.ratedocs.onclick;

/* All the android imports */

/************************************************************************************************
 * ClassName: OnClickFactory.java
 * Description: This factory allows each activity to get its corresponding on click object
 * 				without actually needing each activity to know which on click object corresponds
 * 				to it. This allows us to do extensive changes to how our on click handlers work
 * 				without necessarily having to change the activities that use them
 ************************************************************************************************/

import android.app.Activity;

import com.az.ratedocs.AddCommentsActivity;
import com.az.ratedocs.CallActivity;
import com.az.ratedocs.CommentActivity;
import com.az.ratedocs.ConfirmCreateAccountActivity;
import com.az.ratedocs.CreateAccountActivity;
import com.az.ratedocs.DoctListActivity;
import com.az.ratedocs.ForgetPasswordActivity;
import com.az.ratedocs.MainActivity;
import com.az.ratedocs.RatesActivity;
import com.az.ratedocs.RequestAppointmentActivity;
import com.az.ratedocs.SelectSpecialityActivity;
import com.az.ratedocs.SubmitEmailActivity;



public class OnClickFactory {
	public static OnClickInterface getOnClick(Activity activity) {
		OnClickInterface onClickInterface = null;
		Class<?> class1 = activity.getClass();
		
		/* Figures out which activity called this method and returns the corresponding OnClick object */
		if(class1.equals(CallActivity.class)) onClickInterface = new OnClickDoctorCall(activity);
		else if(class1.equals(CommentActivity.class)) onClickInterface = new OnClickDoctorComments(activity);
		else if(class1.equals(ConfirmCreateAccountActivity.class)) onClickInterface = new OnClickConfirmCreateAccount(activity);
		else if(class1.equals(CreateAccountActivity.class)) onClickInterface = new OnClickCreateAccount(activity);
		else if(class1.equals(MainActivity.class)) onClickInterface = new OnClickMainActivity(activity);
		else if(class1.equals(DoctListActivity.class)) onClickInterface = new OnClickDoctorProfile(activity);
		else if(class1.equals(ForgetPasswordActivity.class)) onClickInterface = new OnClickForgetPassword(activity);
		else if(class1.equals(RequestAppointmentActivity.class)) onClickInterface = new OnClickRequestAppointment(activity);
		else if(class1.equals(SelectSpecialityActivity.class)) onClickInterface = new OnClickSpeciality(activity);
		else if(class1.equals(RatesActivity.class)) onClickInterface = new OnClickDoctorRates(activity);
		else if(class1.equals(SubmitEmailActivity.class)) onClickInterface = new OnClickSubmitEmail(activity);
		else if(class1.equals(AddCommentsActivity.class)) onClickInterface = new OnClickAddComments(activity);
		return onClickInterface;
	}
}