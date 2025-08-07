package com.hao.firstmod.datagen;

import com.hao.firstmod.block.ModBlocks;
import com.hao.firstmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }
    //手动写法：
    //物品：models/item
    //方块:blockstates（方块状态）+models/block+models/item
    //                                   \-cubeall 表示六个面都一样的贴图。
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FIRST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SECOND_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.FIRST_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BLUE_ITEM, Models.GENERATED);
    }
}
