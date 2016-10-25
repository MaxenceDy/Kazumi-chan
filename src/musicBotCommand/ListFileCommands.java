/**
 * 
 */
package musicBotCommand;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kazumi.bot.command;

/**
 * @author Maxence
 *
 */
public class ListFileCommands implements command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		event.getTextChannel().sendMessage("voici les musique que je peux jouer suite à un !addf :"+
											"```"+
											
											"//Code Geass\n"+
											"CG_op\n\n"+
											
											
											"//Parasyte/kiseiju\n"+
											"parasyte_op\n\n"+
											
											"//Date A Live"+
											"DAL_op"+
											
											"//No Game No Life\n"+
											"NGNL_All_of_you\n\n"+
											
											"//Fairy Tail\n"+
											"FairyTailSadSong\n\n"+

											"//Nightcore\n"+
											"Nightcore\n\n"+
											
											"//One Piece\n"+
											"OnePieceOST_Hito\n"+
											"OnePieceOST_Tsuna\n"+
											"OnePieceOST_Mezamero\n"+
												"```");
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		
	}

}
