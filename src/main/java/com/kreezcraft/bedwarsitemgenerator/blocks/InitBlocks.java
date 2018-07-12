package com.kreezcraft.bedwarsitemgenerator.blocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class InitBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();

//	public static final Block DIAMOND_GLASS = new GlassBlock("diamond_glass"); // cyan
public static final Block IRON_GEN = new GenBlock("iron_gen", null, null);
}