package fr.weefle.revolution.npc;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;

public class NpcGui {
	
	public void createGUI(int rows, String title) {
		
		Merchant merch = Bukkit.createMerchant(title);
		MerchantRecipe mr = new MerchantRecipe(new ItemStack(Material.ACACIA_DOOR), 10);
		merch.getRecipes().add(mr);
		merch.getTrader().sendMessage("Coucou " + merch.getTrader().getName());
		
		
	}

}
