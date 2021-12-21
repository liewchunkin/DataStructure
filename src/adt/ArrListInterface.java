package adt;

/**
 *
 * @author Liew Chun Kin
 */
public interface ArrListInterface<T> {

    public boolean add(T newEntry);

    public boolean add(int newPosition, T newEntry);

    public T remove(int givenPosition);

    public boolean remove(T entry);

    public void removeGap(int givenPosition);

    public boolean replace(int givenPosition, T newEntry);

    public T getEntry(int givenPosition);

    public int getPosition(T entry);

    public void doubleArray();

    public boolean contains(T entry);

    public void trimLength();

    public boolean isArrayFull();

    public boolean isEmpty();

    public int getLength();

    public void clear();

    public void createSpace(int newPosition);
}
