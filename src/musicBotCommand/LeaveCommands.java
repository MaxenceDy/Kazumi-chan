/**
 * 
 */
package musicBotCommand;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kazumi.bot.command;

/**
 * @author Maxence
 *
 */
public class LeaveCommands implements command {

	private final String HELP = "USAGE: !LEAVE";
	
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub		
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		
		event.getGuild().getAudioManager().closeAudioConnection();
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
		
		
		
	}

}
