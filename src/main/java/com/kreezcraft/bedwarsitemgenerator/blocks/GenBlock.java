package com.kreezcraft.bedwarsitemgenerator.blocks;

import java.util.Random;

import com.kreezcraft.bedwarsitemgenerator.BedwarsItemGenerator;
import com.kreezcraft.bedwarsitemgenerator.OurConfig;
import com.kreezcraft.bedwarsitemgenerator.client.IHasModel;
import com.kreezcraft.bedwarsitemgenerator.items.InitItems;

import net.minecraft.block.BlockDispenser;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GenBlock extends BlockDispenser implements IHasModel {

	int timer = OurConfig.genClass.speed;
	int qty = OurConfig.genClass.quantity;
	int counter = 0;
	Item thing = null;
	private String name;

	public GenBlock(String name, Material mat, Item item) {
		super();
		setHardness(OurConfig.genClass.hardness);
		setTickRandomly(true);
		thing = item;
		this.name = name;
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

	
//	public boolean adjacentPower(World worldIn, BlockPos pos) {
//		EnumFacing facing = null;
//		if (worldIn.getRedstonePower(pos, facing.DOWN) > 0)
//			return true;
//		if (worldIn.getRedstonePower(pos, facing.UP) > 0)
//			return true;
//		if (worldIn.getRedstonePower(pos, facing.EAST) > 0)
//			return true;
//		if (worldIn.getRedstonePower(pos, facing.WEST) > 0)
//			return true;
//		if (worldIn.getRedstonePower(pos, facing.NORTH) > 0)
//			return true;
//		if (worldIn.getRedstonePower(pos, facing.SOUTH) > 0)
//			return true;
//		return false;
//	}
//
//	@Override
//	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
//		super.updateTick(worldIn, pos, state, rand);
//		//Do nothing be returning early if redstone power is on adjacently and the redstone config is set to true
//		if(OurConfig.genClass.redstone && adjacentPower(worldIn, pos)) return;
//		
//		counter++;
//		if (counter >= timer) {
//			counter = 0;
//			worldIn.spawnEntity(new ItemStack)
//		}
//	}

}