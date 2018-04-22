package fr.weefle.revolution.npc;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import de.alphahelix.alphalibary.core.utilites.entity.EntityBuilder;
import fr.weefle.revolution.Revolution;
import net.samagames.tools.npc.NPCManager;

public class NpcSpawn {
	
	private Revolution main;
	public NpcSpawn(Revolution revolution) {
		this.main = revolution;
	}
	NPCManager npcm = new NPCManager(main.getSama());
	
	
	//private EntityPlayer npc;
	
	public static void spawnNPC(Player p, NpcType np) {
		/*VillagerTradeUtils villager = new VillagerTradeUtils(p.getLocation());
		villager.setCustomName(npp);
		villager.setCustomNameVisible(true);
		villager.addTrade(new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.APPLE, 1));
	
		CustomEffect.circle(p, ParticleEffect.FLAME, 10);*/
		/*FakePlayer fp = PlayerFakeUtil.spawnPlayer(p, p.getLocation(), GameProfileBuilder.fetch(UUID.randomUUID(), true), np.getName());
		PlayerFakeUtil.followPlayer(p, p, fp);
		SimpleFireworkEffect fw = new SimpleFireworkEffect(Type.STAR);
		fw.setColor(Color.RED);
		fw.build();*/
		
		//testing samagamesapi
		//npcm.createNPC(p.getLocation(), p.getUniqueId());
		
		EntityBuilder eb = new EntityBuilder(EntityType.VILLAGER);
		eb.setName(np.getName());
		eb.setGlowing(true);
		eb.spawn(p.getLocation());
		
		/*RNPC npc = new RNPC("test", p.getLocation());
		npc.spawn();
		
		CreatureBuilder cb = new CreatureBuilder(EntityType.VILLAGER);
		cb.name(npp);
		cb.spawn(p.getLocation());
		
		MinecraftServer serv = ((CraftServer)Bukkit.getServer()).getServer();
		WorldServer wserv = ((CraftWorld)Bukkit.getServer().getWorlds().get(0)).getHandle();
		String npp = np.toString();
		npc = new EntityPlayer(serv, wserv, new GameProfile(UUID.randomUUID(), npp), new PlayerInteractManager(wserv));
		PlayerConnection pc = ((CraftPlayer)p).getHandle().playerConnection;
		pc.sendPacket(new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.ADD_PLAYER, npc));
		pc.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));*/
		
	}

}
