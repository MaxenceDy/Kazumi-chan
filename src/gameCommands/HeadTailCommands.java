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
public class HeadTailCommands implements command {

	private final String HELP = "USAGE: !HT <pile/face>";
	Random rand = new Random();
	
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		if(args.length < 1) return false;
		else if(args.length > 1) return false;
		if(event.getMessage().getContent().contains("pile") || event.getMessage().getContent().contains("face")){
			return true;
		}
		else return false;
		
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		
		int v = 0;
		int i = rand.nextInt(1+1);
		File sendFile = null;
		
		if(event.getMessage().getContent().contains("pile")){
			v = 0;
		}
		else if(event.getMessage().getContent().contains("face")){
			v = 1;
		}
		else event.getChannel().sendMessage(help());
		
		
		String Coins[] = {
				
				//heads = pile & tails = face
				
				"C:\\Users\\maxen_000\\workspace\\Kazumi_java\\ressource\\heads.png",
				"C:\\Users\\maxen_000\\workspace\\Kazumi_java\\ressource\\tails.png"
		};
		
		sendFile = new File(Coins[i]);
		
		event.getTextChannel().sendFile(sendFile, null);
		
		if(i == 0){
			event.getChannel().sendMessage("pile!.....");
		}
		else{
			event.getChannel().sendMessage("face!.....");
		}
		
		
		if(v == i){
			event.getChannel().sendMessage("mince j'ai perdu...");
		}
		else{
			event.getChannel().sendMessage("YES GAGNER");
		}
		
		
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return HELP;
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		if(!success){
			event.getChannel().sendMessage(help());
		}
		else{
			return;
		}
	}

}
