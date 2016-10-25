/**
 * 
 */
package musicBotCommand;

import net.dv8tion.jda.entities.VoiceChannel;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kazumi.bot.command;
/**
 * @author Maxence
 *
 */
public class JoinCommands implements command {
	
	private final String HELP = "USAGE: !JOIN";
	
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		
		boolean userInChan = false;
		
		for(VoiceChannel chan : event.getGuild().getVoiceChannels()){
			if(chan.getUsers().contains(event.getMessage().getAuthor())){
				userInChan = true;
				break;
			}
		}
		
		return userInChan;
		
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		
		
		VoiceChannel vc = null;
		
		for(VoiceChannel chan : event.getGuild().getVoiceChannels()){
			if(chan.getUsers().contains(event.getMessage().getAuthor())){
				vc = chan;
				break;
			}
		}
		
		
		try{
			event.getGuild().getAudioManager().openAudioConnection(vc);
			
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
			event.getChannel().sendMessage(help());
			event.getChannel().sendMessage("si le problème persiste veuillez vérifier le nom du channel où demander à kaze");
		}
		
		
		
	}

}
