/**
 * 
 */
package commands;

import net.dv8tion.jda.Permission;
import net.dv8tion.jda.entities.VoiceChannel;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.managers.GuildManager;
import net.dv8tion.jda.utils.PermissionUtil;
import net.kazumi.bot.command;


/**
 * @author Maxence
 *
 */
public class MoveCommand implements command {

	private final String HELP = "USAGE: !move <@user> <channel name>";
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		if(args.length < 2) return false;
		if(event.getMessage().getMentionedUsers().size() < 1) return false;
		if(!PermissionUtil.checkPermission(event.getJDA().getSelfInfo(), Permission.VOICE_MOVE_OTHERS, event.getGuild())) return false;
	
		boolean chanExists = false;
		boolean userInChan = false;
		
		for(VoiceChannel chan : event.getGuild().getVoiceChannels()){
			if(chan.getName().equalsIgnoreCase(args[1])){
				chanExists = true;
				break;
			}
		}
		
		for(VoiceChannel chan : event.getGuild().getVoiceChannels()){
			if(chan.getUsers().contains(event.getMessage().getMentionedUsers().get(0))){
				userInChan = true;
				break;
			}
			
		}
		
		return chanExists && userInChan;
		
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		GuildManager gm = new GuildManager(event.getGuild());
		
		VoiceChannel vc = null;
		
		for(VoiceChannel chan : event.getGuild().getVoiceChannels()){
			if(chan.getName().equalsIgnoreCase(args[1])){
				vc = chan;
				break;
			}
		}
		
		try{
			
			gm.moveVoiceUser(event.getMessage().getMentionedUsers().get(0), vc);
			
			
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
