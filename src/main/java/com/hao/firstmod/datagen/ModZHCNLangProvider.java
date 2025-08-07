package com.hao.firstmod.datagen;

import com.hao.firstmod.block.ModBlocks;
import com.hao.firstmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModZHCNLangProvider extends FabricLanguageProvider {
    public ModZHCNLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput,"zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.FIRST_ITEM,"第一个物品");
        translationBuilder.add(ModItems.BLUE_ITEM,"蓝色物品");
        translationBuilder.add(ModItems.RAW_BLUE_ITEM,"粗蓝色物品");

        translationBuilder.add(ModBlocks.FIRST_BLOCK,"第一个方块");
        translationBuilder.add(ModBlocks.SECOND_BLOCK,"第二个方块");
        translationBuilder.add(ModBlocks.BLUE_BLOCK,"蓝色方块");
        translationBuilder.add(ModBlocks.BLUE_ORE,"蓝色矿");

        translationBuilder.add("itemGroup.first_group","第一个物品组");
    }
}
