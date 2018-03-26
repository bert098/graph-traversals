
public class Vector  {

    protected Object[] items;
    protected int arraySize;
    protected int maxCap;

    public Vector (int initialCapacity) {
        
        this.items = new Object[initialCapacity];
        this.arraySize = 0;
        this.maxCap = initialCapacity;
    }

    public Vector() {
        this(10);
    }

    public void append(Object element) {
        int newArraySize = arraySize + 1;
        if(maxCap == newArraySize) {
            items = increaseCap(newArraySize);
            items[arraySize] = element;
            arraySize += 1;
        } else {
            items[arraySize] = element;
            arraySize +=1;
        }
    }
    @Override
    public String toString() {
        String output = "[";
        for(int i = 0; i < arraySize; i++) {
            output += items[i] + ", ";
        }
        output += "]";
        return output;
    }
    public void clear() {
        for(int i = 0; i < arraySize; i++) {
            items[i] = null;
            arraySize = 0;
        }
    }

    public Object elementAt(int index) {
        if(arraySize >= index) {
            return items[index];
        } else {
            Object temp = null;
            System.out.println("No index of " + index);
            return temp; 
        }
    }
    public Object indexOf(Object element) {
        Object index = "No value found";
        for(int i = 0; i < arraySize; i++) {
            if(element == items[i]) {
                index = i;
                break;        
            } 
        }
        return index;
    }
    public boolean isEmpty() {
        if(arraySize == 0) {
            return true;
        }
        return false;
    }
  
    public int size() {
        return arraySize;
    }
  
    public void ensureCapacity(int minCapacity) {
        if(minCapacity > items.length) {
            items = increaseCap(minCapacity);
        }
    }
    public Object[] increaseCap(int minCap) {
        Object[] arr1 = new Object[minCap * 2];
        for(int i = 0; i < minCap; i++) {
            arr1[i] = items[i];
        }
        maxCap = maxCap * 2;
        return arr1;
    }
  
    public boolean checkIndex(int index) {
        boolean check = false;
        if(index < arraySize) {
            check = true;
        }
        return check;
    }
    public void removeAt(int index) {
        if(true == this.checkIndex(index)) {
            Object[] temp = new Object[this.arraySize - 1];
            for(int j = 0; j < index; j++) {
                temp[j] = items[j];
            }
            for(int j = index + 1; j < arraySize; j++) {
                temp[j-1] = items[j];
            }
            items = temp;
            arraySize = arraySize - 1;
        }
    }
    public void insertAt(int index, Object element) {
        if (this.checkIndex(index) == true) {
            Object[] temp = new Object[arraySize];
            for(int i = index; i < arraySize; i++) {
                temp[i+1] = items[i];
            }
             items[index] = element;
            for (int i = index + 1; i < arraySize; i++) {
                items[i] = temp[i - 1];
            }
            arraySize = arraySize - 1;
        }
    }
    public void remove(Object element) {
        for(int i = 0; i < items.length; i++) {
            if(items[i] == element) {
                this.removeAt(i);
            }
        }
    }
    
  
}
