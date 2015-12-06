package pixlepix.reactors.tile;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import pixlepix.reactors.data.CoordTuple;

/**
 * Created by ATempleton on 12/5/2015.
 */
public class TileElectromagnet extends TileReactorBlock {
    @Override
    public float getHeatConductivity() {
        return super.getHeatConductivity();
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        TileEntity te = new CoordTuple(this).add(ForgeDirection.VALID_DIRECTIONS[new CoordTuple(this).getMeta(worldObj)]).getTile(worldObj);

        if(te instanceof TileParticleGun) {
            TileParticleGun gun = (TileParticleGun) te;
            activity += gun.activity;
            gun.activity = 0;
        }

        for(ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS){
            if(direction.ordinal() != new CoordTuple(this).getMeta(worldObj)){
                te = new CoordTuple(this).add(direction).getTile(worldObj);

                if(te instanceof TileReactorBlock){
                    TileReactorBlock reactorBlock = (TileReactorBlock) te;
                    reactorBlock.activity += 1.25 * activity;
                    activity = 0;
                }
            }
        }
    }

    @Override
    public float getActivityConductivity() {
        return 0;
    }
}
