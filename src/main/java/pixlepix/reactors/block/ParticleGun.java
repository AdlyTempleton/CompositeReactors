package pixlepix.reactors.block;

import cofh.api.energy.IEnergyReceiver;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import pixlepix.reactors.registry.ThaumicTinkererRecipe;
import pixlepix.reactors.tile.TileParticleGun;

/**
 * Created by ATempleton on 12/3/2015.
 */
public class ParticleGun extends ReactorBlock implements IEnergyReceiver {
    @Override
    public String getBlockName() {
        return "particleGun";
    }

    @Override
    public Class<? extends TileEntity> getTileEntity() {
        return TileParticleGun.class;
    }

    @Override
    public ThaumicTinkererRecipe getRecipeItem() {
        return null;
    }

    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
        return 0;
    }

    @Override
    public int getEnergyStored(ForgeDirection from) {
        return 0;
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {
        return 0;
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection from) {
        return false;
    }

    //Copied from dispenser code
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {

        boolean flag = world.isBlockIndirectlyGettingPowered(x, y, z) || world.isBlockIndirectlyGettingPowered(x, y + 1, z);
        int l = world.getBlockMetadata(x, y, z);
        boolean flag1 = l != 0;

        if (flag && !flag1) {
            TileParticleGun gun = (TileParticleGun) world.getTileEntity(x, y, z);
            gun.fire();
            world.setBlockMetadataWithNotify(x, y, z, 1, 4);
        } else if (!flag && flag1) {
            world.setBlockMetadataWithNotify(x, y, z, 0, 4);
        }
    }
}
