import org.jibble.pircbot.*;
import org.bitpipeline.lib.owm.*;
import java.net.*;
import java.io.*;

public class ChatBot extends PircBot {
	
	public ChatBot() {
		this.setName("ChatBot");
	}
	
	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		if(message.equalsIgnoreCase("time")) {
			String time = new java.util.Date().toString();
			sendMessage(channel, sender + ": The time is now " + time);
		} else if(message.equalsIgnoreCase("weather")) {
			String zipCode = "75080";
			String weather = getUrlContents("http://api.openweathermap.org/data/2.5/weather?zip="+zipCode+"&APPID=cb7b26f4bc9b311c1dea2ddaf6e21125");
			sendMessage(channel, sender + ": The Weather details: " + weather);
		}
	}
	 private static String getUrlContents(String theUrl)
	  {
	    StringBuilder content = new StringBuilder();

	    // many of these calls can throw exceptions, so i've just
	    // wrapped them all in one try/catch statement.
	    try
	    {
	      // create a url object
	      URL url = new URL(theUrl);

	      // create a urlconnection object
	      URLConnection urlConnection = url.openConnection();

	      // wrap the urlconnection in a bufferedreader
	      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

	      String line;

	      // read from the urlconnection via the bufferedreader
	      while ((line = bufferedReader.readLine()) != null)
	      {
	        content.append(line + "\n");
	      }
	      bufferedReader.close();
	    }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	    }
	    return content.toString();
	  }
}
