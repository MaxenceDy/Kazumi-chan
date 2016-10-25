/**
 * 
 */
package musicBotCommand;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kazumi.bot.MainBot;
import net.kazumi.bot.command;

/**
 * @author Maxence
 *
 */
public class PauseCommands implements command {

	private final String HELP = "USAGE: !PAUSE";
	
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		//if(event.getJDA().getVoiceChannels().contains("Kazumi-chan")) return true;
		//else return false;
		if (MainBot.getPlayer() != null) return true;
		else {
			event.getChannel().sendMessage("je ne peux pas mettre en pause alors que je ne joue rien");
			return false;
		}
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		
		MainBot.getPlayer().pause();
		
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return HELP;
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		if (!success) event.getChannel().sendMessage(help());
	}

}
