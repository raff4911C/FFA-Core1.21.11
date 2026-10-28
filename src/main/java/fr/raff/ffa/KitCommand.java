package fr.raff.ffa;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class KitCommand implements CommandExecutor {
    private final KitManager km;
    public KitCommand(KitManager km){ this.km=km; }
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String l, String[] a){
        if(!(s instanceof Player p)){ s.sendMessage("Joueur seulement"); return true; }
        km.giveKit(p);
        p.sendMessage("§aKit FFA donné !");
        return true;
    }
}
