package mrthomas20121.nature_horizons.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class NatureHorizonsFood {

    public static FoodProperties WALNUT = new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).build();
    public static FoodProperties ROASTED_WALNUT = new FoodProperties.Builder().nutrition(4).saturationMod(0.8F).build();
    public static FoodProperties GOLDEN_WALNUT = new FoodProperties.Builder().nutrition(4).saturationMod(1.3F).effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F).effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F).alwaysEat().build();

    public static FoodProperties FRUIT_SALAD = new FoodProperties.Builder().nutrition(8).saturationMod(1.3F).build();

    public static FoodProperties JUNIPER_BERRY = new FoodProperties.Builder().nutrition(4).saturationMod(0.4F).build();
    public static FoodProperties GRILLED_JUNIPER_BERRY = new FoodProperties.Builder().nutrition(6).saturationMod(0.5F).build();
    public static FoodProperties GOLDEN_JUNIPER_BERRY = new FoodProperties.Builder().nutrition(4).saturationMod(1.3F).effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F).effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F).alwaysEat().build();

}
