package fr.weefle.revolution.npc;

import org.bukkit.entity.Player;
import de.alphahelix.alphalibary.fakeapi.FakeMobType;
import de.alphahelix.alphalibary.fakeapi.utils.MobFakeUtil;

public class NpcSpawn {
	
	//private EntityPlayer npc;
	
	public static void spawnNPC(Player p, NpcType np) {
		String npp = np.toString();
		MobFakeUtil.spawnMob(p, p.getLocation(), npp, FakeMobType.VILLAGER, false);
		
		/*MinecraftServer serv = ((CraftServer)Bukkit.getServer()).getServer();
		WorldServer wserv = ((CraftWorld)Bukkit.getServer().getWorlds().get(0)).getHandle();
		String npp = np.toString();
		npc = new EntityPlayer(serv, wserv, new GameProfile(UUID.randomUUID(), npp), new PlayerInteractManager(wserv));
		PlayerConnection pc = ((CraftPlayer)p).getHandle().playerConnection;
		pc.sendPacket(new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.ADD_PLAYER, npc));
		pc.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));*/
		
	}

}
