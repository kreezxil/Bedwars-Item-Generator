package com.kreezcraft.bedwarsitemgenerator;

import org.apache.logging.log4j.Logger;

import com.kreezcraft.bedwarsitemgenerator.proxy.CommonProxy;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = BedwarsItemGenerator.MODID, name = BedwarsItemGenerator.NAME, version = BedwarsItemGenerator.VERSION)
public class BedwarsItemGenerator {
	public static final String MODID = "bedwarsitemgenerator";
	public static final String NAME = "Bedwars Item Generator";
	public static final String VERSION = "@VERSION@";

	public static Logger logger;

	public static final CreativeTab creativeTab = new CreativeTab("Bedwars Item Generator");

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
	}

	@SidedProxy(serverSide = "com.kreezcraft.bedwarsitemgenerator.proxy.CommonProxy", clientSide = "com.kreezcraft.bedwarsitemgenerator.proxy.ClientProxy")
	public static CommonProxy proxy;
	
	public enum GeneratorType {
		IRON, GOLD, DIAMOND, CUSTOM, OBSIDIAN
	}
	public static Item[] defaultItems = {Items.IRON_INGOT, Items.GOLD_INGOT, Items.DIAMOND, Items.APPLE};
}
