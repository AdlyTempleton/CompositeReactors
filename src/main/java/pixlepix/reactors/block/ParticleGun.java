package pixlepix.reactors.block;

import cofh.api.energy.IEnergyReceiver;
import net.minecraft.tileentity.TileEntity;
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
}
