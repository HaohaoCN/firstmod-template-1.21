package com.hao.firstmod.item;

import com.hao.firstmod.FirstMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
//import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FIRST_ITEM = registerItems("first_item", new Item(new Item.Settings()));
    private static Item registerItems(String id, Item item){

        //return Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(FirstMod.MOD_ID, id)), item);
        return Registry.register(Registries.ITEM, Identifier.of(FirstMod.MOD_ID, id), item);
    }
    public static void registerModItems(){
        FirstMod.LOGGER.info("正在注册物品……");
    }
}
