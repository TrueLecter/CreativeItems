package truelecter.creativelimit;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Base extends JavaPlugin implements Listener {
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		if (e.getPlayer().getGameMode() == GameMode.SURVIVAL) {
			if (!e.getPlayer().hasPermission("nameinlore.survival")) {
				return;
			}
			ItemStack i = e.getItemDrop().getItemStack();
			ItemMeta meta = i.getItemMeta();
			List<String> lore = meta.getLore();
			if (lore == null) {
				lore = new ArrayList<String>();
			}
			for (int ia = 0; ia < lore.size(); ia++) {
				if (lore.get(ia).contains("Создал")) {
					return;
				}
			}
			lore.add(ChatColor.translateAlternateColorCodes('&', "&6Создал &b") + e.getPlayer().getName());
			meta.setLore(lore);
			i.setItemMeta(meta);
		}
		if (e.getPlayer().getGameMode() == GameMode.CREATIVE) {
			if (!e.getPlayer().hasPermission("nameinlore.creative")) {
				return;
			}
			ItemStack i = e.getItemDrop().getItemStack();
			ItemMeta meta = i.getItemMeta();
			List<String> lore = meta.getLore();
			if (lore == null) {
				lore = new ArrayList<String>();
			}
			for (int ia = 0; ia < lore.size(); ia++) {
				if (lore.get(ia).contains("Создал")) {
					return;
				}
			}
			lore.add("§6Создал §b" + e.getPlayer().getName());
			meta.setLore(lore);
			i.setItemMeta(meta);
		}
	}

	@EventHandler
	public void Creative(InventoryCreativeEvent e) {
		if (e.getWhoClicked().hasPermission("nameinlore.creative")) {
			ItemStack i = e.getCursor();
			if (i == null) {
				return;
			}
			ItemMeta meta = i.getItemMeta();
			if (meta == null) {
				return;
			}
			List<String> lore = meta.getLore();
			if (lore == null) {
				lore = new ArrayList<String>();
			}
			for (int ia = 0; ia < lore.size(); ia++) {
				if (lore.get(ia).contains("Создал")) {
					return;
				}
			}
			lore.add("§6Создал §b" + e.getWhoClicked().getName());
			meta.setLore(lore);
			i.setItemMeta(meta);
			return;
		}
	}
	
	@EventHandler
	public void onInventoryClickt(InventoryClickEvent e) {
		if (e.getWhoClicked().hasPermission("nameinlore.creative")){
			ItemStack i = e.getCurrentItem();
			if (i == null) {
				return;
			}
			ItemMeta meta = i.getItemMeta();
			if (meta == null) {
				return;
			}
			List<String> lore = meta.getLore();
			if (lore == null) {
				lore = new ArrayList<String>();
			}
			for (int ia = 0; ia < lore.size(); ia++) {
				if (lore.get(ia).contains("Создал")) {
					return;
				}
			}
			lore.add("§6Создал §b" + e.getWhoClicked().getName());
			meta.setLore(lore);
			i.setItemMeta(meta);
			return;
		}
	}

	public void onEnable() {
		System.out.println(ChatColor.GREEN + "[CreativeItems] Enabled!");
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	public void onDisable() {
		System.out.println(ChatColor.GREEN + "[CreativeItems]" + ChatColor.RED + " Disabled!");
	}
}
