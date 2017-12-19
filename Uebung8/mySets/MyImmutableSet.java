package mySets;
import java.util.Collection;
class MyImmutableSet<T> extends MyAbstractSet<T> implements MyMinimalSet<T> {
    public MyImmutableSet(MySetElement<T> initialvalue){
        super(initialvalue);
    }


    public boolean contains(Object o){
        return super.contains(o);
    }


    public void addAllTo(Collection<T> collection) throws UnmodifiableCollectionException {
        try{
            collection.addAll((Collection<? extends T>) this);
        }catch(UnsupportedOperationException e){
            throw new UnmodifiableCollectionException();
        }
    }
}
