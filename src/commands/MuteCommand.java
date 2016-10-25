/**
 * 
 */
package commands;

import net.dv8tion.jda.Permission;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.managers.GuildManager;
import net.dv8tion.jda.utils.PermissionUtil;
import net.kazumi.bot.command;

/**
 * @author Maxence
 *
 */
public class MuteCommand implements command {

	private final String HELP = "USAGE: !mute <@user>";
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		if(args.length < 1) return false;
		if(event.getMessage().getMentionedUsers().size() < 1) return false;
		if(!PermissionUtil.checkPermission(event.getJDA().getSelfInfo(), Permission.VOICE_MUTE_OTHERS, event.getGuild())) return false;
	
		boolean UserExists = false;
		
		if(event.getGuild().getUsers().contains(event.getMessage().getMentionedUsers().get(0))){
			UserExists = true;
		}
		
		return UserExists;
		
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		GuildManager gm = new GuildManager(event.getGuild());
		
		try{
			
			gm.mute(event.getMessage().getMentionedUsers().get(0));
			
		}catch(Exception e){
			event.getTextChannel().sendMessage("erreur durant la commande");
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
			event.getTextChannel().sendMessage(help());
		}
	}

}
