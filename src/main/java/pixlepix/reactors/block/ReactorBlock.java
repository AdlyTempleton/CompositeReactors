package pixlepix.reactors.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import pixlepix.reactors.data.IToolTip;
import pixlepix.reactors.registry.ITTinkererBlock;
import pixlepix.reactors.registry.ThaumicTinkererRecipe;
import pixlepix.reactors.render.OverlayRender;
import pixlepix.reactors.tile.TileReactorBlock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ATempleton on 12/3/2015.
 */
public abstract class ReactorBlock extends Block implements ITTinkererBlock, IToolTip, ITileEntityProvider{

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        try {
            return getTileEntity().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> getTooltipData(World world, EntityPlayer player, int x, int y, int z) {
        TileReactorBlock te = (TileReactorBlock) world.getTileEntity(x, y, z);

        List<String> result = new LinkedList<String>();
        result.add("Heat: " + te.heat);
        result.add("Activity: " + te.activity);
        return result;
    }

    @Override
    public ArrayList<Object> getSpecialParameters() {
        return null;
    }
    @Override
    public boolean shouldRegister() {
        return true;
    }

    @Override
    public boolean shouldDisplayInTab() {
        return true;
    }

    @Override
    public Class<? extends ItemBlock> getItemBlock() {
        return null;
    }

    @Override
    public int getCreativeTabPriority() {
        return 0;
    }

    public ReactorBlock() {
        super(Material.iron);
    }
}
