package pixlepix.reactors.block;

import net.minecraft.tileentity.TileEntity;
import pixlepix.reactors.registry.ThaumicTinkererRecipe;
import pixlepix.reactors.tile.TileCoolantPipe;

/**
 * Created by ATempleton on 12/3/2015.
 */
public class CoolantPipe extends ReactorBlock {
    @Override
    public String getBlockName() {
        return "coolantPipe";
    }

    @Override
    public Class<? extends TileEntity> getTileEntity() {
        return TileCoolantPipe.class;
    }

    @Override
    public ThaumicTinkererRecipe getRecipeItem() {
        return null;
    }
}
