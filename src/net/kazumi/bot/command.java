/**
 * 
 */
package net.kazumi.bot;

import net.dv8tion.jda.events.message.MessageReceivedEvent;

/**
 * @author Maxence
 *
 */
public interface command {
	
	public boolean called(String[] args, MessageReceivedEvent event);
	public void action(String[] args, MessageReceivedEvent event);
	public String help();
	public void executed(boolean success, MessageReceivedEvent event);
}
