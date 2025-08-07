package com.hao.firstmod.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
//mixin，顾名思义，就是将自己写的代码混入到Minecraft源代码中。
//第一行必须写@Mixin，括号内是目标类。
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "loadWorld")
    //inject 注入；method 注入的方法名；at 注入的位置。
	private void init(CallbackInfo info) {
		// This code is injected into the start of MinecraftServer.loadWorld()V
        //init()可以随意命名。
//        System.out.println("Hello Minecraft!");
        //打印Hello Minecraft!
        //在进入世界，生成世界时会输出[Server thread/INFO] (Minecraft) [STDOUT]: Hello Minecraft!

	}
}