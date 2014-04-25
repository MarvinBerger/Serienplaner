package com.MB.sp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.database.sqlite.SQLiteException;
import android.util.Log;

public class ServerAccess {
	static String url = "http://daten-duw-energie.de/battery/service.php";
	public static String convertStreamToString(InputStream is)
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		
		String line = null;
		try{
		while((line = reader.readLine())!=null)
			sb.append(line);
		}catch(IOException io){
		Log.e("PHP Client","Error: "+io.getMessage());
		}
		finally
		{
			try{
				is.close();
			}catch(IOException i)
			{
				Log.e("PHP Client", "Error: "+i.getMessage());
			}
		}
		return sb.toString();
	}
	/* BasicNameValuePair p = new BasicNameValuePair("POSTNAME", "value");
	*	ArrayList list = new ArrayList();
	*list.add(p);
	*String s = getResponseObject(list);
	*
	*/
	public  static String getResponseObject(ArrayList parameters)
	 {
	  try{
	   //Create a HTTP Client
	   HttpClient httpclient = new DefaultHttpClient();
	 
	   //Create and object to Post values to the server
	   //The url is specified in the Constants class to increase modifiability
	   HttpPost httppost = new HttpPost(url);
	 
	   //Set the attributes to be posted as Parameters
	   httppost.setEntity(new UrlEncodedFormEntity(parameters));
	 
	   //Execute the post and get the response
	   HttpResponse response = httpclient.execute(httppost);
	 
	   //Get the response as ans entity
	   HttpEntity entity = response.getEntity();
	 
	   //Get the content of the response as a stream
	   InputStream stream=entity.getContent();
	 
	   //Convert the stream to a GSON object
	         String result= convertStreamToString(stream);
	         Log.i("Output:", result);
	   //Return the object
	         return result;
	  }catch(Exception e){
	   Log.e("PHP Client", "Error in http connection"+e.toString());
	   return "";
	  }
	 }
	
}
