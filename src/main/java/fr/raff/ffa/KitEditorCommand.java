package fr.raff.ffa;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class KitEditorCommand implements CommandExecutor {
    private final KitManager km;
    public KitEditorCommand(KitManager km){ this.km=km; }
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String l, String[] a){
        if(!(s instanceof Player p)) return true;
        Inventory inv = Bukkit.createInventory(null, 54, "KitEditor - Pose ton kit");
        km.getKitItems().forEach(inv::addItem);
        p.openInventory(inv);
        p.sendMessage("§ePose les items et ferme pour sauvegarder.");
        return true;
    }
}
