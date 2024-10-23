public class SortingTest {
    public static void main(String[] args) {
        int[] sampleArray = {64, 25, 12, 22, 11};  // You can change this to test different sizes

        // Create copies of the sampleArray for each sorting method
        int[] bubbleArray = sampleArray.clone();
        int[] insertionArray = sampleArray.clone();
        int[] selectionArray = sampleArray.clone();

        // Measure time for Bubble Sort
        long startBubble = System.nanoTime();
        SortingAlgorithms.bubbleSort(bubbleArray);
        long endBubble = System.nanoTime();
        System.out.println("Bubble Sort took " + (endBubble - startBubble) + " ns");

        // Measure time for Insertion Sort
        long startInsertion = System.nanoTime();
        SortingAlgorithms.insertionSort(insertionArray);
        long endInsertion = System.nanoTime();
        System.out.println("Insertion Sort took " + (endInsertion - startInsertion) + " ns");
       
        // Measure time for Selection Sort
        long startSelection = System.nanoTime();
        SortingAlgorithms.selectionSort(selectionArray);
        long endSelection = System.nanoTime();
        System.out.println("Selection Sort took " + (endSelection - startSelection) + " ns");
    }
}