package sra.com;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Contacts.People;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ContactsDemo extends Activity implements OnClickListener {
	private Button mBtnContacts;
	private final int PICK = 1;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mBtnContacts = (Button) findViewById(R.id.xBtnContacts);
		mBtnContacts.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// Opening Contacts Window as a Window
		Intent intent = new Intent(Intent.ACTION_PICK,
				ContactsContract.Contacts.CONTENT_URI);
		// calling OnActivityResult with intenet And Some conatct for Identifie
		startActivityForResult(intent, PICK);
	}

	@Override
	public void onActivityResult(int reqCode, int resultCode, Intent data) {
		super.onActivityResult(reqCode, resultCode, data);
		switch (reqCode) {
		case (PICK):
			if (resultCode == Activity.RESULT_OK) {
				Uri contactData = data.getData();
				Cursor c = managedQuery(contactData, null, null, null, null);
				if (c.moveToFirst()) {
					String name = c.getString(c
							.getColumnIndexOrThrow(People.NAME));
					// TODO Whatever you want to do with the selected contact
					// name.
				}
			}
			break;
		}
	}
}