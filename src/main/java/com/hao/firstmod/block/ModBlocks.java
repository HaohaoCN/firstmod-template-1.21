package com.hao.firstmod.block;

import com.hao.firstmod.FirstMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

//用手挖掘不用写.requiresTool(),写了就需要写tags。tags/block下，只添加进mineable里面，表示最低用木质工具。也可以添加进needs_xxx_tool里面表示最低用xxx工具。
    public static final Block FIRST_BLOCK = register("first_block", new Block(AbstractBlock.Settings.create().requiresTool().strength(3.0f,3.0f)));
    public static final Block SECOND_BLOCK = register("second_block", new Block(AbstractBlock.Settings.create().requiresTool().strength(3.0f,3.0f)));
    public static final Block BLUE_BLOCK = register("blue_block", new Block(AbstractBlock.Settings.create().requiresTool().strength(4.5f,6.0f)));
    public static void registerBlockItems(String id, Block block) {

        Item item = Registry.register(Registries.ITEM, Identifier.of(FirstMod.MOD_ID, id), new BlockItem(block, new Item.Settings()));
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }


    public static Block register(String id, Block block) {
        registerBlockItems(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FirstMod.MOD_ID, id), block);
    }
    public static void registerModBlocks() {
        FirstMod.LOGGER.info("正在注册方块以及它所对应的物品...");
    }

}
