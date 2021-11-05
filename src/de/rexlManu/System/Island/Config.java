package de.rexlManu.System.Island;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import de.rexlManu.System.Utils.LocationHelper;

public class Config {

	private File file = new File("System/island.yml");
	private YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public Config(){
		create();
		
		
		
	}
	public int getIslandCount(){
		return cfg.getInt("Islandcount");
	}
	public void saveIslandCount(){
		cfg.set("Islandcount", Island.currentIslandCount);
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveLastIslandLocation(){
		LocationHelper.saveLocation(Island.currentNewestIslandLocation, file, cfg, "NewestIsland");
	}
	public Location getLastIslandLocation(){
		if(!cfg.contains("NewestIsland")){
			return new Location(Bukkit.getWorld("SkyBlock"), 0, 100, 0);
		}
		return LocationHelper.getSavedLocation(file, cfg, "NewestIsland");
	}
	
	
	private void create(){
		if(!file.exists()){
			cfg.set("Islandcount", 0);
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
