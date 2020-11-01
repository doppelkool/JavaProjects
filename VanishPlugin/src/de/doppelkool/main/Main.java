package de.doppelkool.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.doppelkool.commands.VanishCommand;
import de.doppelkool.listeners.JoinListener;

public class Main extends JavaPlugin
{
    public ArrayList<Player> invisible_list = new ArrayList<>();
	private static Main plugin;
	public void onEnable()
	{
		plugin = this;
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new JoinListener(), this);
		getCommand("vanish").setExecutor(new VanishCommand());
	}
	
	public static Main getplugin()
	{
		return plugin;
	}
}
