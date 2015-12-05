package pixlepix.reactors.tile;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyProvider;
import cofh.api.energy.IEnergyReceiver;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by ATempleton on 12/4/2015.
 */
public class TileGenerator extends TileReactorBlock implements IEnergyProvider{

    @Override
    public void updateEntity() {
        super.updateEntity();

        storage.receiveEnergy(heat * 1000, false);
        storage.extractEnergy(activity * 5000, false);

        heat = 0;
        activity = 0;

    }

    private EnergyStorage storage = new EnergyStorage(1000000);


    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
        return storage.extractEnergy(maxExtract, simulate);
    }

    @Override
    public int getEnergyStored(ForgeDirection from) {
        return storage.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {
        return storage.getMaxEnergyStored();
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection from) {
        return true;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
    }
}
