package com.shnupbups.quicksand.registry;

import com.shnupbups.quicksand.Quicksand;
import com.shnupbups.quicksand.block.QuicksandBlock;
import com.shnupbups.quicksand.block.QuicksandCauldronBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PowderSnowBucketItem;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.registry.Registry;

public class ModBlocksAndItems {
	public static final Block QUICKSAND = new QuicksandBlock(FabricBlockSettings.copyOf(Blocks.SAND));
	public static final BlockItem QUICKSAND_BUCKET = new PowderSnowBucketItem(QUICKSAND, SoundEvents.BLOCK_SAND_PLACE, new FabricItemSettings().maxCount(1).group(ItemGroup.MISC));
	public static final Block QUICKSAND_CAULDRON = new QuicksandCauldronBlock(FabricBlockSettings.copyOf(Blocks.CAULDRON));

	public static void init() {
		Registry.register(Registry.BLOCK, Quicksand.id("quicksand"), QUICKSAND);
		Registry.register(Registry.ITEM, Quicksand.id("quicksand_bucket"), QUICKSAND_BUCKET);
		QUICKSAND_BUCKET.appendBlocks(Item.BLOCK_ITEMS, QUICKSAND_BUCKET);
		Registry.register(Registry.BLOCK, Quicksand.id("quicksand_cauldron"), QUICKSAND_CAULDRON);
	}
}