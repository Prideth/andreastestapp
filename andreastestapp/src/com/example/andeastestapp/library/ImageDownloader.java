/**
 * 
 */
package com.example.andeastestapp.library;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * @author adier
 *
 */
public class ImageDownloader {

	private final static String TAG = "GBD";

	private int size = 128;


	
	public ImageDownloader(Context context, String url) throws IOException{
		drawableFromUrl(context,url, null);
	}
	
	public ImageDownloader(Context context, String url, Integer size) throws IOException{
		drawableFromUrl(context, url, size);
	}
	
	
	
	
	public static Drawable drawableFromUrl(Context context, String url, Integer size) throws IOException {
	    Bitmap x;
	
	    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	    connection.connect();
	    InputStream input = connection.getInputStream();
	
	    x = BitmapFactory.decodeStream(input);

	    Drawable drawable = new BitmapDrawable(context.getResources(), x);

	    return drawable;
	}

//
//	public Bitmap get(String gravatarId) {
//		InputStream is = downloadStreamFor(gravatarId);
//		try {
//			return BitmapFactory.decodeStream(new FlushedInputStream(is));
//		} finally {
//			closeQuietly(is);
//		}
//	}
//
//	private InputStream downloadStreamFor(String gravatarId) {
//		Log.d(TAG, "downloadStreamFor " + gravatarId);
//		try {
//			URL aURL = new URL("http://www.gravatar.com/avatar/"
//					+ encode(gravatarId) + "?s=" + size + "&d=mm");
//			HttpURLConnection conn = (HttpURLConnection) aURL.openConnection();
//			conn.setDoInput(true);
//			conn.connect();
//			return conn.getInputStream();
//		} catch (IOException ioe) {
//			Log.e(TAG, "downloadGravatar " + gravatarId, ioe);
//			throw new RuntimeException(ioe);
//		}
//	}
//	
	
	
	
}
