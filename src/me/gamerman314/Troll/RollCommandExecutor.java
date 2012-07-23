package me.gamerman314.Troll;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;



// Modifications from 1.1.1 to 1.2 done by Zordain
// Referenced classes of package me.gamerman314.Troll:
//                 Troll n' Roll

public class RollCommandExecutor
    implements CommandExecutor
{

    public RollCommandExecutor(Troll plugin)
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
        Player player = null;
        if(sender instanceof Player)
            player = (Player)sender;
        if(cmd.getName().equalsIgnoreCase("barrelroll"))
            if(sender instanceof Player) {
                if(player.hasPermission("troll.barrelroll")) {
                    if(args.length == 0) {
                        Bukkit.getServer().broadcastMessage((new StringBuilder()).append(player.getDisplayName()).append(ChatColor.GRAY).append(" does a barrel roll!").toString());
                        return true;
                    }
                    if(args.length ==1) {
                        if(Bukkit.getServer().getPlayer(args[0]) != null) {
                            Player targetplayer = player.getServer().getPlayer(args[0]);
                            Bukkit.getServer().broadcastMessage((new StringBuilder()).append(player.getDisplayName()).append(ChatColor.GRAY).append(" wants ").append(targetplayer.getDisplayName()).append(ChatColor.GRAY).append(" to do a barrel roll!").toString());
                            return true;
                        } else {
                            sender.sendMessage((new StringBuilder()).append(ChatColor.RED).append("There is no player online with this name.").toString());
                            return true;
                        }
                    }
                    if(args.length > 1) {
                        sender.sendMessage(ChatColor.RED + "Usage: /barrelroll or /barrelroll <targetplayer>.");
                        return false;
                    }
                } else {
                    player.sendMessage((new StringBuilder()).append(ChatColor.RED).append("You dont have permission to use that command").toString());
                    return true;
                }
            } else { 
                sender.sendMessage((new StringBuilder()).append(ChatColor.RED).append("You have to be in the game to use this command you N00B").toString());
                return true;
            }
        return false;
    }
    private Troll plugin;
}