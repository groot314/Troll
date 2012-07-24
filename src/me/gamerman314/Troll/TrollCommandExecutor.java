/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.gamerman314.Troll;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Geoffrey
 */
public class TrollCommandExecutor implements CommandExecutor {

    private Troll plugin;

    public TrollCommandExecutor(Troll plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = null;
        if (sender instanceof Player) {
            player = (Player) sender;
        }


        //on command "Troll"
        if (cmd.getName().equalsIgnoreCase("troll")) {
            if ((sender instanceof Player)) {

                if (player.hasPermission("troll.trolol")) {
                    if (args.length == 0) {
                        Bukkit.getServer().broadcastMessage(player.getDisplayName() + ChatColor.GRAY + " is a Trololololololol");
                        return true;
                    } else if (args.length == 1) {
                        if (Bukkit.getServer().getPlayer(args[0]) != null) {
                            Player targetplayer = player.getServer().getPlayer(args[0]);
                            Bukkit.getServer().broadcastMessage(targetplayer.getDisplayName() + ChatColor.GRAY + " is a Trololololololol");
                            return true;
                        } else {
                            sender.sendMessage(ChatColor.RED + "There is no player Online with this name.");
                            return true;
                        }
                    } else if (args.length > 1) {
                        return false;
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You dont have Permissions to that command");
                    return true;
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You have to be in the game to use this command you N00B");
                return true;
            }

        }

        //on Command "trollban"
        if (cmd.getName().equalsIgnoreCase("trollkick")) {
            if ((sender instanceof Player)) {

                if (player.hasPermission("troll.kick")) {
                    if (args.length == 0) {
                        return false;
                    } else if (args.length == 1) {
                        if (Bukkit.getServer().getPlayer(args[0]) != null) {
                            Player targetplayer = player.getServer().getPlayer(args[0]);
                            targetplayer.kickPlayer("You have been troll kicked, you can now log back in");
                            Bukkit.getServer().broadcastMessage(targetplayer.getDisplayName() + ChatColor.GRAY + " has been troll kicked");
                            return true;
                        } else {
                            sender.sendMessage(ChatColor.RED + "There is no player Online with this name.");
                            return true;
                        }
                    } else if (args.length > 1) {
                        return false;
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You dont have Permissions to that command");
                    return true;
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You have to be in the game to use this command you N00B");
                return true;

            }
        }

        //command trolled
        if (cmd.getName().equalsIgnoreCase("trolled")) {
            if ((sender instanceof Player)) {

                if (player.hasPermission("troll.trolled")) {
                    if (args.length == 0) {
                        return false;
                    } else if (args.length == 1) {
                        if (Bukkit.getServer().getPlayer(args[0]) != null) {
                            Player targetplayer = player.getServer().getPlayer(args[0]);
                            Bukkit.getServer().broadcastMessage(player.getDisplayName() + ChatColor.GRAY + " Trolled " + targetplayer.getDisplayName());
                            return true;
                        } else {
                            sender.sendMessage(ChatColor.RED + "There is no player Online with this name.");
                            return true;
                        }
                    } else if (args.length > 1) {
                        return false;
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You dont have Permissions to that command");
                    return true;
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You have to be in the game to use this command you N00B");
                return true;

            }
        }

        //command facepalmed
        if (cmd.getName().equalsIgnoreCase("facepalm")) {
            if ((sender instanceof Player)) {

                if (player.hasPermission("troll.facepalm")) {
                    if (args.length == 0) {
                        Bukkit.getServer().broadcastMessage(player.getDisplayName() + ChatColor.GRAY + " Facepalmed");
                        return true;
                    } else if (args.length > 0) {
                        return false;
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You dont have Permissions to that command");
                    return true;
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You have to be in the game to use this command you N00B");
                return true;

            }
        }

        //command tralledall 
        if (cmd.getName().equalsIgnoreCase("trolledAll")) {
            if (sender instanceof Player) {
                if (player.hasPermission("troll.trolled.all")) {
                    if (args.length == 0) {
                        Bukkit.getServer().broadcastMessage((new StringBuilder()).append(player.getDisplayName()).append(ChatColor.GRAY).append(" trolled everybody.").toString());
                        return true;
                    }
                    if (args.length > 0) {
                        return false;
                    }
                } else {
                    player.sendMessage((new StringBuilder()).append(ChatColor.RED).append("You dont have permission to that command").toString());
                    return true;
                }
            } else {
                sender.sendMessage((new StringBuilder()).append(ChatColor.RED).append("You have to be in the game to use this command you N00B").toString());
                return true;
            }
        }
        
        if (cmd.getName().equalsIgnoreCase("superTroll")){
            if (sender instanceof Player) {
                if (player.hasPermission("troll.superTroll")) {
                    if (args.length == 0) {
                        Bukkit.getServer().broadcastMessage((new StringBuilder()).append(player.getDisplayName()).append(ChatColor.GRAY).append(" is a Super Troll").toString());
                        return true;
                    }
                    if (args.length > 0) {
                        return false;
                    }
                } else {
                    player.sendMessage((new StringBuilder()).append(ChatColor.RED).append("You dont have permission to that command").toString());
                    return true;
                }
            } else {
                sender.sendMessage((new StringBuilder()).append(ChatColor.RED).append("You have to be in the game to use this command you N00B").toString());
                return true;
            }
        }


        return false;
    }
}
