package de.rexlManu.System.Region;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

public class RegionManager {

	private static File file = new File("System/regions.yml");
	private static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public void addRegion(Region r){
		String loc1 = LocationUtils.getString(r.getLoc1());
		String loc2 = LocationUtils.getString(r.getLoc2());
		
		cfg.set(r.getName() + ".1", loc1);
		cfg.set(r.getName() + ".2", loc2);
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<Region> getCurrentRegion (Location loc){
		List<Region> currentRegions = new ArrayList<>();
		for(String key:cfg.getKeys(false)){
			Region r= new Region(key, LocationUtils.getLocation(cfg.getString(key+".1")), LocationUtils.getLocation(cfg.getString(key+".2")));
			if(r.inRegion(loc)){
				currentRegions.add(r);
			}
		}
		if(currentRegions.size() > 0){
			return currentRegions;
		}else{
			return null;
		}
	}
	
	public boolean removeRegion(String name){
		if(cfg.contains(name)){
			
			cfg.set(name, null);
			return true;
		}else{
			return false;
		}
	}
}
