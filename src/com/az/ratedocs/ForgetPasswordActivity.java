package com.az.ratedocs;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetPasswordActivity extends Activity{
	private EditText et_forgetpassword = null;
	private Button btn_submitforgetpassword = null;
	private String password = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forget_password);
		
		et_forgetpassword = (EditText) findViewById(R.id.et_forgetpassword);
		btn_submitforgetpassword = (Button) findViewById(R.id.btn_submitforgetpassword);
		
		btn_submitforgetpassword.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				password = et_forgetpassword.getText().toString();
				checkEmailID();
			}
		});
	}
	
	protected void checkEmailID() {
		if (TextUtils.isEmpty(password)) {
			et_forgetpassword.setError(getString(R.string.error_field_required));
		} else if (!password.contains("@")) {
			et_forgetpassword.setError(getString(R.string.error_invalid_email));
		}
		else
			forgotPassword(password);
	}

	public void forgotPassword(String email) {
		//postEvent(new UserForgotPasswordStartEvent());
		ParseUser.requestPasswordResetInBackground(email, new UserForgotPasswordCallback());
	}
	
	private class UserForgotPasswordCallback extends RequestPasswordResetCallback{
		public UserForgotPasswordCallback(){
			super();
		}
		
		@Override
		public void done(ParseException e) {
			if (e == null) {
				Toast.makeText(getApplicationContext(), "Successfully sent link to your email for reset Password", Toast.LENGTH_LONG).show();
			} else {
				Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
			}
		}		
	}

}