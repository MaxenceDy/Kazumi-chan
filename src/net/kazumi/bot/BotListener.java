/**
 * 
 */
package net.kazumi.bot;

import net.dv8tion.jda.events.ReadyEvent;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;

/**
 * @author Maxence
 *
 */
public class BotListener extends ListenerAdapter {
	
	//boolean m = false;
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event){
		
		//if (m == false){
		//	Player player = MainBot.getPlayers().get(event.getGuild().getId());
		//	m = true;
		//}
		
		boolean isPrivate = event.isPrivate();
		
		if(event.getMessage().getContent().startsWith("!") && event.getMessage().getAuthor().getId() != event.getJDA().getSelfInfo().getId()) MainBot.handleCommand(MainBot.parser.parser(event.getMessage().getContent().toLowerCase(), event));
		
		if(!isPrivate){
            System.out.printf("[%s][%s]\t%s: %s\n", event.getGuild().getName(), event.getTextChannel().getName(),
                    event.getAuthor().getUsername(), event.getMessage().getContent());

		}
		else if(isPrivate){
			System.out.printf("[PM]\t%s: %s\n", event.getAuthor().getUsername(), event.getMessage().getContent());
		}
		
	}
	
	@Override
	public void onReady(ReadyEvent event){
		//MainBot.log("status", "Logged in as: " + event.getJDA().getSelfInfo().getUsername());
		
	
	}
	
	
	
}
