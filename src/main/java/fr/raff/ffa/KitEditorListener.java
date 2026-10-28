package fr.raff.ffa;
import org.bukkit.event.*;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import java.util.*;

public class KitEditorListener implements Listener {
    private final KitManager km;
    public KitEditorListener(KitManager km){ this.km=km; }
    @EventHandler
    public void onClose(InventoryCloseEvent e){
        if(!e.getView().getTitle().contains("KitEditor")) return;
        List<ItemStack> items = new ArrayList<>();
        Arrays.stream(e.getInventory().getContents()).filter(Objects::nonNull).forEach(items::add);
        km.saveKit(items);
        e.getPlayer().sendMessage("§aKit sauvegardé ! "+items.size()+" items. Fais /kit pour tester.");
    }
}
