package com.kreezcraft.bedwarsitemgenerator.init;

import java.util.ArrayList;
import java.util.List;

import com.kreezcraft.bedwarsitemgenerator.blocks.GenBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class InitBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();

//	public static final Block DIAMOND_GLASS = new GlassBlock("diamond_glass"); // cyan
public static final Block IRON_GEN = new GenBlock("iron_gen", Material.IRON, Items.IRON_INGOT);
public static final Block GOLD_GEN = new GenBlock("gold_gen", Material.IRON, Items.GOLD_INGOT);
public static final Block DIAMOND_GEN = new GenBlock("diamond_gen", Material.IRON, Items.DIAMOND);
public static final Block OBSIDIAN_GEN = new GenBlock("obsidian_gen", Material.IRON, null);

}