package belletti.supersymmetry.common.block;

import javax.annotation.Nonnull;

public enum SuSyStoneBlockType {

    STONE("stone", "%s"),
    COBBLE("cobble", "%s_cobblestone", 2.0f, 6.0f),
    BRICKS("bricks", "%s_bricks");

    public final String id;
    public final String blockId;
    public final float hardness;
    public final float resistance;

    SuSyStoneBlockType(@Nonnull String id, @Nonnull String blockId) {
        this(id, blockId, 1.5f, 10.0f); // vanilla stone stats
    }

    SuSyStoneBlockType(@Nonnull String id, @Nonnull String blockId, float hardness, float resistance) {
        this.id = id;
        this.blockId = blockId;
        this.hardness = hardness;
        this.resistance = resistance;
    }
}
