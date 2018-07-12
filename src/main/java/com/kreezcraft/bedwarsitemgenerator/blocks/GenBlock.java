package com.kreezcraft.bedwarsitemgenerator.blocks;

import java.util.Random;

import com.kreezcraft.bedwarsitemgenerator.BedwarsItemGenerator;
import com.kreezcraft.bedwarsitemgenerator.OurConfig;
import com.kreezcraft.bedwarsitemgenerator.client.IHasModel;
import com.kreezcraft.bedwarsitemgenerator.items.InitItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockSourceImpl;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GenBlock extends Block implements IHasModel {

	//int qty = OurConfig.genClass.quantity;
	Item thing = null;
	private String name;

	public GenBlock(String name, Material mat, Item item) {
		super(mat);
		setHardness(OurConfig.genClass.hardness);
		setTickRandomly(true);
		if (!OurConfig.genClass.canHarvest) {
			setBlockUnbreakable();
		}
		this.thing = item;
		this.name = name;
		setUnlocalizedName(BedwarsItemGenerator.MODID + "." + name);
		setCreativeTab(BedwarsItemGenerator.creativeTab);
		setRegistryName(name);
		InitBlocks.BLOCKS.add(this);
		InitItems.ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
	}

	@Override
	public boolean getTickRandomly() {
		return true;
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

	/**
	 * How many world ticks before ticking
	 */
	public int tickRate(World worldIn) {
		return 20 * OurConfig.genClass.speed;
	}

	public boolean adjacentPower(World worldIn, BlockPos pos) {
		EnumFacing facing = null;
		if (worldIn.getRedstonePower(pos, facing.DOWN) > 0)
			return true;
		if (worldIn.getRedstonePower(pos, facing.UP) > 0)
			return true;
		if (worldIn.getRedstonePower(pos, facing.EAST) > 0)
			return true;
		if (worldIn.getRedstonePower(pos, facing.WEST) > 0)
			return true;
		if (worldIn.getRedstonePower(pos, facing.NORTH) > 0)
			return true;
		if (worldIn.getRedstonePower(pos, facing.SOUTH) > 0)
			return true;
		return false;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);
		// Do nothing be returning early if redstone power is on adjacently and the
		// redstone config is set to true
		if (OurConfig.genClass.redstone && adjacentPower(worldIn, pos)) {
			System.out.println("redstone check succeeded, exiting");
			return;
		}

		Item theThing = this.thing;

		if (this.thing == null) {
			System.out.println("thing is null, going to pick a random one");
			Random r = new Random();
			int s = r.nextInt(3);
			if (s <= 1)
				theThing = Items.IRON_INGOT;
			else if (s == 2)
				theThing = Items.GOLD_INGOT;
			else
				theThing = Items.DIAMOND;
		}

		System.out.print(theThing.getUnlocalizedName() + " selected for spawning");
		EntityItem entityItem = new EntityItem(worldIn, (double) pos.getX(), (double) pos.up().getY(),
				(double) pos.getZ(), new ItemStack(theThing));
		worldIn.spawnEntity(entityItem);
	}

}