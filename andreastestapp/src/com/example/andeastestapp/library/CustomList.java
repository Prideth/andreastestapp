/**
 * @author adier
 *
 */
package com.example.andeastestapp.library;




import com.example.andreastestapp.R;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class CustomList extends ArrayAdapter<String>{
	private final Activity context;
	private final String[] text;
	private final Integer[] imageId;
	
	
	public CustomList(Activity context,	String[] web, Integer[] imageId) {
		super(context, R.layout.list_single, web);
		this.context = context;
		this.text = web;
		this.imageId = imageId;
	}
	
	public CustomList(Fragment context,	String[] web, Integer[] imageId) {
		super(context.getActivity(), R.layout.list_single, web);
		this.context = context.getActivity();
		this.text = web;
		this.imageId = imageId;
		
		
	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.list_single, null, true);
		TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
		txtTitle.setText(text[position]);
		imageView.setImageResource(imageId[position]);
		return rowView;
	}
}