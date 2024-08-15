package belletti.supersymmetry.api.recipes.catalysts;

import javax.annotation.Nonnull;

public record CatalystInfo(int tier, double yieldEfficiency, double energyEfficiency,
                           double speedEfficiency) implements Comparable<CatalystInfo> {

    public static final int NO_TIER = -1;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CatalystInfo that = (CatalystInfo) o;

        if (tier() != that.tier()) return false;
        if (Double.compare(that.yieldEfficiency(), yieldEfficiency()) != 0) return false;
        if (Double.compare(that.energyEfficiency(), energyEfficiency()) != 0) return false;
        return Double.compare(that.speedEfficiency(), speedEfficiency()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        result = tier();
        result = 31 * result + Double.hashCode(yieldEfficiency());
        result = 31 * result + Double.hashCode(energyEfficiency());
        result = 31 * result + Double.hashCode(speedEfficiency());
        return result;
    }

    @Override
    public int compareTo(@Nonnull CatalystInfo o) {
        // compare order: Tier, Speed, Yield, Energy
        int result = Integer.compare(this.tier(), o.tier());
        if (result != 0) return result;
        result = Double.compare(this.speedEfficiency(), o.speedEfficiency());
        if (result != 0) return result;
        result = Double.compare(this.yieldEfficiency(), o.yieldEfficiency());
        if (result != 0) return result;
        result = Double.compare(this.energyEfficiency(), o.energyEfficiency());
        return result;
    }
}
