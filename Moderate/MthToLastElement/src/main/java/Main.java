import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                mthToLastIndex(fileLine);
            }
        }
    }

    private static void mthToLastIndex(String fileLine) {
        // little cheat for make it easier iterable. From the algo perspective doesn't matter
        String[] items = fileLine.split(" ");
        // let's create a simple LinkedList
        LinkedListItem<String> head = createLinkedListFrom(items);
        //
        int requiredItemIndexFromEnd = Integer.valueOf(items[items.length - 1]);
        //
        // I'm using the well-known O(N) algorithm with two iterations
        //
        LinkedListItem<String> first = head;
        int counter = requiredItemIndexFromEnd;
        while (counter-- > 1 && first.next() != null) {
            first = first.next();
        }
        // is the last Nth requirement is bigger than the list itself?
        if (counter > 0) {
            return;
        }
        // Ok we are in the right position, now let's go with the first until the end and follow it by the second.
        LinkedListItem<String> second = head;
        while (first.next() != null) {
            second = second.next();
            first = first.next();
        }
        //
        System.out.println(second.getValue());
    }

    private static LinkedListItem<String> createLinkedListFrom(String[] items) {
        LinkedListItem<String> result = null;
        //
        LinkedListItem<String> actual = null;
        // iterate until the last before position. I was lazy to create string comparison based
        // item reading, but try to imagine it :)
        for (int i = 0; i < items.length - 1; i++) {
            String item = items[i];
            if (result != null) {
                actual.setNext(new SimpleLinkedListItem<>(item));
                actual = actual.next();
            } else {
                result = new SimpleLinkedListItem<>(item);
                actual = result;
            }
        }
        return result;
    }

    /* ************************************************** */
    // Own definiton of  linkedlist to avoid usage of collections framework
    private static interface LinkedListItem<T> {

        LinkedListItem<T> next();

        void setNext(LinkedListItem<T> nextItem);

        T getValue();

    }

    // A simple implementation for the interface. "Simple" prefix is not the best one, but....
    public static class SimpleLinkedListItem<T> implements LinkedListItem<T> {

        private LinkedListItem<T> nextItem;
        private final T value;

        public SimpleLinkedListItem(T value) {
            this.value = value;
        }

        @Override
        public LinkedListItem<T> next() {
            return nextItem;
        }

        @Override
        public void setNext(LinkedListItem<T> nextItem) {
            this.nextItem = nextItem;
        }

        @Override
        public T getValue() {
            return value;
        }
    }
}
