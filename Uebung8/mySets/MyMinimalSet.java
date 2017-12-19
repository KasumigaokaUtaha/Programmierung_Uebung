package mySets;
import java.util.Collection;

public interface MyMinimalSet<T> extends Iterable<T> {
    public abstract boolean contains(Object o);
    public abstract void addAllTo (Collection<T> col) throws UnmodifiableCollectionException;
}
