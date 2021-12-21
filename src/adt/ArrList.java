/**
 *
 * @author Liew Chun Kin
 */
package adt;

public class ArrList<T> implements ArrListInterface<T> {

    private T[] arr;
    private int length;
    private static final int DEFAULT_CAPACITY = 50;

    public ArrList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrList(int initialCapacity) {
        length = 0;
        arr = (T[]) new Object[initialCapacity];
    }

    @Override
    public boolean add(T newEntry) {

        if (isArrayFull()) {
            //double the arry list if array list is full
            doubleArray();
        }

        arr[length] = newEntry;

        length++;
        return true;
    }

    @Override
    public boolean add(int newPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((newPosition >= 1) && (newPosition <= length + 1)) {
            if (isArrayFull()) {
                //double the arry list if array list is full
                doubleArray();
            }
            createSpace(newPosition);
            arr[newPosition - 1] = newEntry;
            length++;
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;

        //the number enter by user must between 1 and the length of the array list
        if ((givenPosition >= 1) && (givenPosition <= length)) {
            result = arr[givenPosition - 1];

            //shift the existing entries if the entry removed is not located at the last entry
            if (givenPosition < length) {
                removeGap(givenPosition);
            }
            //length should minus 1 after removing a entry
            length--;
        }
        return result;
    }

    @Override
    //remove the given entry from the array list
    public boolean remove(T newEntry) {
        boolean trueFalse = false;

        //if the array list is not empty
        if (!isEmpty()) {
            for (int i = 0; i < length; i++) {
                if (arr[i].equals(newEntry)) { //compare the given entry and every entry in the array list,
                    // if true then go in and remove the given entry                       
                    removeGap(i);
                    trueFalse = true;
                    length--;
                }
            }
        }

        return trueFalse;
    }

    @Override
    //remove the space where the entry at the given position has been removed
    public void removeGap(int givenPosition) {
        int removedIndex = givenPosition;
        int lastIndex = length - 1;

        //move the entry at the higher position to the position where the entry has been removed.
        //stop when all the entries had been moved to the lower position to remove the gap.
        for (int index = removedIndex; index < lastIndex; index++) {
            arr[index] = arr[index + 1];
        }
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isReplaced = true;

        if ((givenPosition >= 1) && (givenPosition <= length)) {
            //-1 because the givenPosition will only start with 1, not like index of array list that start with 0. 
            arr[givenPosition - 1] = newEntry;
        } else {
            isReplaced = false;
        }
        return isReplaced;
    }

    @Override
    //get the entry by entering the position of the particular element
    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= length)) {
            result = arr[givenPosition - 1];
        }
        return result;
    }

    @Override
    //get the position of the element by entring the entry 
    public int getPosition(T entry) {
        int foundIndex = 0;

        for (int i = 0; i < length; i++) {
            //compare the given entry and every element in the array list
            if (entry.equals(arr[i])) {
                foundIndex = i;
            }
        }
        return foundIndex;
    }

    @Override
    //double the size of array
    public void doubleArray() {
        //assign the existing arr to oldArray
        T[] oldArray = arr;

        arr = (T[]) new Object[oldArray.length * 2];
        //times 2 to double the oldArray and assigned to arr

        //move the element of oldArray to arr
        for (int i = 0; i < length; i++) {
            arr[i] = oldArray[i];
        }
    }

    @Override
    //check the array list whether contain the entry or not
    public boolean contains(T entry) {
        boolean found = false;

        //!found = true and index should smaller than the length of array list
        for (int index = 0; !found && (index < length); index++) {
            if (entry.equals(arr[index])) {
                found = true;
            }
        }
        return found;
    }

    @Override
    /*trim the length of the existing array list 
    to be the same with the existing entries in the list*/
    public void trimLength() {

        //compare the length of number entries and current array list
        if (length != arr.length) {
            T[] newArr = arr;
            arr = (T[]) new Object[newArr.length];

            for (int i = 0; i < length; i++) {
                arr[i] = newArr[i];
            }
        }

    }

    @Override
    public boolean isArrayFull() {
        return length == arr.length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void clear() {
        length = 0;
    }

    @Override
    public String toString() {
        String str = "";
        for (int index = 0; index < length; ++index) {
            str += arr[index] + "\n";
        }

        return str;
    }

    @Override
    public void createSpace(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = length - 1;

        // move each entry to next higher index
        //stop when the entry at newIndex has been moved (= position of newIndex is empty)
        for (int index = lastIndex; index >= newIndex; index--) {
            arr[index + 1] = arr[index];
        }
    }

}
