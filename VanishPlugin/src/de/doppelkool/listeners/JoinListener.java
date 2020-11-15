package de.doppelkool.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.doppelkool.main.Main;

public class JoinListener implements Listener{
	
	@EventHandler
    public void PlayerJoin(PlayerJoinEvent e)
	{
        Player player = e.getPlayer();
        for (int i = 0; i < Main.getplugin().invisible_list.size(); i++){
            player.hidePlayer(Main.getplugin().invisible_list.get(i));
        }
    }
}
