package pixlepix.reactors.tile;

/**
 * Created by ATempleton on 12/3/2015.
 */
public class TileCoolantPipe extends TileReactorBlock{

    @Override
    public float getHeatConductivity() {
        return 500;
    }

    @Override
    public float getActivityConductivity() {
        return 10;
    }
}
