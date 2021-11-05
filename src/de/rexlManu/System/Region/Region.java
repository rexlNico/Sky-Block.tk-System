package de.rexlManu.System.Region;

import org.bukkit.Location;

public class Region {

	private String name;
	private Location loc1;
	private Location loc2;
	
	public Region(String name,Location loc1,Location loc2){
		this.name = name;
		this.loc1 = loc1;
		this.loc2 = loc2;
	}
	public boolean inRegion(Location loc){
		
		if(loc.getWorld() != loc1.getWorld()){
			return false;
		}
		
		double minX = Math.min(this.loc1.getX(), this.loc2.getX());
		double minY = Math.min(this.loc1.getY(), this.loc2.getY());
		double minZ = Math.min(this.loc1.getZ(), this.loc2.getZ());
		
		double maxX = Math.max(this.loc1.getX(), this.loc2.getX());
		double maxY = Math.max(this.loc1.getY(), this.loc2.getY());
		double maxZ = Math.max(this.loc1.getZ(), this.loc2.getZ());
		
		if(loc.getX() >= minX && loc.getX() <= maxX
			&& loc.getY() >= minY && loc.getY() <= maxY
			&& loc.getZ() >= minZ && loc.getZ() <= maxZ){
			return true;
		}
		return false;
	}
	
	public String getName() {
		return name;
	}
	public Location getLoc1() {
		return loc1;
	}
	public Location getLoc2() {
		return loc2;
	}
	
}
