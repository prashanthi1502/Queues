import java.util.Scanner;

class PriorityQueue {
    private int[] queue;
    private int size;
    private int capacity;

    // Constructor to initialize the priority queue
    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.queue = new int[capacity];
    }

    public void insert(int element) {
        if (size == capacity) {
            System.out.println("Priority Queue is full.");
            return;
        }

        queue[size] = element;
        size++;

        sortQueue();
    }

    public int remove() {
        if (size == 0) {
            System.out.println("Priority Queue is empty.");
            return -1;
        }

        int removedElement = queue[0];
        for (int i = 1; i < size; i++) {
            queue[i - 1] = queue[i];
        }

        size--;
        return removedElement;
    }


    public int peek() {
        if (size == 0) {
            System.out.println("Priority Queue is empty.");
            return -1;
        }
        return queue[0];
    }

    private void sortQueue() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (queue[i] < queue[j]) {

                    int temp = queue[i];
                    queue[i] = queue[j];
                    queue[j] = temp;
                }
            }
        }
    }


    public void display() {
        if (size == 0) {
            System.out.println("Priority Queue is empty.");
            return;
        }

        System.out.print("Priority Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue pq = new PriorityQueue(10);

        while (true) {
            System.out.println("\nPriority Queue Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Remove (dequeue)");
            System.out.println("3. Peek (view max element)");
            System.out.println("4. Display Queue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int element = scanner.nextInt();
                    pq.insert(element);
                    break;
                case 2:
                    int removedElement = pq.remove();
                    if (removedElement != -1) {
                        System.out.println("Removed element: " + removedElement);
                    }
                    break;
                case 3:
                    int peekElement = pq.peek();
                    if (peekElement != -1) {
                        System.out.println("Max element: " + peekElement);
                    }
                    break;
                case 4:
                    pq.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}