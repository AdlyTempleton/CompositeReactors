package pixlepix.reactors.main;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import pixlepix.reactors.KeyBindings;
import pixlepix.reactors.data.CoordTuple;
import pixlepix.reactors.lexicon.*;
import pixlepix.reactors.render.OverlayRender;

public class ClientProxy extends CommonProxy {


    @Override
    public World getWorld() {
        return Minecraft.getMinecraft().theWorld;
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        FMLCommonHandler.instance().bus().register(new ClientTickHandler());
        MinecraftForge.EVENT_BUS.register(new OverlayRender());

        KeyBindings.init();


    }
    @Override
    public void addToTutorial(LexiconEntry entry) {

        GuiLexicon.tutorialMaster.add(entry);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

    @Override
    public EntityPlayer getPlayer() {
        return Minecraft.getMinecraft().thePlayer;
    }

    @Override
    public EffectRenderer getEffectRenderer() {
        return Minecraft.getMinecraft().effectRenderer;
    }


    @Override
    public void setEntryToOpen(LexiconEntry entry) {
        GuiLexicon.currentOpenLexicon = new GuiLexiconEntry(entry, new GuiLexiconIndex(entry.category));
    }


    public void addBlockDestroyEffects(CoordTuple tuple) {

        Minecraft.getMinecraft().effectRenderer.addBlockDestroyEffects(tuple.getX(), tuple.getY(), tuple.getZ(), tuple.getBlock(Minecraft.getMinecraft().theWorld), tuple.getMeta(Minecraft.getMinecraft().theWorld));


    }

    @Override
    public void setLexiconStack(ItemStack stack) {
        GuiLexicon.stackUsed = stack;
    }

    @Override
    public void addEffectBypassingLimit(EntityFX entityFX) {
        if (Config.overrideMaxParticleLimit) {
            Minecraft.getMinecraft().effectRenderer.fxLayers[entityFX.getFXLayer()].add(entityFX);
        } else {
            Minecraft.getMinecraft().theWorld.spawnEntityInWorld(entityFX);
        }
    }
}
