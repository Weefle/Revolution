package fr.weefle.revolution.npc;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import de.alphahelix.alphalibary.core.utilites.entity.EntityBuilder;

public class NpcSpawn {
	
	//private EntityPlayer npc;
	
	public static void spawnNPC(Player p, NpcType np) {
		String npp = np.toString();
		EntityBuilder eb = new EntityBuilder(EntityType.VILLAGER);
		eb.setName(npp);
		eb.setGlowing(true);
		eb.spawn(p.getLocation());
		
		/*MinecraftServer serv = ((CraftServer)Bukkit.getServer()).getServer();
		WorldServer wserv = ((CraftWorld)Bukkit.getServer().getWorlds().get(0)).getHandle();
		String npp = np.toString();
		npc = new EntityPlayer(serv, wserv, new GameProfile(UUID.randomUUID(), npp), new PlayerInteractManager(wserv));
		PlayerConnection pc = ((CraftPlayer)p).getHandle().playerConnection;
		pc.sendPacket(new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.ADD_PLAYER, npc));
		pc.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));*/
		
	}

}
