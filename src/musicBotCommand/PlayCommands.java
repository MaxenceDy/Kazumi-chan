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
public class PlayCommands implements command {
	
	private final String HELP = "USAGE: !PLAY";
	
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		//if(event.getJDA().getVoiceChannels().contains("Kazumi-chan")) return true;
		//else return false;
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub	
		
		MainBot.getPlayer().play();
		event.getGuild().getAudioManager().setSendingHandler(MainBot.getPlayer());
		
		
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
