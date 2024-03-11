package skypro.algorithmshwp2;

import java.util.Arrays;

public class StringListImpl implements StringList{
    private final String[] strings;
    private int size;

    public StringListImpl() {
        strings = new String[5];
    }
    public StringListImpl(int size) {
        strings = new String[size];
    }

    @Override
    public String add(String item) {
        checkString(item);
        checkSize(size);
        this.strings[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkIndex(index);
        checkString(item);
        if (index == size) {
            this.strings[size++] = item;
            return item;
        }
        System.arraycopy(strings, index, strings, index + 1, size - index);
        this.strings[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkIndex(index);
        checkString(item);
        this.strings[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        checkString(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ItemNotFoundException();
        }
        System.arraycopy(strings, index + 1, strings, index, size - 1 - index);
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String item = strings[index];
        System.arraycopy(strings, index + 1, strings, index, size - 1 - index);
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        checkString(item);
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (strings[i].contains(item)) {
                index = i;
                return index;
            } else {
                index = -1;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(String item) {
        checkString(item);
        int index = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (strings[i].contains(item)) {
                index = i;
                return index;
            } else {
                index = -1;
            }
        }
        return index;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        String item = strings[index];
        return item;
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        Arrays.copyOf(strings, size);
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(strings, size);
    }

    private void checkString(String item) {
        if (item == null || item.isBlank()) {
            throw new NullArgumentException();
        }
    }
    private void checkSize(int size) {
        if (size == strings.length) {
            throw new SizeOutOfBoundException();
        }
    }
    private void checkIndex (int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundException();
        }
    }
}
