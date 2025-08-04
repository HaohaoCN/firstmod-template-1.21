package com.hao.firstmod.item;

import com.hao.firstmod.FirstMod;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
//import net.minecraft.registry.RegistryKey;
//import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
//    public static final RegistryKey<ItemGroup> FIRST_GROUP = register("first_group");
//    private static RegistryKey<ItemGroup> register(String id) {
//        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(FirstMod.MOD_ID, id));
//    }
//    public static void registerModItemGroups(){
//        Registry.register(
//                Registries.ITEM_GROUP,
//                FIRST_GROUP,
//                ItemGroup.create(ItemGroup.Row.TOP,7)
//                        .displayName(Text.translatable("itemGroup.first_group"))
//                        .icon(() -> new ItemStack(ModItems.FIRST_ITEM))
//                        .entries((displayContext, entries) -> {
//                            entries.add(ModItems.FIRST_ITEM);
//                        })
//                        .build()
//        );
//        FirstMod.LOGGER.info("正在注册物品组，使物品进入物品栏……");
//    }
    public static final ItemGroup FIRST_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(FirstMod.MOD_ID, "first_group"),
            ItemGroup.create(null,-1)
                    .displayName(Text.translatable("itemGroup.first_group"))
                    .icon(() -> new ItemStack(ModItems.BLUE_ITEM))
                    .entries((displayContext, entries) -> {
                            entries.add(ModItems.FIRST_ITEM);
                            entries.add(ModItems.BLUE_ITEM);
                            //entries.add(Blocks.BRICKS);
                            //entries.add(Items.DIAMOND);

                        })
                        .build()
        );
    public static void registerModItemGroups(){
        FirstMod.LOGGER.info("正在注册物品组，使物品进入物品栏……");
    }
}
