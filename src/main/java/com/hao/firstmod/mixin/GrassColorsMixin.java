package com.hao.firstmod.mixin;

import net.minecraft.world.biome.GrassColors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

//在实际游戏中该Mixin并不会起作用
@Mixin(GrassColors.class)
public interface GrassColorsMixin {
    @Accessor("colorMap")
    static int[] getColorMap() {
        throw new AssertionError();
    }

    @Accessor("colorMap")
    static void setColorMap(int[] colorMap) {
        throw new AssertionError();
    }
}
