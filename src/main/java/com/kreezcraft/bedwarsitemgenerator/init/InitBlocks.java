package com.kreezcraft.bedwarsitemgenerator.init;

import java.util.ArrayList;
import java.util.List;

import com.kreezcraft.bedwarsitemgenerator.BedwarsItemGenerator;
import com.kreezcraft.bedwarsitemgenerator.blocks.GenBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class InitBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();

//	public static final Block DIAMOND_GLASS = new GlassBlock("diamond_glass"); // cyan
	public static final Block IRON_GEN = new GenBlock("iron_gen", Material.IRON, BedwarsItemGenerator.GeneratorType.IRON);
	public static final Block GOLD_GEN = new GenBlock("gold_gen", Material.IRON, BedwarsItemGenerator.GeneratorType.GOLD);
	public static final Block DIAMOND_GEN = new GenBlock("diamond_gen", Material.IRON, BedwarsItemGenerator.GeneratorType.DIAMOND);
	public static final Block OBSIDIAN_GEN = new GenBlock("obsidian_gen", Material.IRON, BedwarsItemGenerator.GeneratorType.OBSIDIAN);
	public static final Block CUSTOM_GEN = new GenBlock("custom_gen", Material.IRON, BedwarsItemGenerator.GeneratorType.CUSTOM);

}