package de.rexlManu.System.Utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

public class LocationHelper {

	public static void saveLocation(Location loc,File file,YamlConfiguration cfg,String path){
		
		cfg.set(path+".Welt", loc.getWorld().getName());
		cfg.set(path+".X", loc.getX());
		cfg.set(path+".Y", loc.getY());
		cfg.set(path+".Z", loc.getZ());
		cfg.set(path+".Pitch", loc.getPitch());
		cfg.set(path+".Yaw", loc.getYaw());
		try {
			cfg.save(file);
		} catch (IOException e) {
		}
	}
	public static Location getSavedLocation(File file,YamlConfiguration cfg,String path){
		return new Location(Bukkit.getWorld(cfg.getString(path+".Welt")), cfg.getDouble(path+".X"), cfg.getDouble(path+".Y"), cfg.getDouble(path+".Z"), (float)cfg.getDouble(path+".Yaw"), (float)cfg.getDouble(path+".Pitch"));
		
	}
}
