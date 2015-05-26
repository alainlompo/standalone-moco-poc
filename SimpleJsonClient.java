package ma.awb.mbk.services.mocorunner;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

public class SimpleJsonClient {
	
	private boolean hasJSessionIdHeader = false;
	private boolean hasContext = false;
	private String jSessionId;
	private String context;
	
	
	
	
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		if (null != context) {
			this.hasContext = true;
		}
		this.context = context;
	}

	public boolean getHasContext() {
		return hasContext;
	}

	public void setHasContext(boolean hasContext) {
		this.hasContext = hasContext;
	}

	
	
	public String getjSessionId() {
		return jSessionId;
	}

	public void setjSessionId(String jSessionId) {
		if (null != jSessionId) {
			this.hasJSessionIdHeader = true;
		}
		this.jSessionId = jSessionId;
	}

	private String jsonDatas;
	
	public String getJsonDatas() {
		return jsonDatas;
	}
	
	public void setJsonDatas(String jsonDatas) {
		this.jsonDatas = jsonDatas;
	}
	
	
	public void setHasJSessionIdHeader (boolean hasJSessionIdHeader)  {
		this.hasJSessionIdHeader = hasJSessionIdHeader;
	}
	
	public boolean getHasJSessionIdHeader() {
		return this.hasJSessionIdHeader;
	}
	
	public SimpleJsonClient(String jsonDatas) {
		this.jsonDatas = jsonDatas;
		
	}
	
	public  void executeJson() {
		
		if (this.hasContext && this.hasJSessionIdHeader) {
			executeJson(this.jsonDatas, this.getjSessionId(), this.getContext());
			return;
		} else if (this.hasContext && !this.hasJSessionIdHeader) {
			
			executeJsonWithNoSession(this.jsonDatas, this.getContext());
			return;
			
		}
		
		if (this.hasJSessionIdHeader) {
			executeJson(this.jsonDatas, this.getjSessionId());
		} else {
			
			executeJson(this.jsonDatas);
			
		}
	}
	
	
public static void executeJsonWithNoSession(String jsonRequestDatas, String context) {
		
		
		try {

			
	        URL url = new URL("http://localhost:10001" + context);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setDoOutput(true);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json");
	        

	        String input = jsonRequestDatas;
	       
	        OutputStream os = conn.getOutputStream();
	        os.write(input.getBytes());
	        os.flush();

	        if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED && conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	            throw new RuntimeException("Failed : HTTP error code : "
	                + conn.getResponseCode());
	        }

	        String jSessionIDValue = conn.getHeaderField("JSESSIONID");
	        if (null != jSessionIDValue) {
	        	System.out.println("There is a jsessionid value: " + jSessionIDValue);
	        }
	        
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(
	                (conn.getInputStream())));

	        String output;
	        System.out.println("Output from Server .... \n");
	        while ((output = br.readLine()) != null) {
	            System.out.println(output);
	        }

	        conn.disconnect();

	      } catch (MalformedURLException e) {

	        e.printStackTrace();

	      } catch (IOException e) {

	        e.printStackTrace();

	     }
	}
	
	
	public static void executeJson(String jsonRequestDatas, String jSessionId, String context) {
		
		
		try {

			
	        URL url = new URL("http://localhost:10001" + context);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setDoOutput(true);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.addRequestProperty("JSESSIONID", jSessionId);

	        String input = jsonRequestDatas;
	       
	        OutputStream os = conn.getOutputStream();
	        os.write(input.getBytes());
	        os.flush();

	        if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED && conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	            throw new RuntimeException("Failed : HTTP error code : "
	                + conn.getResponseCode());
	        }

	        String jSessionIDValue = conn.getHeaderField("JSESSIONID");
	        if (null != jSessionIDValue) {
	        	System.out.println("There is a jsessionid value: " + jSessionIDValue);
	        }
	        
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(
	                (conn.getInputStream())));

	        String output;
	        System.out.println("Output from Server .... \n");
	        while ((output = br.readLine()) != null) {
	            System.out.println(output);
	        }

	        conn.disconnect();

	      } catch (MalformedURLException e) {

	        e.printStackTrace();

	      } catch (IOException e) {

	        e.printStackTrace();

	     }
	}
	
	public static void executeJson(String jsonRequestDatas, String jSessionId) {
		
		
		try {

			
	        URL url = new URL("http://localhost:10001");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setDoOutput(true);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.addRequestProperty("JSESSIONID", jSessionId);

	        String input = jsonRequestDatas;
	       
	        OutputStream os = conn.getOutputStream();
	        os.write(input.getBytes());
	        os.flush();

	        if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED && conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	            throw new RuntimeException("Failed : HTTP error code : "
	                + conn.getResponseCode());
	        }

	        String jSessionIDValue = conn.getHeaderField("JSESSIONID");
	        if (null != jSessionIDValue) {
	        	System.out.println("There is a jsessionid value: " + jSessionIDValue);
	        }
	        
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(
	                (conn.getInputStream())));

	        String output;
	        System.out.println("Output from Server .... \n");
	        while ((output = br.readLine()) != null) {
	            System.out.println(output);
	        }

	        conn.disconnect();

	      } catch (MalformedURLException e) {

	        e.printStackTrace();

	      } catch (IOException e) {

	        e.printStackTrace();

	     }
	}


	public static void executeJson(String jsonRequestDatas) {
		
		
		try {

	        URL url = new URL("http://localhost:10001");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setDoOutput(true);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json");

	        String input = jsonRequestDatas;
	       
	        OutputStream os = conn.getOutputStream();
	        os.write(input.getBytes());
	        os.flush();

	        if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED && conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	            throw new RuntimeException("Failed : HTTP error code : "
	                + conn.getResponseCode());
	        }

	        String jSessionIDValue = conn.getHeaderField("JSESSIONID");
	        if (null != jSessionIDValue) {
	        	System.out.println("There is a jsessionid value: " + jSessionIDValue);
	        }
	        
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(
	                (conn.getInputStream())));

	        String output;
	        System.out.println("Output from Server .... \n");
	        while ((output = br.readLine()) != null) {
	            System.out.println(output);
	        }

	        conn.disconnect();

	      } catch (MalformedURLException e) {

	        e.printStackTrace();

	      } catch (IOException e) {

	        e.printStackTrace();

	     }
	}

}
