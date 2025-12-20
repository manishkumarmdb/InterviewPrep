package interview.asked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PrintTopElementFromIterators {

    public void printTopElementFromIterators(Iterator<Iterator<Integer>> iterators) {
        List<Iterator<Integer>> listIterator = new ArrayList<>();
        while (iterators.hasNext()) {
            listIterator.add(iterators.next());
        }
        printElements(listIterator);
    }

    public void printElements(List<Iterator<Integer>> iterators) {
        boolean hasNext = true;
        // Continue until no iterator has next element
        while (hasNext) {
            hasNext = false;

            for (Iterator<Integer> iterator : iterators) {
                if (iterator.hasNext()) {
                    System.out.print(iterator.next() + " ");
                    hasNext = true; // At least one iterator has a next element
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintTopElementFromIterators obj = new PrintTopElementFromIterators();
        List<Iterator<Integer>> listIterator = new ArrayList<>();

        listIterator.add(Arrays.asList(1, 2, 3).iterator());
        listIterator.add(Arrays.asList(4, 5).iterator());
        listIterator.add(Arrays.asList(6, 7, 8, 9).iterator());
        //listIterator.add(Arrays.asList(10, 11, 8, 19, 5).iterator());

        Iterator<Iterator<Integer>> iterators = listIterator.iterator();

        obj.printTopElementFromIterators(iterators);
        obj.printElements(listIterator);
    }
}
