package com.kreezcraft.bedwarsitemgenerator.tile_entities;

import java.util.Random;

import com.kreezcraft.bedwarsitemgenerator.BedwarsItemGenerator;
import com.kreezcraft.bedwarsitemgenerator.OurConfig;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class GenTileEntity extends TileEntity implements ITickable {
	
	private int counter;
	BedwarsItemGenerator.GeneratorType type;
	Random rand;

	public GenTileEntity(BedwarsItemGenerator.GeneratorType type) {
		this.type = type;
		rand = new Random();
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void update() {
		
		if(world.isRemote) return;
		
		if (OurConfig.genClass.redstone && world.isBlockIndirectlyGettingPowered(pos)>0) {
			return;
		}
		if(counter == OurConfig.genClass.speed) {
			counter = 0;
			switch(type) {
			case IRON:
				generateItem(OurConfig.items.ironItem);
				break;
			case GOLD:
				generateItem(OurConfig.items.goldItem);
				break;
			case DIAMOND:
				generateItem(OurConfig.items.diamondItem);
				break;
			case OBSIDIAN:
				switch(rand.nextInt(3)) {
				case 0:
					generateItem(OurConfig.items.ironItem);
					break;
				case 1:
					generateItem(OurConfig.items.goldItem);
					break;
				case 2:
					generateItem(OurConfig.items.diamondItem);
					break;
				}
				break;
			case CUSTOM:
				generateItem(OurConfig.items.customItem);
				break;
				
			}
		} else {
			counter++;
		}
	}

	private void generateItem(String itemIn) {
		Item item = Item.getByNameOrId(itemIn);
		
		if(item == null) {
			BedwarsItemGenerator.logger.error("Invalid config item. Using default item for " + type.name() + " Generator.");
			if(type == BedwarsItemGenerator.GeneratorType.OBSIDIAN) {
				item = BedwarsItemGenerator.defaultItems[rand.nextInt(3)];
			} else {
				item = BedwarsItemGenerator.defaultItems[type.ordinal()];
			}
		}
		
		EntityItem entity = new EntityItem(world);
		entity.setItem(new ItemStack(item));
		entity.setPosition(pos.getX() + .5, pos.getY()+1, pos.getZ() + .5);
		world.spawnEntity(entity);
	}

}