package com.kreezcraft.bedwarsitemgenerator.init;

import com.kreezcraft.bedwarsitemgenerator.tile_entities.ticktock;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {

	public static void init() {
		GameRegistry.registerTileEntity(ticktock.class, "bedwarsitemgenerator:iron_gen");
		GameRegistry.registerTileEntity(ticktock.class, "bedwarsitemgenerator:gold_gen");
		GameRegistry.registerTileEntity(ticktock.class, "bedwarsitemgenerator:diamond_gen");
		GameRegistry.registerTileEntity(ticktock.class, "bedwarsitemgenerator:obsidian_gen");

	}
}
