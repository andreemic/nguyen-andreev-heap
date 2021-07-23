import java.util.ArrayList;
import java.util.List;

public class NguyenAndreevHeap {
    private List<Integer> elements;

    private int numberElements;
    public NguyenAndreevHeap() {
        elements = new ArrayList<Integer>();
        numberElements = 0;
    }

    public int min() {
        return elements.get(0);
    }

    public void insert(int value) {
        elements.add(value);
        numberElements++;

        siftUp(numberElements - 1);
    }

    private int getLeftChildIndex(int elementIndex) {
        int idx = elementIndex * 2 + 1;
        if (idx < numberElements)
            return idx;
        else
            return -1;
    }

    private int getRightChildIndex(int elementIndex) {
        int idx = elementIndex * 2 + 2;
        if (idx < numberElements)
            return idx;
        else
            return -1;

    }

    private int getParentIndex(int elementIndex) {
        if (elementIndex == 0) return -1;

        return (int) Math.floor((elementIndex - 1) >> 1);
    }

    private void siftDown(int elementIndex) {
        int leftChildIndex = getLeftChildIndex(elementIndex);
        int rightChildIndex = getRightChildIndex(elementIndex);
        if (leftChildIndex == -1 && rightChildIndex == -1)
            return;


        int minChildIndex;
        int leftValue = Integer.MAX_VALUE;
        if (leftChildIndex > -1)
            leftValue = elements.get(leftChildIndex);
        int rightValue = Integer.MAX_VALUE;
        if (rightChildIndex > -1)
            rightValue = elements.get(rightChildIndex);

        if (leftValue < rightValue) {
            minChildIndex = leftChildIndex;
        } else {
            minChildIndex = rightChildIndex;
        }

        int myValue = elements.get(elementIndex);
        int minChildValue = elements.get(minChildIndex);
        if (myValue > minChildValue) {
            elements.set(minChildIndex, myValue);
            elements.set(elementIndex, minChildValue);
            siftDown(minChildIndex);
        }
    }

    private void siftUp(int elementIndex) {
        int parentIndex = getParentIndex(elementIndex);
        if (parentIndex == -1)
            return;

        int myValue = elements.get(elementIndex);
        int parentValue = elements.get(parentIndex);
        if (myValue < parentValue) {
            elements.set(parentIndex, myValue);
            elements.set(elementIndex, parentValue);
            siftUp(parentIndex);
        }
    }

    public int deleteMin() {
        int min = min();

        int lastValue = elements.get(numberElements - 1);
        elements.remove(numberElements - 1);
        numberElements--;

        elements.set(0, lastValue);
        siftDown(0);
        return min;
    }


    public static void main(String[] args) {
        NguyenAndreevHeap heap = new NguyenAndreevHeap();

        heap.insert(23);
        heap.insert(24);
        heap.insert(25);
        heap.insert(1);

        System.out.println(heap.elements);
        System.out.println(heap.deleteMin());

        System.out.println(heap.elements);

        System.out.println(heap.min());

    }


}
