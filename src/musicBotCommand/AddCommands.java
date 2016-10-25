/**
 * 
 */
package musicBotCommand;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.UnsupportedAudioFileException;

import net.dv8tion.jda.audio.player.URLPlayer;

//import java.io.File;
//import java.net.URL;

//import net.dv8tion.jda.audio.player.Player;
//import net.dv8tion.jda.audio.player.URLPlayer;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kazumi.bot.MainBot;
import net.kazumi.bot.command;

/**
 * @author Maxence
 *
 */
public class AddCommands implements command {

	private final String HELP = "USAGE: !ADD <lien mp3, swf, etc> (URL youtube etc unsupportable actually I promise I will try my best to do it)";
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		if(args.length < 1) return false;
		else return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
        URL audioUrl = null;
		MainBot.setPlayer(MainBot.getPlayers().get(event.getGuild().getId()));
		
		try {
			
			audioUrl = new URL(args[0]);
			
			
			MainBot.setPlayer(new URLPlayer(event.getJDA(), audioUrl));
			
			
			MainBot.getPlayers().put(event.getGuild().getId(), MainBot.getPlayer());
			
			//event.getGuild().getAudioManager().setSendingHandler(MainBot.getPlayer());
			
			//URL non reconnue
		} catch (MalformedURLException e) {
			e.printStackTrace();
			
			event.getChannel().sendMessage("please try again with different URL maybe this is wrong so I can't play this :(");
			
			
			// erreur IOException
		} catch (IOException e) {
			e.printStackTrace();
			
			event.getChannel().sendMessage("Could not load the file. Does it exist?  File name: " + audioUrl.getRef());
			
			//fichier incompatible
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
			
			event.getChannel().sendMessage("Could not load file. It either isn't an audio file or isn't a" +
			        " recognized audio format.");
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
