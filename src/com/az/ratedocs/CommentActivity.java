package com.az.ratedocs;

/* This activity enable users to add comments for a certain doctor.
 * */

import com.az.ratedocs.onclick.OnClickFactory;
import com.az.ratedocs.onclick.OnClickInterface;
import android.app.Activity;
import android.os.Bundle;

public class CommentActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comment_items);

		@SuppressWarnings("unused")
		OnClickInterface onClickInterface = OnClickFactory.getOnClick(this, CommentActivity.this);
	}
}
