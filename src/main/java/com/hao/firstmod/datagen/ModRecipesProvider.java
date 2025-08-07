package com.hao.firstmod.datagen;

import com.hao.firstmod.FirstMod;
import com.hao.firstmod.block.ModBlocks;
import com.hao.firstmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> BLUE = List.of(ModItems.RAW_BLUE_ITEM, ModBlocks.BLUE_ORE);
    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override

    public void generate(RecipeExporter exporter) {
        //手动recipe 1,2
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.MISC, ModItems.BLUE_ITEM,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_BLOCK);
        // 适用于那些合成表可逆的配方（只能是1个分解成9个，以及9个合成为1个，比如锭<->块）
        // 在这里，BBlock合成BItem属于RC.MISC（杂项），反过来则属于RC.BB（建筑方块）

        //手动recipe 3,4
        //blasting 使用高炉
        offerBlasting(exporter,
                BLUE,//输入必须是列表
                RecipeCategory.MISC,//所属的类别，下面几行分别是输出，经验，时间，所属的组
                ModItems.BLUE_ITEM,
                0.7f,
                200,
                "blue");

        //手动recipe 5,6
        //smelting 使用熔炉
        offerSmelting(exporter,
                BLUE,//输入必须是列表
                RecipeCategory.MISC,//所属的类别，下面几行分别是输出，经验，时间，所属的组
                ModItems.BLUE_ITEM,
                0.7f,
                100,
                "blue");

        //非手动recipe
        //foodcooking 食物烧制
        //campfire 营火
        offerFoodCookingRecipe(exporter,
                "campfire_cooking",
                RecipeSerializer.CAMPFIRE_COOKING,
                CampfireCookingRecipe::new,
                600,
                ModBlocks.FIRST_BLOCK,
                ModBlocks.SECOND_BLOCK,
                0.35f);
                //从cooker行开始，依次为：厨具，搭配厨具的RS.CC，搭配厨具的CCR::new，烧制时间（时间单位若无特殊说明均为tick），输入，输出，经验

        //手动recipe 8
        //有序合成，要把生成物及其数量写第一行：组别（杂项） + 生成物 + 数量
        //注意.input里的第一个参数要用单引号括起来而不是双引号。
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,Items.LEATHER, 2)
                .pattern("##")
                .pattern("##")
                .input('#', Ingredient.ofItems(Items.ROTTEN_FLESH))
                .criterion("has_item", RecipeProvider.conditionsFromItem(Items.ROTTEN_FLESH))
                .offerTo(exporter, Identifier.of(FirstMod.MOD_ID, "rotten_flesh_to_leather"));

        //手动recipe 7
        //无序合成
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_ORE, 1)
                .input(ModItems.RAW_BLUE_ITEM)
                .input(ModItems.RAW_BLUE_ITEM)
                .input(ModItems.RAW_BLUE_ITEM)
                .input(ModItems.RAW_BLUE_ITEM)
                .input(ModItems.RAW_BLUE_ITEM)
                .input(ModItems.RAW_BLUE_ITEM)
                .input(ModItems.RAW_BLUE_ITEM)
                .input(ModItems.RAW_BLUE_ITEM)
                .input(Blocks.COBBLESTONE)
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.RAW_BLUE_ITEM))
                .criterion("has_item", RecipeProvider.conditionsFromItem(Blocks.COBBLESTONE))//两者获得任意一个都可以解锁配方
                .offerTo(exporter, Identifier.of(FirstMod.MOD_ID, "blue_ore"));

    }
}
