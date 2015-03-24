package shift.sextiarysector.player;

import net.minecraft.entity.player.EntityPlayer;

public class EntityPlayerManager {
	  public static CustomPlayerData getCustomPlayerData(EntityPlayer entityPlayer)
	  {
	    return (CustomPlayerData)entityPlayer.getExtendedProperties("sextiarysector");
	  }
}
