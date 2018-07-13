package com.kreezcraft.bedwarsitemgenerator;

import com.kreezcraft.bedwarsitemgenerator.init.InitBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {

	public CreativeTab(String label) {
		super(BedwarsItemGenerator.MODID);
//		setBackgroundImageName("item_search.png");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(InitBlocks.IRON_GEN);
	}
	
//	@Override
//	public boolean hasSearchBar() {
//		return true;
//	}

	
}