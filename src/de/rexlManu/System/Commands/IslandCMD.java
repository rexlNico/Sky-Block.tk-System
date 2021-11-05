package de.rexlManu.System.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.rexlManu.System.Island.Island;

public class IslandCMD implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender cs, Command c, String s, String[] ss) {
		if(!(cs instanceof Player)){
			cs.sendMessage("blabla");
		}
		Player p = (Player)cs;
		Island.createIsland(p);
		
		return false;
	}

}
