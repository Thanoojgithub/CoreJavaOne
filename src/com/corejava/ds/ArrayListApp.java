package com.corejava.ds;

import java.util.Arrays;

public class ArrayListApp {

	public static void main(String[] args) {
		MyList<Integer> myList = new MyList<Integer>();
		myList.add(10);
		myList.add(1,11);
		myList.get(0);
		System.out.println(myList.get(0) + " | "+myList.get(1));
		/*
		 * OUTPUT :
		 * 
		 * 10 | 11
		 */
	}

}
class MyList<E> {
	
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	private Object elements[];

	public MyList() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	public boolean add(E e) {
		if (size == elements.length) {
			ensureCapa();
		}
		elements[size++] = e;
		return true;
	}
	
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		if (size == elements.length) {
			ensureCapa();
		}

        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }
	
	private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

	@SuppressWarnings("unchecked")
	public E get(int index) {
		rangeCheck(index);
		return (E) elements[index];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++)
				if (elements[i] == null)
					return i;
		} else {
			for (int i = 0; i < size; i++)
				if (o.equals(elements[i]))
					return i;
		}
		return -1;
	}

	private void ensureCapa() {
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
	}

	private void rangeCheck(int index) {
		if (index >= size)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	private String outOfBoundsMsg(int index) {
		return "Index: " + index + ", Size: " + size;
	}
}