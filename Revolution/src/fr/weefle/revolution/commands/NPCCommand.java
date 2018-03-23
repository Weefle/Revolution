package fr.weefle.revolution.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.weefle.revolution.npc.NpcSpawn;
import fr.weefle.revolution.npc.NpcType;

public class NPCCommand implements CommandExecutor {
	
	NpcSpawn npc = new NpcSpawn();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		Player p = (Player) sender;
		if(sender instanceof Player) {
			if(msg.equalsIgnoreCase("spwannpc")) {
				npc.spawnNPC(p, NpcType.ARMOR);
			}
		}
		return true;
	}
	
	

}
