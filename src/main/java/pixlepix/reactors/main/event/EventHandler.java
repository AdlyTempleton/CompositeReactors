package pixlepix.reactors.main.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import pixlepix.reactors.item.ItemLexicon;
import pixlepix.reactors.main.Config;
import pixlepix.reactors.registry.BlockRegistry;

/**
 * Created by pixlepix on 12/16/14.
 */
public class EventHandler {
    public static final String BOOK_TAG = "HAS_RECEIVED_AURA_BOOK";

    //Lexicon auto give
    @SubscribeEvent
    public void onWorldLoad(cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayer player = event.player;
        if (!player.worldObj.isRemote && Config.giveBook) {
            if (!player.getEntityData().hasKey(BOOK_TAG) || !player.getEntityData().getBoolean(BOOK_TAG)) {
                player.getEntityData().setBoolean(BOOK_TAG, true);
                player.inventory.addItemStackToInventory(new ItemStack(BlockRegistry.getFirstItemFromClass(ItemLexicon.class)));
            }

        }

    }
    //Lexicon auto give
    @SubscribeEvent
    public void onPlayerRespawn(cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent event) {
        EntityPlayer player = event.player;
        player.getEntityData().setBoolean(BOOK_TAG, true);

    }

}
