import org.bukkit.plugin.java.JavaPlugin;

public class StaffChatPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("BowlX StaffChat has been enabled!");
        getCommand("staffchat").setExecutor(new StaffChatCommand());
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("BowlX StaffChat Has Been Disabled!");
    }
}