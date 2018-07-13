package com.kreezcraft.bedwarsitemgenerator.tile_entities;

import java.util.Random;

import com.kreezcraft.bedwarsitemgenerator.OurConfig;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ticktock extends TileEntity implements ITickable {
	
	private Item thing;
	private World world;
	private Block itsWhoIam;
	private BlockPos pos;
	
	public ticktock(World worldIn, Item whatThing, Block me, BlockPos position) {
		world=worldIn;
		thing=whatThing;
		itsWhoIam=me;
		pos=position;
	}

	@Override
	public void update() {

		if (OurConfig.genClass.redstone && world.isBlockIndirectlyGettingPowered(pos)>0) {
			return;
		}

		Item theThing = this.thing;

		if (this.thing == null) {
			Random r = new Random();
			int s = r.nextInt(3);
			if (s <= 1)
				theThing = Items.IRON_INGOT;
			else if (s == 2)
				theThing = Items.GOLD_INGOT;
			else
				theThing = Items.DIAMOND;
		}

		EntityItem entityItem = new EntityItem(world, (double) pos.getX(), (double) pos.up().getY(),
				(double) pos.getZ(), new ItemStack(theThing));
		world.spawnEntity(entityItem);

	}

}