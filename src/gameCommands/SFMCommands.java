/**
 * 
 */
package gameCommands;

import java.io.File;
import java.util.Random;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kazumi.bot.command;

/**
 * @author Maxence
 *
 */
public class SFMCommands implements command {
	
	private final String HELP = "USAGE: !HT <pierre/feuille/ciseau>";
	Random rand = new Random();
	
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		if(args.length < 1) return false;
		else if(args.length > 1) return false;
		if(event.getMessage().getContent().contains("pier") || event.getMessage().getContent().contains("feui") || event.getMessage().getContent().contains("cis")){
			return true;
		}
		else return false;

	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		
		int i = rand.nextInt(3);
		File sendFile = null;
		
		String SFM[] = {
				"C:\\Users\\maxen_000\\Pictures\\Uplay\\pierre.JPG",
				"C:\\Users\\maxen_000\\Pictures\\Uplay\\feuille.JPG",
				"C:\\Users\\maxen_000\\Pictures\\Uplay\\ciseau.JPG",
		};
		
		sendFile = new File(SFM[i]);
		
		event.getTextChannel().sendFile(sendFile, null);
		

	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return HELP;
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		if(!success) event.getChannel().sendMessage(help());
	}

}
