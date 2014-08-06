package truelecter.creativelimit;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Base extends JavaPlugin implements Listener {
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		// System.out.println(e.getPlayer().getName() + " dropped "
		// + e.getItemDrop().getItemStack().getType().toString() +
		// " in gamemode "
		// + e.getPlayer().getGameMode().toString());
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
				if (lore.get(ia).contains("Выкинул")) {
					return;
				}
			}
			lore.add(ChatColor.translateAlternateColorCodes('&', "&6Выкинул &b") + e.getPlayer().getName());
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
				if (lore.get(ia).contains("Выкинул")) {
					return;
				}
			}
			lore.add("§6Выкинул §b" + e.getPlayer().getName());
			meta.setLore(lore);
			i.setItemMeta(meta);
		}
	}

	@EventHandler
	public void onInventoryOpenEvent(InventoryDragEvent e) {
		if (e.getInventory().getHolder() instanceof Chest || e.getInventory().getHolder() instanceof DoubleChest) {
			if (e.getWhoClicked().getGameMode().equals(GameMode.CREATIVE)) {
				if (!e.getWhoClicked().hasPermission("nameinlore.creative")) {
					ItemStack i = e.getCursor();
					ItemMeta meta = i.getItemMeta();
					List<String> lore = meta.getLore();
					if (lore == null) {
						lore = new ArrayList<String>();
					}
					for (int ia = 0; ia < lore.size(); ia++) {
						if (lore.get(ia).contains("Выкинул")) {
							return;
						}
					}
					lore.add("§6Выкинул §b" + e.getWhoClicked().getName());
					meta.setLore(lore);
					i.setItemMeta(meta);
					return;
				}
			}
		}
	}

	@EventHandler
	public void onInventoryOpenEvent(InventoryMoveItemEvent e) {
		if (e.getInitiator().getHolder() instanceof Chest || e.getInitiator().getHolder() instanceof DoubleChest) {
			if (e.getInitiator().getViewers().get(0).getGameMode().equals(GameMode.CREATIVE)) {
				if (!e.getInitiator().getViewers().get(0).hasPermission("nameinlore.creative")) {
					ItemStack i = e.getItem();
					ItemMeta meta = i.getItemMeta();
					List<String> lore = meta.getLore();
					if (lore == null) {
						lore = new ArrayList<String>();
					}
					for (int ia = 0; ia < lore.size(); ia++) {
						if (lore.get(ia).contains("Выкинул")) {
							return;
						}
					}
					lore.add("§6Выкинул §b" + e.getInitiator().getViewers().get(0).getName());
					meta.setLore(lore);
					i.setItemMeta(meta);
					return;
				}
			}
		}
		if (e.getDestination().getHolder() instanceof Chest || e.getDestination().getHolder() instanceof DoubleChest) {
			if (e.getDestination().getViewers().get(0).getGameMode().equals(GameMode.CREATIVE)) {
				if (!e.getDestination().getViewers().get(0).hasPermission("nameinlore.creative")) {
					ItemStack i = e.getItem();
					ItemMeta meta = i.getItemMeta();
					List<String> lore = meta.getLore();
					if (lore == null) {
						lore = new ArrayList<String>();
					}
					for (int ia = 0; ia < lore.size(); ia++) {
						if (lore.get(ia).contains("Выкинул")) {
							return;
						}
					}
					lore.add("§6Выкинул §b" + e.getDestination().getViewers().get(0).getName());
					meta.setLore(lore);
					i.setItemMeta(meta);
					return;
				}
			}
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
