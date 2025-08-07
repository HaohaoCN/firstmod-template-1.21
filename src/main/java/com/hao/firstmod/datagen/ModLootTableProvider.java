package com.hao.firstmod.datagen;

import com.hao.firstmod.block.ModBlocks;
import com.hao.firstmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        //LootTable = block：掉落物，其余也许为“战利品表”

        //以下为掉落方块本身。
        addDrop(ModBlocks.FIRST_BLOCK);
        addDrop(ModBlocks.SECOND_BLOCK);
        addDrop(ModBlocks.BLUE_BLOCK);
        //以下为矿石类型掉落物（吃精准采集，时运）。
        //addDrop(ModBlocks.BLUE_ORE, oreDrops(ModBlocks.BLUE_ORE, ModItems.RAW_BLUE_ITEM));这样写默认值掉落一个矿
        addDrop(ModBlocks.BLUE_ORE, copperOreLikeDrops(ModBlocks.BLUE_BLOCK, ModItems.RAW_BLUE_ITEM));

    }
    //可改的矿石类型掉落物方法
    public LootTable.Builder copperOreLikeDrops(Block drop, Item dropItem) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(dropItem)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 5.0F)))
                                //2.0F：最小掉落数，5.0F：最大掉落数
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
