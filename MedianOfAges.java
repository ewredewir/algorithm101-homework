import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfAges {
    // 2 priority queues to store the lower half and the upper half
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianOfAges() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    // Inserting the number to the correct heap
    public void insertNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // Balancing the heaps according to their sizes to keep the median
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    // Finding the median
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianOfAges medianOfAges = new MedianOfAges();
        medianOfAges.insertNum(22);
        medianOfAges.insertNum(35);
        System.out.println("The recommended content will be for ages under: " + medianOfAges.findMedian());
        medianOfAges.insertNum(30);
        System.out.println("The recommended content will be for ages under: " + medianOfAges.findMedian());
        medianOfAges.insertNum(25);
        System.out.println("The recommended content will be for ages under: " + medianOfAges.findMedian());
    }
}
