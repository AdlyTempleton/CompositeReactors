package pixlepix.reactors.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import pixlepix.reactors.data.CoordTuple;

import java.util.Random;

/**
 * Created by ATempleton on 12/3/2015.
 */
public class TileFuelRod extends TileReactorBlock {

    public int fuel;

    @Override
    public void writeCustomNBT(NBTTagCompound nbt) {
        super.writeCustomNBT(nbt);
        nbt.setInteger("fuel", fuel);
    }

    @Override
    public void readCustomNBT(NBTTagCompound nbt) {
        super.readCustomNBT(nbt);
        fuel = nbt.getInteger("fuel");
    }

    @Override
    public float getActivityConductivity() {
        return 100;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        for(ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS){
            TileEntity adjacentTile = new CoordTuple(this).add(direction).getTile(worldObj);
            if(adjacentTile instanceof TileFuelRod) {
                int totalFuel = fuel + ((TileFuelRod) adjacentTile).fuel;
                fuel = totalFuel / 2;
                ((TileFuelRod) adjacentTile).fuel = totalFuel / 2;
            }
        }

        if(!worldObj.isRemote && worldObj.getTotalWorldTime() % 20 == 19) {

            Random rand = new Random(worldObj.getTotalWorldTime());

            float f = .01F;
            float k = .01F / 1000;

            activity += k * activity * (heat + 10) * rand.nextGaussian();

            heat += activity * f;
            activity -= activity * f;

            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            markDirty();
        }
    }
}
