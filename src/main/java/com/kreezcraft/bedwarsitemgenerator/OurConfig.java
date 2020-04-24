package com.kreezcraft.bedwarsitemgenerator;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
@Config(modid = BedwarsItemGenerator.MODID, category = "")
public class OurConfig {

	@Config.Comment({"Generator Settings"})
	@Config.Name("Generator")
	public static GenClass genClass = new GenClass();
	
	@Config.Comment({"Item Settings"})
	@Config.Name("Items")
	public static Items items = new Items();
	
	public static class GenClass {
		@Config.Comment({"Speed at which blocks generate items in ticks",
			"There are 20 ticks per second.",
			"A value below 20 can cause immense lag if too many blocks are in the world."})
		@Config.Name("Gen Speed")
		public int speed = 20;
		
//		@Config.Comment({"Quantity of items that are generated"})
//		@Config.Name("Gen Quantity")
//		public int quantity = 1;
//		
		@Config.Comment({"Can redstone disable it?"})
		@Config.Name("Redstone reactive")
		public boolean redstone = true;
		
		@Config.Comment({"How hard should the block be?"})
		@Config.Name("Block Hardness")
		public float hardness = 25f;
		
		@Config.Comment({"Can it be harvested?"})
		@Config.Name("Harvestable?")
		public boolean canHarvest = true;
	}
	
	public static class Items {
		@Config.Comment("Item for iron generator to make")
		@Config.Name("IronItem")
		public String ironItem = "minecraft:iron_ingot";
		
		@Config.Comment("Item for gold generator to make")
		@Config.Name("GoldItem")
		public String goldItem = "minecraft:gold_ingot";
		
		@Config.Comment("Item for diamond generator to make")
		@Config.Name("DiamondItem")
		public String diamondItem = "minecraft:diamond";
		
		@Config.Comment("Item for custom generator to make")
		@Config.Name("CustomItem")
		public String customItem = "minecraft:apple";
	}

	@SubscribeEvent
	public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(BedwarsItemGenerator.MODID)) {
			ConfigManager.sync(BedwarsItemGenerator.MODID, Config.Type.INSTANCE);
		}
	}

}
