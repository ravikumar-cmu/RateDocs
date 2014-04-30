package com.az.ratedocs.onclick;

import android.app.Activity;

import com.az.ratedocs.AddCommentsActivity;
import com.az.ratedocs.utilities.StartIntent;

public class OnClickCreateAccount implements OnClickInterface {
Activity activity;
	
	/* Associate the on click methods with our buttons */
	public OnClickCreateAccount(Activity activity) {
		this.activity = activity;
//		Button button = (Button) activity.findViewById(R.id.add_lend_btn_my_books);
//		button.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View arg0) {
//				clickedAddLend();
//			}
//			
//		});
	}

	/* Start the edit book details activity */
	public void clickedAddLend() {
		StartIntent.startIntent(activity, AddCommentsActivity.class);
	}
}
