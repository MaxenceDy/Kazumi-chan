/**
 * 
 */
package commands;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kazumi.bot.command;

/**
 * @author Maxence
 *
 */
public class PingCommand implements command{
	
	private final String HELP = "USAGE: !ping";
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		event.getChannel().sendTyping();
		event.getChannel().sendMessage("PONG");
	}

	@Override
	public String help() {
		return HELP;
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		return;
	}



}
