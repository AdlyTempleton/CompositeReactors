package pixlepix.reactors.main;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by localmacaccount on 1/12/15.
 */
public class Config {

    public static boolean overrideMaxParticleLimit = true;

    public static boolean giveBook = true;
    public static boolean analytics = true;


    static Configuration config;

    public static void init(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        config.getBoolean("analytics", Configuration.CATEGORY_GENERAL, true, "Sends anonymous reports on usage. Automatically disaled if snooper settings are disabled");

        overrideMaxParticleLimit = config.getBoolean("overrideMaxParticleLimit", Configuration.CATEGORY_GENERAL, true, "HIGHLY RECOMENDED TO KEEP ON. Disabling this will lead to erratic rendering behavior.");

        giveBook = config.getBoolean("Give Encyclopedia Aura automatically", Configuration.CATEGORY_GENERAL, giveBook, "");
        config.save();
    }
}
