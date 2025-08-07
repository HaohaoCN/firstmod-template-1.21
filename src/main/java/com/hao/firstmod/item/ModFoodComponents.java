package com.hao.firstmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

//写完食物要到ModItems里去注册
public class ModFoodComponents {
    public static final FoodComponent CHEESE =
            new FoodComponent.Builder()
                    .nutrition(8)//恢复的饥饿值
                    .saturationModifier(0.8f)//饱食度乘数，最终的[饱食度] = [.nutrition] * [.saturationModifier] * [2.0]
                    .build();
    public static final FoodComponent STRAWBERRY =
            new FoodComponent.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .statusEffect(
                            new StatusEffectInstance(//食用后的效果，持续时间ticks，触发概率
                                    StatusEffects.FIRE_RESISTANCE,
                                    600),
                            0.5f)
                    .build();
}
