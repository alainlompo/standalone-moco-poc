package org.hypernovae.techwares;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SimpleJsonClient {
	
	private boolean hasJSessionIdHeader = false;
	private boolean hasContext = false;
	private String jSessionId;
	private String context;
	private int port;
	
	
	
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
	
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public  void executeJson() {
		
		if (this.hasContext && this.hasJSessionIdHeader) {
			executeJson(this.jsonDatas, this.getjSessionId(), this.getContext(), port);
			return;
		} else if (this.hasContext && !this.hasJSessionIdHeader) {
			
			executeJsonWithNoSession(this.jsonDatas, this.getContext(), port);
			return;
			
		}
		
		if (this.hasJSessionIdHeader) {
			executeJson(this.jsonDatas, this.getjSessionId(), port);
		} else {
			
			executeJson(this.jsonDatas, port);
			
		}
	}
	
	
public static void executeJsonWithNoSession(String jsonRequestDatas, String context, int port) {
		
		
		try {

			
	        URL url =(port > 0)? new URL("http://localhost:"+port + context): new URL("http://localhost"+ context);
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
	
	
	public static void executeJson(String jsonRequestDatas, String jSessionId, String context, int port) {
		
		
		try {

			
			URL url =(port > 0)? new URL("http://localhost:"+port + context): new URL("http://localhost"+ context);
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
	
	public static void executeJson(String jsonRequestDatas, String jSessionId, int port) {
		
		
		try {

			
			URL url =(port > 0)? new URL("http://localhost:"+port ): new URL("http://localhost");
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


	public static void executeJson(String jsonRequestDatas, int port) {
		
		
		try {

			URL url =(port > 0)? new URL("http://localhost:"+port ): new URL("http://localhost");
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
