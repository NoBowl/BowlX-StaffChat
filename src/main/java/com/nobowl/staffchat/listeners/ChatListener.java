import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatListener implements Listener {
    private final JavaPlugin plugin;

    public ChatListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if (event.getPlayer().hasPermission("BowlX.StaffChat.use")) {
            String message = event.getMessage();
            // Process the staff chat message
            event.setCancelled(true);
            plugin.getServer().getOnlinePlayers().stream()
                .filter(player -> player.hasPermission("BowlX.StaffChat.receive"))
                .forEach(player -> player.sendMessage("[Staff Chat] " + event.getPlayer().getName() + ": " + message));
        }
    }
}