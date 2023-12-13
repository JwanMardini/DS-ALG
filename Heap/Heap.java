package Heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap(){
        this.heap = new ArrayList<>();
    
    }

    public List<Integer> getHeap(){
        return new ArrayList<>(heap); // return a copy of the heap, because we don't want to change the original heap, 
                                        // we want to change the copy of the heap, so we can use the heap again, 
                                        // and we can use the original heap again

    }

    public void insert(int value){
        heap.add(value);
        int current = heap.size() - 1; // the index of the last element
        while (current > 0 && heap.get(current) > heap.get(parentIndex(current))) { // if the current value is greater than the parent value
            swap(current, parentIndex(current));
            current = parentIndex(current); 
        }
    }

    public Integer remove() {
        if(heap.size() == 0) return null;
        if(heap.size() == 1) return heap.remove(0);
        int maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1)); // set the first element to the last element, and remove the last element
        sinkDown(0);
        return maxValue;
    }

    private void sinkDown(int index){
        int maxIndex = index; // the index of the max value
        while(true){
            int leftChildIndex = leftChildIndex(index);
            int rightChildIndex = rightChildIndex(index);

            if(leftChildIndex < heap.size() && heap.get(leftChildIndex) > heap.get(maxIndex)){ // if the left child value is greater than the max value
                maxIndex = leftChildIndex;
            }
            if(rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(maxIndex)){ // if the right child value is greater than the max value
                maxIndex = rightChildIndex;
            }
            if (maxIndex != index){  // if the max value is not the current value, 
                swap(index, maxIndex);
                index = maxIndex;
            }else{
                return;
            }

        }
       
    }


    private int leftChildIndex(int index){
        return 2 * index + 1;
    }

    private int rightChildIndex(int index){
        return 2 * index + 2;
    }

    private int parentIndex(int index){
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2){ // swap the value of the two indexes
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(95);
        heap.insert(75);
        heap.insert(80);
        heap.insert(55);
        heap.insert(60);
        heap.insert(50);
        heap.insert(65);

        System.out.println(heap.getHeap());

        heap.remove();

        System.out.println(heap.getHeap());

        heap.remove();

        System.out.println(heap.getHeap());
    }

    /*
    Big O and Time Complexity of Heap:
    very effective for priority queue, because its always balanced and complete
    Hight of the tree is log(n), so insertion and removal is O(log(n))
     */
    
}
