package dqmIIIaddons.addSS2;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import dqmIIIaddons.addSS2.handler.DqmEventHandler;

@Mod(modid = "DQMIIINextSS2addon", name = "DQMIIINextSS2addon", version = "1.5.0",  useMetadata = true, dependencies = "after:DQMIIINext;after:SextiarySector")

public class DqmSS2addon {

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new DqmEventHandler());
	}

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
