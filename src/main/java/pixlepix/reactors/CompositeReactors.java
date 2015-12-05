package pixlepix.reactors;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.npe.gameanalytics.SimpleAnalytics;
import org.apache.logging.log4j.Logger;
import pixlepix.reactors.main.CommonProxy;
import pixlepix.reactors.main.ConstantMod;

@SuppressWarnings("UnusedDeclaration")
@Mod(modid = ConstantMod.modId, name = ConstantMod.modName, version = ConstantMod.version, dependencies = "")
public class CompositeReactors {

    public static SimpleAnalytics analytics;
    
    @Instance(ConstantMod.modId)
    public static CompositeReactors instance;

    @SidedProxy(clientSide = ConstantMod.clientProxy, serverSide = ConstantMod.commonProxy)
    public static CommonProxy proxy;
    public static Logger log;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        log = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);

    }
}
