package de.rexlManu.System.VoidWorld;

import org.bukkit.generator.ChunkGenerator;

public class Generator {

	
	  public ChunkGenerator getDefaultWorldGenerator(String worldName, String id)
	  {
	    return new VoidGenerator();
	  }
	
}
