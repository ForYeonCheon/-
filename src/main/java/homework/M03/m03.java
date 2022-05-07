package homework.M03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;

public class m03 {
	
	public static void main(String[] args) 
	{
		
		try 
		{
			
			StringBuilder stringBuilder = new StringBuilder();
			String strLine;
			JSONObject responseJson = null;
			
		
			System.out.println("Start Test");
			
			URL url = new URL("https://api.androidhive.info/contacts/");
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			
			httpUrlConnection.setConnectTimeout(3000);
			httpUrlConnection.setReadTimeout(3000);
			httpUrlConnection.setRequestProperty("User-Agent", "Mozilla/4.0");
			httpUrlConnection.addRequestProperty("", "");
			httpUrlConnection.setRequestMethod("GET");
			httpUrlConnection.setDoOutput(true);
			
			if(httpUrlConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
			{
				BufferedReader bufferedReadr = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream(), "utf-8"));
			
				while((strLine = bufferedReadr.readLine()) != null)
				{
					stringBuilder.append(strLine).append("\n");
				}
				bufferedReadr.close();
				
				System.out.println("\n");
				System.out.println("succes connection");
				System.out.println(httpUrlConnection.getResponseCode());
				System.out.println(httpUrlConnection.getResponseMessage());
				System.out.println(httpUrlConnection.toString());
				
				//System.out.println(httpUrlConnection.getContent());
				System.out.println(httpUrlConnection.getInputStream());
				
				BufferedReader br = new BufferedReader (new InputStreamReader(httpUrlConnection.getInputStream()));
				StringBuilder sb = new StringBuilder();
				while(br.ready()) {
					sb.append(br.readLine());
				}
				
				
				
			}else {
				
				System.out.println("\n");
				System.out.println("failed connection");
				
			}
			
		} catch (Exception e) {
			System.out.println("Exception :" + e.toString());
		}
		
		System.out.println("\n");
		System.out.println("End Test");
		
	}

}
