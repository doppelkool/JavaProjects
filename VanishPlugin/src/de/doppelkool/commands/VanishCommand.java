package de.doppelkool.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class VanishCommand implements CommandExecutor{

    public ArrayList<Player> invisible_list = new ArrayList<>();
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player)
		{
            Player player = (Player) sender;
            if(player.hasPermission("vanish.use"))
            {
                if (invisible_list.contains(player)){
                    for (Player people : Bukkit.getOnlinePlayers())
                    {
                        people.showPlayer(player);
                    }
                    invisible_list.remove(player);
                    player.sendMessage("§aDu bist wieder sichtbar!");
                }
                else if(!invisible_list.contains(player))
                {
                    for (Player people : Bukkit.getOnlinePlayers())
                    {
                    	if(people.hasPermission("vanish.bypass"))
                        people.hidePlayer(player);
                    }
                    invisible_list.add(player);
                    player.sendMessage("§cDu bist nun unsichtbar!");
                }
            }
        }
		return true;
	}
}
