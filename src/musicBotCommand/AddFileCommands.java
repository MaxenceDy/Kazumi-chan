/**
 * 
 */
package musicBotCommand;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;

import net.dv8tion.jda.audio.player.FilePlayer;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kazumi.bot.MainBot;
import net.kazumi.bot.command;

/**
 * @author Maxence
 *
 */
public class AddFileCommands implements command {

	private final String HELP = "USAGE: !ADD <fichier> (faire un !listf pour voir les fichier dispo)";
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		if(args.length < 1) return false;
		else return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
        
		String path = "C:\\Users\\maxen_000\\Desktop\\musique\\";
		
		File audioFile = null;
		MainBot.setPlayer(MainBot.getPlayers().get(event.getGuild().getId()));
		
		try {
			
			audioFile = new File(path + args[0] + ".mp3");
			
			
			MainBot.setPlayer(new FilePlayer(audioFile));
			
			
			MainBot.getPlayers().put(event.getGuild().getId(), MainBot.getPlayer());
			
			event.getGuild().getAudioManager().setSendingHandler(MainBot.getPlayer());
			
			//MainBot.getPlayer().play();
			
			event.getChannel().sendMessage("I'm playing: " + audioFile.getName());
			
			
			//URL non reconnue
		} catch (IOException e) {
			e.printStackTrace();
			
			event.getChannel().sendMessage("Could not load the file. Does it exist?  File name: " + audioFile.getName());
			
			//fichier incompatible
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
			
			event.getChannel().sendMessage("Could not load file. It either isn't an audio file or isn't a" +
			        " recognized audio format.");
		} catch (IllegalArgumentException e){
			event.getChannel().sendMessage("le fichier que vous voulez n'a pas été trouver dans les musique de kaze, veuillez faire un !listf pour voir les musique disponible");
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
