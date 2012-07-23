/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.gamerman314.Troll;

/**
 *
 * @author Geoffrey
 * 
 * Modification from 1.1.1 to 1.2 done by Zordain
 */
import org.bukkit.plugin.java.JavaPlugin;

public class Troll extends JavaPlugin
{

    public Troll()
    {
    }

    public void onEnable()
    {
        trollExecutor = new TrollCommandExecutor(this);
        rollExecutor = new RollCommandExecutor(this);
        getCommand("troll").setExecutor(trollExecutor);
        getCommand("trollkick").setExecutor(trollExecutor);
        getCommand("trolled").setExecutor(trollExecutor);
        getCommand("trolledall").setExecutor(trollExecutor);
        getCommand("facepalm").setExecutor(trollExecutor);
        getCommand("barrelroll").setExecutor(rollExecutor);
        pluginInfo("Enabled!");
    }

    public void onDisable()
    {
        pluginInfo("Disabled!");
    }

    public static void pluginInfo(String message)
    {
        String v = "1.2";
        System.out.println((new StringBuilder()).append("[Troll] Troll Plugin ").append(v).append(" ").append(message).toString());
    }

    private TrollCommandExecutor trollExecutor;
    private RollCommandExecutor rollExecutor;
}