package belletti.supersymmetry.api.capability;

import org.jetbrains.annotations.Nullable;

public interface ICryogenicReceiver {
    /**
     * @param cryogenicProvider the cryogenic provider to associate with this
     */
    void setCryogenicProvider(@Nullable ICryogenicProvider cryogenicProvider);
}
