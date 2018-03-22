package fr.weefle.revolution.npc;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_12_R1.CraftServer;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_12_R1.EntityPlayer;
import net.minecraft.server.v1_12_R1.MinecraftServer;
import net.minecraft.server.v1_12_R1.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_12_R1.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_12_R1.PacketPlayOutPlayerInfo.EnumPlayerInfoAction;
import net.minecraft.server.v1_12_R1.PlayerConnection;
import net.minecraft.server.v1_12_R1.PlayerInteractManager;
import net.minecraft.server.v1_12_R1.WorldServer;

public class NpcSpawn {
	
	private EntityPlayer npc;
	
	public void spawnNPC(Player p, NpcType np) {
		
		MinecraftServer serv = ((CraftServer)Bukkit.getServer()).getServer();
		WorldServer wserv = ((CraftWorld)Bukkit.getServer().getWorlds().get(0)).getHandle();
		String npp = np.toString();
		npc = new EntityPlayer(serv, wserv, new GameProfile(UUID.randomUUID(), npp), new PlayerInteractManager(wserv));
		PlayerConnection pc = ((CraftPlayer)p).getHandle().playerConnection;
		pc.sendPacket(new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.ADD_PLAYER, npc));
		pc.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
		
	}

}
