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
public class PikaCommand implements command {

	private final String HELP = "USAGE: !pika";
	
	/* (non-Javadoc)
	 * @see net.kazumi.bot.command#called(java.lang.String[], net.dv8tion.jda.events.message.MessageReceivedEvent)
	 */
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see net.kazumi.bot.command#action(java.lang.String[], net.dv8tion.jda.events.message.MessageReceivedEvent)
	 */
	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		event.getChannel().sendTyping();
		event.getChannel().sendMessage("CHUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	/* (non-Javadoc)
	 * @see net.kazumi.bot.command#help()
	 */
	@Override
	public String help() {
		// TODO Auto-generated method stub
		return HELP;
	}

	/* (non-Javadoc)
	 * @see net.kazumi.bot.command#executed(boolean, net.dv8tion.jda.events.message.MessageReceivedEvent)
	 */
	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return;
	}

}
