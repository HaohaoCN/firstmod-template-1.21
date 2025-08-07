package com.hao.firstmod.datagen;

import com.hao.firstmod.block.ModBlocks;
import com.hao.firstmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModENUSLangProvider extends FabricLanguageProvider {
    public ModENUSLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput,"en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.FIRST_ITEM,"First Item");
        translationBuilder.add(ModItems.BLUE_ITEM,"Blue Item");
        translationBuilder.add(ModItems.RAW_BLUE_ITEM,"Raw Blue Item");
        translationBuilder.add(ModItems.CHEESE, "Cheese");
        translationBuilder.add(ModItems.STRAWBERRY, "Strawberry");

        translationBuilder.add(ModBlocks.FIRST_BLOCK,"First Block");
        translationBuilder.add(ModBlocks.SECOND_BLOCK,"Second Block");
        translationBuilder.add(ModBlocks.BLUE_BLOCK,"Blue Block");
        translationBuilder.add(ModBlocks.BLUE_ORE,"Blue Ore");

        translationBuilder.add("itemGroup.first_group","First Group");
    }
}
