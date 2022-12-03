package bj.prexed.succursaleservice.Utils;

import java.util.Optional;

public class OptionalUtils {
private String ok;
    public static <T> T fromOptional(Optional<T> optional) {
        return optional.orElse( null );
    }

}