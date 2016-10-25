package net.kazumi.bot;

import net.dv8tion.jda.JDA;
import net.dv8tion.jda.JDABuilder;
import net.dv8tion.jda.audio.player.Player;
import commands.HelpCommand;
import commands.MoveCommand;
import commands.MuteCommand;
import commands.PikaCommand;
import commands.PingCommand;
import commands.StopCommand;
import commands.UnmuteCommand;
import gameCommands.HeadTailCommands;
import gameCommands.SFMCommands;
import musicBotCommand.AddCommands;
import musicBotCommand.AddFileCommands;
import musicBotCommand.JoinCommands;
import musicBotCommand.LeaveCommands;
import musicBotCommand.ListFileCommands;
import musicBotCommand.PauseCommands;
import musicBotCommand.PlayCommands;
import musicBotCommand.RestartCommands;
import musicBotCommand.StopMusicCommands;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.LoginException;

public class MainBot {

    private static JDA jda;
    
    private static String KazuToken = "MjI3MjAzNDE0NDAzMTg2Njkw.CtZyyw.Rq8YJPNiHPJ3EZyzUNS0F_eWxKU";
    //private static String SatanToken = "MTg5NzA1NTE5MTYwNzU0MTc3.CteksQ.gwcAg-855HxlYLXzI6WBVPvprU0";
    
    public static final CommandParser parser = new CommandParser();
    
    private static HashMap<String, command> commands = new HashMap<String, command>();
    private static Map<String,Player> players = new HashMap<>();
    static Player player;
    
    public static void main(String[] args){
    	try {
            jda = new JDABuilder().addListener(new BotListener()).setBotToken(KazuToken).setBulkDeleteSplittingEnabled(false).buildBlocking();
            jda.setAutoReconnect(true);
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("Une erreur est survenue vieulliez verifier le token ou votre connection internet");
            return;
        }
        System.out.println("Connecte avec: " + jda.getSelfInfo().getUsername());
        int i;
        System.out.println("Le bot est autorisé sur " + (i = jda.getGuilds().size()) + " serveur" + (i > 1 ? "s" : ""));
        
        //commande help
        commands.put("help", new HelpCommand());
        
        
        //commande divers
        commands.put("ping", new PingCommand());
        commands.put("pika", new PikaCommand());
        
        
        //commande d'arrêt
        commands.put("deco", new StopCommand());
        
        
        //commande admin
        commands.put("move", new MoveCommand());
        commands.put("mute", new MuteCommand());
        commands.put("unmute", new UnmuteCommand());
        
        //jeux
        commands.put("ht", new HeadTailCommands());
        commands.put("sfm", new SFMCommands());
        
        
        //commande botmusic
        commands.put("join", new JoinCommands());
        commands.put("leave", new LeaveCommands());
        commands.put("play", new PlayCommands());
        commands.put("pause", new PauseCommands());
        commands.put("add", new AddCommands());
        commands.put("addf", new AddFileCommands());
        commands.put("listf", new ListFileCommands());
        commands.put("stop", new StopMusicCommands());
        commands.put("restart", new RestartCommands());
        
        
    }


	public static void handleCommand(CommandParser.CommandContainer cmd) {
		
		if(commands.containsKey(cmd.invoke)){
			boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);
			
			if(safe){
				commands.get(cmd.invoke).action(cmd.args, cmd.event);
				commands.get(cmd.invoke).executed(safe, cmd.event);
			} else{
				commands.get(cmd.invoke).executed(safe, cmd.event);
			}
		}
	}


	public static JDA getJda() {
		return jda;
	}


	public static void setJda(JDA jda) {
		MainBot.jda = jda;
	}


	public static Map<String,Player> getPlayers() {
		return players;
	}


	public void setPlayers(Map<String,Player> players) {
		MainBot.players = players;
	}


	/**
	 * @return the player
	 */
	public static Player getPlayer() {
		return player;
	}


	/**
	 * @param player the player to set
	 */
	public static void setPlayer(Player player) {
		MainBot.player = player;
	}
}
