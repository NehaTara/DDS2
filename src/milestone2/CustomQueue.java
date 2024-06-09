package milestone2;
class CustomQueue {
    private Node[] elements;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CustomQueue(int capacity) {
        this.capacity = capacity;
        this.elements = new Node[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(Node node) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        elements[rear] = node;
        size++;
    }

    public Node dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        Node node = elements[front];
        front = (front + 1) % capacity;
        size--;
        return node;
    }

    public int getSize() {
        return size;
    }

    public Node peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
