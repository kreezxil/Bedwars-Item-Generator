package com.kreezcraft.bedwarsitemgenerator;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import com.kreezcraft.bedwarsitemgenerator.proxy.CommonProxy;
import com.kreezcraft.bedwarsitemgenerator.recipes.ModRecipes;

@Mod(modid = BedwarsItemGenerator.MODID, name = BedwarsItemGenerator.NAME, version = BedwarsItemGenerator.VERSION)
public class BedwarsItemGenerator {
	public static final String MODID = "bedwarsitemgenerator";
	public static final String NAME = "Bedwars Item Generator";
	public static final String VERSION = "@VERSION@";

	private static Logger logger;

	@Mod.Instance(MODID)
	public static BedwarsItemGenerator instance;

	public static final CreativeTab creativeTab = new CreativeTab("Bedwars Item Generator");

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		// logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

		ModRecipes.init();
	}

	@SidedProxy(serverSide = "com.kreezcraft.bedwarsitemgenerator.proxy.CommonProxy", clientSide = "com.kreezcraft.bedwarsitemgenerator.proxy.ClientProxy")
	public static CommonProxy proxy;
}
