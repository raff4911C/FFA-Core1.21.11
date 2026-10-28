package fr.raff.ffa;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.*;

public class KitManager {
    private final JavaPlugin plugin;
    public KitManager(JavaPlugin plugin){ this.plugin = plugin; }
    
    public void giveKit(Player p){
        FileConfiguration c = plugin.getConfig();
        if(!c.contains("kit")) { setDefaultKit(); }
        List<ItemStack> items = (List<ItemStack>) c.get("kit.items");
        if(items==null) return;
        p.getInventory().clear();
        for(ItemStack it : items) if(it!=null) p.getInventory().addItem(it);
        p.updateInventory();
    }
    
    public void saveKit(List<ItemStack> items){
        plugin.getConfig().set("kit.items", items);
        plugin.saveConfig();
    }
    
    private void setDefaultKit(){
        // kit de base si pas de /kiteditor fait
        plugin.getConfig().set("kit.items", new ArrayList<>());
        plugin.saveConfig();
    }
    
    public List<ItemStack> getKitItems(){
        List<ItemStack> items = (List<ItemStack>) plugin.getConfig().get("kit.items");
        return items != null ? items : new ArrayList<>();
    }
}
