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
public class RestartCommands implements command {

	private final String HELP = "USAGE: !RESTART";
	
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		if (MainBot.getPlayer() != null) return true;
		else {
			event.getChannel().sendMessage("je ne peux pas restart alors que je ne joue rien");
			return false;
		}
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		MainBot.getPlayer().restart();
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
