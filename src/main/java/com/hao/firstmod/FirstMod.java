package com.hao.firstmod;

import com.hao.firstmod.block.ModBlocks;
import com.hao.firstmod.item.ModItemGroups;
import com.hao.firstmod.item.ModItems;
import com.hao.firstmod.mixin.GrassColorsMixin;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstMod implements ModInitializer {
	public static final String MOD_ID = "firstmod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("欢迎来到First Mod！");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerModItemGroups();

        //体验Mixin中Accessor(访问器)的用法
//        int[] colorMap = GrassColorsMixin.getColorMap();
//        LOGGER.info("草颜色映射表长度: {}", colorMap.length);//65536
//
//        int[] newColorMap = new int[128];
//        GrassColorsMixin.setColorMap(newColorMap);
//        LOGGER.info("草颜色映射表长度: {}", GrassColorsMixin.getColorMap().length);//128
        //Mixin中Accessor的用法结束



        LOGGER.info("加载完成！");
	}
}