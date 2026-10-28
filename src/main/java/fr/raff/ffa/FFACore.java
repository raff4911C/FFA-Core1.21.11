package fr.raff.ffa;

import org.bukkit.plugin.java.JavaPlugin;

public class FFACore extends JavaPlugin {
    private KitManager kitManager;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        kitManager = new KitManager(this);
        getCommand("kit").setExecutor(new KitCommand(kitManager));
        getCommand("kiteditor").setExecutor(new KitEditorCommand(kitManager));
        getServer().getPluginManager().registerEvents(new KitEditorListener(kitManager), this);
        getLogger().info("FFA-Core 1.21.11 ON");
    }
    public KitManager getKitManager(){ return kitManager; }
}
