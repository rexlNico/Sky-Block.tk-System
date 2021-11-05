package de.rexlManu.System.Island;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.rexlManu.System.Region.Region;
import de.rexlManu.System.Region.RegionManager;

public class Island {

	public static RegionManager rm = new RegionManager();
	public static Location currentNewestIslandLocation = new Config().getLastIslandLocation();
	public static int currentIslandCount = new Config().getIslandCount();
	
	public static void createIsland(Player p){
		
		
		Location newIsland = currentNewestIslandLocation;
		newIsland.add(0, 0, 100);
		
		newIsland.getBlock().setType(Material.GRASS);
		currentNewestIslandLocation = newIsland;
		currentIslandCount++;
		
		Location loc1 = new Location(newIsland.getWorld(), newIsland.getX()+50, 0, newIsland.getZ()+50);
		Location loc2 = new Location(newIsland.getWorld(), newIsland.getX()-50, 256, newIsland.getZ()-50);
		
		rm.addRegion(new Region(p.getUniqueId().toString(), loc1, loc2));
		
		p.teleport(new Location(newIsland.getWorld(), newIsland.getX()+0.500, 101, newIsland.getZ()+0.500));
		if(currentIslandCount == 10){
			currentNewestIslandLocation.add(100, 0, -1000);
			currentIslandCount = 0;
		}
		p.sendMessage("§aDeine Island wurde erstellt.");
		
		
	}
	
}
