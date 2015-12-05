package pixlepix.reactors.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import pixlepix.reactors.data.CoordTuple;

/**
 * Created by ATempleton on 12/3/2015.
 */
public abstract class TileReactorBlock extends TileEntity{

    public int heat;
    public int activity;

    @Override
    public void updateEntity() {
        for(ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS){
            TileEntity adjacentTile = new CoordTuple(this).add(direction).getTile(worldObj);
            if(adjacentTile instanceof TileReactorBlock) {
                TileReactorBlock tileReactorBlock = (TileReactorBlock) adjacentTile;

                if (tileReactorBlock.activity < activity) {
                    int transferredActivity = (int) (.001F * tileReactorBlock.getActivityConductivity() * (activity - tileReactorBlock.activity));

                    tileReactorBlock.activity += transferredActivity;
                    activity -= transferredActivity;
                }

                if (tileReactorBlock.heat < heat) {
                    int transferredHeat = (int) (.01F * tileReactorBlock.getHeatConductivity() * (heat - tileReactorBlock.heat));

                    tileReactorBlock.heat += transferredHeat;
                    heat -= transferredHeat;
                }
            }

            if(worldObj.getTotalWorldTime() % 4 == 0) {
                activity = Math.max(activity - 1, 0);
            }
        }
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nbt = new NBTTagCompound();
        writeCustomNBT(nbt);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, nbt);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        readCustomNBT(pkt.func_148857_g());
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        writeCustomNBT(nbt);
    }

    public void writeCustomNBT(NBTTagCompound nbt) {
        nbt.setInteger("activity", activity);
        nbt.setInteger("heat", heat);
    }

    public void readCustomNBT (NBTTagCompound nbt) {
        activity = nbt.getInteger("activity");
        heat = nbt.getInteger("heat");
    }

    public float getHeatConductivity(){return 100F;};
    public float getActivityConductivity(){return 50F;};

}
