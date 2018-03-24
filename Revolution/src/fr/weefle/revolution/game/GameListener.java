package fr.weefle.revolution.game;

import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import de.alphahelix.alphalibary.reflection.ReflectionUtil;
import fr.weefle.revolution.Revolution;

public class GameListener implements Listener {
	
	private Revolution main;
	public GameListener(Revolution revolution) {
		this.main = revolution;
	}

	@EventHandler
public void playerJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		p.getInventory().clear();
		p.setFoodLevel(20);
		p.setHealth(20);
		p.setLevel(0);
		
		if(!main.isState(GameState.WAITING)) {
			p.setGameMode(GameMode.SPECTATOR);
			p.sendMessage("�4La partie a d�j� commenc�!");
			return;
		}
		
		if(!main.getPlayers().contains(p)) main.getPlayers().add(p);
		p.setGameMode(GameMode.ADVENTURE);
		
		if(main.isState(GameState.WAITING) && main.getPlayers().size() >= 2) {
			GameManager gm = new GameManager(main);
			gm.runTaskTimer(main, 0, 20);
			main.setState(GameState.STARTING);
		}
		
	}
	
	@EventHandler
	public void playerQuit(PlayerQuitEvent e) {
		main.getPlayers().remove(e.getPlayer());
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onFallDamage(EntityDamageEvent e) {
		if(e.getCause().equals(DamageCause.FALL)) {
				e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onAttackDamage(EntityDamageByEntityEvent e) {
		if(e.getEntityType().equals(EntityType.PLAYER)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onTarget(EntityTargetEvent e) {
		
		if(!e.getEntityType().equals(EntityType.PLAYER)) {
			e.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if(main.isState(GameState.PLAYING)) {
			ReflectionUtil.getPing(e.getEntity());
			/*PacketUtil.createPlayerInfoPacket(arg0, arg1, arg2, arg3, arg4)
			WazeAPI.getInstance().getAutoRespawn().respawn(e.getEntity(), 20);*/
		}
	}
	
	@EventHandler
	public void onHunger(FoodLevelChangeEvent e) {
		if(e.getEntityType() == EntityType.PLAYER) {
			e.setCancelled(true);
		}
	}

}
