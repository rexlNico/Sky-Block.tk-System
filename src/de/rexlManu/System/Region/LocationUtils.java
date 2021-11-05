package de.rexlManu.System.Region;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class LocationUtils {

	
	public static String getString(Location loc){
		String worldName = loc.getWorld().getName();
		int x = (int) loc.getX();
		int y = (int) loc.getY();
		int z = (int) loc.getZ();
		
		return worldName + ","+ x +","+y+","+z;
	}
	public static Location getLocation(String data){
		String[] dataArray = data.split(",");
		String worldName = dataArray[0];
		double x = Integer.parseInt(dataArray[1]);
		double y = Integer.parseInt(dataArray[2]);
		double z = Integer.parseInt(dataArray[3]);
		
		return new Location(Bukkit.getWorld(worldName), x, y, z);
	}
}
