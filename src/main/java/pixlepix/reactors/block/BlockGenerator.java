package pixlepix.reactors.block;

import net.minecraft.tileentity.TileEntity;
import pixlepix.reactors.registry.ThaumicTinkererRecipe;
import pixlepix.reactors.tile.TileGenerator;

/**
 * Created by ATempleton on 12/4/2015.
 */
public class BlockGenerator extends ReactorBlock {
    @Override
    public String getBlockName() {
        return "generator";
    }

    @Override
    public Class<? extends TileEntity> getTileEntity() {
        return TileGenerator.class;
    }

    @Override
    public ThaumicTinkererRecipe getRecipeItem() {
        return null;
    }
}
