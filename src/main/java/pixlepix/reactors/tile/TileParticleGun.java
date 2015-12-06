package pixlepix.reactors.tile;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyReceiver;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by ATempleton on 12/3/2015.
 */
public class TileParticleGun extends TileReactorBlock implements IEnergyReceiver{



    protected EnergyStorage storage = new EnergyStorage(32000);

    /* IEnergyConnection */
    @Override
    public boolean canConnectEnergy(ForgeDirection from) {

        return true;
    }

    /* IEnergyReceiver */
    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {

        return storage.receiveEnergy(maxReceive, simulate);
    }

    /* IEnergyReceiver and IEnergyProvider */
    @Override
    public int getEnergyStored(ForgeDirection from) {

        return storage.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {
        return storage.getMaxEnergyStored();
    }


    @Override
    public void writeCustomNBT(NBTTagCompound nbt) {
        super.writeCustomNBT(nbt);
        nbt.setInteger("energy", storage.getEnergyStored());
    }

    @Override
    public void readCustomNBT(NBTTagCompound nbt) {
        super.readCustomNBT(nbt);
        storage.setEnergyStored(nbt.getInteger("energy"));
    }

    public void fire() {

        if(!worldObj.isRemote){
            if(storage.getEnergyStored() > 30000){
                storage.setEnergyStored(0);
                activity = 5000;
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            }
        }

    }
}
