package com.kreezcraft.bedwarsitemgenerator.blocks;

import com.kreezcraft.bedwarsitemgenerator.BedwarsItemGenerator;
import com.kreezcraft.bedwarsitemgenerator.OurConfig;
import com.kreezcraft.bedwarsitemgenerator.client.IHasModel;
import com.kreezcraft.bedwarsitemgenerator.init.InitBlocks;
import com.kreezcraft.bedwarsitemgenerator.init.InitItems;
import com.kreezcraft.bedwarsitemgenerator.tile_entities.GenTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GenBlock extends Block implements IHasModel, ITileEntityProvider {

	BedwarsItemGenerator.GeneratorType type;
	
	public GenBlock(String name, Material mat, BedwarsItemGenerator.GeneratorType type) {
		super(mat);
		this.type = type;
		setHardness(OurConfig.genClass.hardness);
		setTickRandomly(true);
		if (!OurConfig.genClass.canHarvest) {
			setBlockUnbreakable();
		}
		setUnlocalizedName(BedwarsItemGenerator.MODID + "." + name);
		setCreativeTab(BedwarsItemGenerator.creativeTab);
		setRegistryName(name);
		InitBlocks.BLOCKS.add(this);
		InitItems.ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
	}

	@Override
	public void registerModels() {
		BedwarsItemGenerator.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	@Override
	public GenBlock setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
    
	@Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {

        return new GenTileEntity(type);

    }
}