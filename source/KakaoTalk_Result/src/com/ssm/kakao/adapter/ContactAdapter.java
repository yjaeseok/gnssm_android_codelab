package com.ssm.kakao.adapter;

import java.util.List;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ssm.kakao.R;
import com.ssm.kakao.domain.Contact;

public class ContactAdapter extends BaseAdapter {
	private List<Contact> contactList;
	
	private LayoutInflater inflater;
	
	public ContactAdapter (Context context, List<Contact> contactList) {
		this.contactList = contactList;
		
		inflater = (LayoutInflater)context.getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);
	}


	@Override
	public int getCount() {
		return contactList.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return contactList.get(position).Id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null) {
			convertView = inflater.inflate(R.layout.contact_list_item, parent, false);
		}
		TextView contactName = (TextView)convertView.findViewById(R.id.ContactName);
		ImageView contactImage = (ImageView)convertView.findViewById(R.id.ContactImage);
		contactName.setText(contactList.get(position).DisplayName);
		
		if(contactList.get(position).PhotoId == null) {
			contactImage.setImageResource(R.drawable.general_default_profile_image);
		} else {
			Uri contactUri = ContentUris.withAppendedId(
					ContactsContract.Contacts.CONTENT_URI, getItemId(position));
			Uri contactPhotoUri = Uri.withAppendedPath(contactUri, Contacts.Photo.CONTENT_DIRECTORY);
			contactImage.setImageURI(contactPhotoUri);
		}
		return convertView;
	}

}
