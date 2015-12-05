package pixlepix.reactors.block;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import pixlepix.reactors.registry.ThaumicTinkererRecipe;
import pixlepix.reactors.tile.TileFuelRod;
import pixlepix.reactors.tile.TileReactorBlock;

/**
 * Created by ATempleton on 12/3/2015.
 */
public class FuelRod extends ReactorBlock {
    @Override
    public String getBlockName() {
        return "fuelRod";
    }

    @Override
    public Class<? extends TileEntity> getTileEntity() {
        return TileFuelRod.class;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        TileFuelRod tile = (TileFuelRod) world.getTileEntity(x, y, z);

        if(Block.getBlockFromItem(player.getCurrentEquippedItem().getItem()) == Blocks.cactus){
            tile.fuel += player.getCurrentEquippedItem().stackSize * 1000;
            player.destroyCurrentEquippedItem();
            return true;
        }

        return false;
    }

    @Override
    public ThaumicTinkererRecipe getRecipeItem() {
        return null;
    }
}
