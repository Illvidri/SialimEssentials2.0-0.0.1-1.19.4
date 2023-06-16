package me.sialim.sialimessentials2.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player p){
            if(args.length==0){
                p.setFoodLevel(20);
                p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "SialimEssentials" + ChatColor.DARK_GRAY + "|" + ChatColor.GREEN + "Success" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY + " Player hunger replenished.");
            }else if(args.length==1){
                String targetName = args[0];
                Player t = Bukkit.getServer().getPlayerExact(targetName);
                if(t==null){
                    p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "SialimEssentials" + ChatColor.DARK_GRAY + "|" + ChatColor.RED + "Error" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY + " Invalid argument. Target offline or non-existent.");
                }else{
                    p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "SialimEssentials" + ChatColor.DARK_GRAY + "|" + ChatColor.GREEN + "Success" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY + " Player " + ChatColor.YELLOW + t.getDisplayName() + ChatColor.GRAY + " hunger replenished.");
                    t.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "SialimEssentials" + ChatColor.DARK_GRAY + "|" + ChatColor.GREEN + "Success" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY + " Player hunger replenished by " + ChatColor.YELLOW + p.getDisplayName());
                    t.setFoodLevel(20);
                }
            }
        }
        return true;
    }
}
