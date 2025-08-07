package com.hao.firstmod.item;

import com.hao.firstmod.FirstMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
//import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FIRST_ITEM = registerItems("first_item", new Item(new Item.Settings()));
    public static final Item BLUE_ITEM = registerItems("blue_item", new Item(new Item.Settings()));
    public static final Item RAW_BLUE_ITEM = registerItems("raw_blue_item", new Item(new Item.Settings()));

    public static final Item CHEESE = registerItems("cheese", new Item(new Item.Settings().food(ModFoodComponents.CHEESE)));
    public static final Item STRAWBERRY = registerItems("strawberry", new Item(new Item.Settings().food(ModFoodComponents.STRAWBERRY)));

    private static Item registerItems(String id, Item item){

        //return Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(FirstMod.MOD_ID, id)), item);
        return Registry.register(Registries.ITEM, Identifier.of(FirstMod.MOD_ID, id), item);
    }

    private static void addItemToIG(FabricItemGroupEntries fabricItemGroupEntries){
        //addItemToItemGroup(IG)
        //使物品添加至物品栏。
        fabricItemGroupEntries.add(FIRST_ITEM);
        fabricItemGroupEntries.add(BLUE_ITEM);
        //……
        //以后不再添加，若要添加再补充。
    }

    public static void registerModItems(){
        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIG);
        //将item添加进原版的那几个物品组其中之一里，若不想添加则将上一行注释掉。
        FirstMod.LOGGER.info("正在注册物品……");
    }
}
