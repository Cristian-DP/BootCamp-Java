package adicionales;

import java.util.List;
import java.util.function.Predicate;

public interface Bipredicate<T, U> {

	boolean test (T t, List<Predicate<U>> l);
}
