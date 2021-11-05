package de.rexlManu.System;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.rexlManu.System.Commands.IslandCMD;
import de.rexlManu.System.Island.Config;
import de.rexlManu.System.VoidWorld.VoidGenerator;

public class Main extends JavaPlugin{
	
	private static Main plugin;
	PluginManager pm = Bukkit.getPluginManager();
	
	@Override
	public void onEnable() {
		
		
		plugin = this;
		if(Bukkit.getWorld("SkyBlock") == null){
			
			Bukkit.setWhitelist(true);
			Bukkit.getConsoleSender().sendMessage("§cEs wurde die Whitelist aktiviert.");
			
			WorldCreator w = new WorldCreator("SkyBlock");
			w.generator(new VoidGenerator());
			w.generateStructures(false);
			Bukkit.createWorld(w);
			
			for(Player all:Bukkit.getOnlinePlayers()){
				all.teleport(Bukkit.getWorld("SkyBlock").getSpawnLocation());
				all.sendMessage("§aAlle wurden zur SkyBlock-Welt teleportiert.");
			}
		}
		
		load();
		
	}
	@Override
	public void onDisable() {
		new Config().saveIslandCount();
		new Config().saveLastIslandLocation();
	}
	
	public static Main getPlugin() {
		return plugin;
	}
	private void load(){
		reg(new IslandCMD(),"island");
	}
	private void reg(CommandExecutor cx,String cmd){
		getCommand(cmd).setExecutor(cx);
	}
	private void reg(Listener listener){
		pm.registerEvents(listener, this);
	}
}
