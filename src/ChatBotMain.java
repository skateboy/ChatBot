
import org.jibble.pircbot.*;

public class ChatBotMain {

	public static void main(String[] args) throws Exception {
		
		// Initialize bot
		ChatBot bot = new ChatBot();
		
		// Enable debugging output
		bot.setVerbose(true);
		
		// Connect to the IRC server
		bot.connect("irc.freenode.net");
		
		// Join the  #pircbot channel
		bot.joinChannel("#pircbot");

	}

}
