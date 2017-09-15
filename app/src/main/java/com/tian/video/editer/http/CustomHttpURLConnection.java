package com.tian.video.editer.http;


import android.app.ProgressDialog;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 */
public class CustomHttpURLConnection {
	private static String TAG = "CustomHttpUrlConnection";

	public CustomHttpURLConnection() {
	}

	public static String GetFromWebByHttpUrlConnection(String strUrl
			) {
		String result = "";
		try {
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(6000);
			conn.setRequestProperty("accept", "*/*");
			// int resCode=conn.getResponseCode();
			conn.connect();
			InputStream stream = conn.getInputStream();
			InputStreamReader inReader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(inReader);
			String strLine = null;
			while ((strLine = buffer.readLine()) != null) {
				result += strLine;
			}
			inReader.close();
			conn.disconnect();
			return result;
		} catch (MalformedURLException e) {
			Log.e(TAG, "getFromWebByHttpUrlCOnnection:" + e.getMessage());
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			Log.e(TAG, "getFromWebByHttpUrlCOnnection:" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param strUrl
	 * @param sessionId
	 * @param auth 
	 * @return
	 */
	public static String PostFromWebByHttpURLConnection(String strUrl,
                                                        String sessionId, String auth) {
		String result = "";
		try {
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if(sessionId != null) {
				sessionId= "JXJYSSO=" + sessionId;
				conn.setRequestProperty("cookie", sessionId);
			}
			

			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(1000*20);
			conn.setReadTimeout(1000*25);
			conn.setUseCaches(false);
			conn.setInstanceFollowRedirects(true);
			conn.setRequestProperty("Content-Type","text/xml");
			conn.connect();
			int responseCode = conn.getResponseCode();
			Log.e("考试提交",responseCode+"");
			if(conn.getResponseCode()==200){
			 InputStream in = conn.getInputStream();
			InputStreamReader inStream = new InputStreamReader(in);
			BufferedReader buffer = new BufferedReader(inStream);
			String strLine = null;
			while ((strLine = buffer.readLine()) != null) {
				result += strLine;
			}
			inStream.close();
			//conn.disconnect();
			}
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}
	
	public static String PostFromWebByHttpURLConnection1(String strUrl,
                                                         String sessionId, String auth) {
		String result = "";
		try {
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if(sessionId != null) {
				sessionId= "JSESSIONID=" + sessionId +";jchome_auth=" + auth;
				//auth = "auth=" + auth;
				conn.setRequestProperty("cookie", sessionId);
			}
			
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(1000*20);
			conn.setReadTimeout(1000*25);
			conn.setUseCaches(false);
			conn.setInstanceFollowRedirects(true);
			conn.setRequestProperty("Content-Type","text/xml");
			conn.connect();
			if(conn.getResponseCode()==200){
			 InputStream in = conn.getInputStream();
			InputStreamReader inStream = new InputStreamReader(in);
			BufferedReader buffer = new BufferedReader(inStream);
			String strLine = null;
			while ((strLine = buffer.readLine()) != null) {
				result += strLine;
			}
			inStream.close();
			//conn.disconnect();
			}
			return result;
		} catch (Exception ex) {
			Log.e(TAG, "PostFromWebByHttpURLConnection��" + ex.getMessage());
			ex.printStackTrace();
			
			return "";
		}
	}
	
	
	
	/**
	 * 版本更新apk
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static File downloadApk(String path, ProgressDialog pb)
			throws Exception {
		File file = new File(Environment.getExternalStorageDirectory(),
				getFileName(path));
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5000);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept-Encoding", "identity"); 
		int responseCode = conn.getResponseCode();
		if (conn.getResponseCode() == 200) {
			int max = conn.getContentLength();
			pb.setMax(max);
			int count = 0;

			InputStream is = conn.getInputStream();
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = is.read(buffer)) != -1) {
				// SystemClock.sleep(200);
				fos.write(buffer, 0, len);
				count = count + len;
				pb.setProgress(count);
			}
			is.close();
			fos.close();
		}
		return file;
	}
	
	/**
	 * �õ��ļ������
	 * 
	 * @param path
	 * @return
	 */
	private static String getFileName(String path) {
		return path.substring(path.lastIndexOf("/") + 1);
	}
}
