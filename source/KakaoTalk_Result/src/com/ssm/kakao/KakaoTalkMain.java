package com.ssm.kakao;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;
import android.widget.Toast;

import com.ssm.kakao.adapter.ContactAdapter;
import com.ssm.kakao.domain.Contact;


public class KakaoTalkMain extends Activity {

	private ListView contactListView;
	private ContactAdapter contactAdapter;
	private List<Contact> contactList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		contactListView = (ListView)findViewById(R.id.contactListView);
		makeContactsData();
		contactAdapter = new ContactAdapter(this, contactList);
		contactListView.setAdapter(contactAdapter);
	}
	

	private void makeContactsData()
	{
		Uri uri = ContactsContract.Contacts.CONTENT_URI;
		
		String[] projection = {
				ContactsContract.Contacts.Entity._ID,
				ContactsContract.Contacts.Entity.DISPLAY_NAME,
				ContactsContract.Contacts.Entity.PHOTO_ID
		};
		
		Cursor cursor = getContentResolver().query(uri, projection, null, null, null) ;
		
		contactList = new ArrayList<Contact>();
		
		if(cursor.moveToFirst()) {
			do {
				contactList.add( new Contact(
						cursor.getLong(cursor.getColumnIndex(projection[0])),
						cursor.getString(cursor.getColumnIndex(projection[1])),
						cursor.getString(cursor.getColumnIndex(projection[2]))));
			} while( cursor.moveToNext() );
		}
	}
}
