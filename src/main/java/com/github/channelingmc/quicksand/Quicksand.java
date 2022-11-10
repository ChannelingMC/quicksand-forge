package com.github.channelingmc.quicksand;

import com.github.channelingmc.quicksand.api.QuicksandAPI;
import com.github.channelingmc.quicksand.common.QuicksandConfigs;
import com.github.channelingmc.quicksand.common.init.QuicksandFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(QuicksandAPI.ID)
public class Quicksand {
	
	public Quicksand() {
		ModLoadingContext context = ModLoadingContext.get();
		context.registerConfig(ModConfig.Type.CLIENT, QuicksandConfigs.CLIENT_SPEC);
		context.registerConfig(ModConfig.Type.COMMON, QuicksandConfigs.COMMON_SPEC);
		context.registerConfig(ModConfig.Type.SERVER, QuicksandConfigs.SERVER_SPEC);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onBiomeLoad(BiomeLoadingEvent event) {
		BiomeGenerationSettingsBuilder builder = event.getGeneration();
		Biome.BiomeCategory category = event.getCategory();
		if (category.equals(Biome.BiomeCategory.DESERT)) {
			builder.addFeature(GenerationStep.Decoration.LAKES, QuicksandAPI.QUICKSAND_LAKE_PF);
		} else if (category.equals(Biome.BiomeCategory.MESA)) {
			builder.addFeature(GenerationStep.Decoration.LAKES, QuicksandAPI.RED_QUICKSAND_LAKE_PF);
		}
	}
	
}
