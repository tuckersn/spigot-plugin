package us.jericho.mc.server

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import us.jericho.mc.server.events.DeathEventListener
import us.jericho.mc.server.events.MobSpawnListener
import java.util.logging.Logger

class CustomServerPlugin: JavaPlugin() {

    companion object {
        var instance: CustomServerPlugin? = null;

        fun get(): CustomServerPlugin {
            return instance!!;
        }

        fun logger(): Logger {
            return Bukkit.getLogger();
        }
    }

    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(DeathEventListener, this)
        Bukkit.getPluginManager().registerEvents(MobSpawnListener, this)
        Bukkit.getLogger().info("Config Val: ${config.getString("configVal") ?: "[no val listed]"}")
        CustomServerPlugin.instance = this;
        Bukkit.getLogger().info("Enabled!")
    }


}