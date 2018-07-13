package com.kreezcraft.bedwarsitemgenerator.items;

import com.kreezcraft.bedwarsitemgenerator.BedwarsItemGenerator;
import com.kreezcraft.bedwarsitemgenerator.client.IHasModel;
import com.kreezcraft.bedwarsitemgenerator.init.InitItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	protected String name;

	public ItemBase(String name) {
		this.name = name;
		setUnlocalizedName(BedwarsItemGenerator.MODID + "." + name);
		setRegistryName(name);
		InitItems.ITEMS.add(this);
		setCreativeTab(BedwarsItemGenerator.creativeTab);
		}

	public void registerItemModel() {
		BedwarsItemGenerator.proxy.registerItemRenderer(this, 0, name);
	}

	@Override
	public ItemBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

	@Override
	public void registerModels() {
		BedwarsItemGenerator.proxy.registerItemRenderer(this, 0, "inventory");
	}

}