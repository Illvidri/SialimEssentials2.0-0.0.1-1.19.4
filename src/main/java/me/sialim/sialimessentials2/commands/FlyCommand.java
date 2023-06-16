package me.sialim.sialimessentials2.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {
    private ArrayList<Player> flyingPlayerList = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player p){
            if(args.length==0){
                flyLogic(p);
            }else if(args.length==1){
                Player t = Bukkit.getServer().getPlayerExact(args[0]);
                flyLogic(t);
            }
        }
        return true;
    }
    private void flyLogic(Player p){
        if(p.hasPermission("sialimessentials.fly")){
            if(flyingPlayerList.contains(p)){
                flyingPlayerList.remove(p);
                p.setAllowFlight(false);
                p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "SialimEssentials" + ChatColor.DARK_GRAY + "|" + ChatColor.GREEN + "Success" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY + " Flight toggled. " + ChatColor.DARK_GRAY + "(" + ChatColor.GRAY + "Disabled" + ChatColor.DARK_GRAY + ")");
            }else if(!flyingPlayerList.contains(p)){
                flyingPlayerList.add(p);
                p.setAllowFlight(true);
                p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "SialimEssentials" + ChatColor.DARK_GRAY + "|" + ChatColor.GREEN + "Success" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY + " Flight toggled. " + ChatColor.DARK_GRAY + "(" + ChatColor.GRAY + "Enabled" + ChatColor.DARK_GRAY + ")");
            }
        }
    }
}
