package com.github.channelingmc.quicksand.common.init;

import com.github.channelingmc.quicksand.api.QuicksandAPI;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = QuicksandAPI.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class QuicksandSoundEvents {
    
    @SubscribeEvent
    public static void register(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().registerAll(
            new SoundEvent(QuicksandAPI.ZOMBIE_CONVERTS_TO_HUSK.getId())
                .setRegistryName(QuicksandAPI.ZOMBIE_CONVERTS_TO_HUSK.getId()),
            new SoundEvent(QuicksandAPI.DROWNED_CONVERTS_TO_ZOMBIE.getId())
                .setRegistryName(QuicksandAPI.DROWNED_CONVERTS_TO_ZOMBIE.getId())
        );
    }
    
}
