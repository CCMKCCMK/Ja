public class queue<Item> {
    private Item[] a;
    private int head;
    private int tail;
    private int n;

    public queue() {a = (Item[]) new Object[2];head = 0;tail = -1;n = 0;}
    public boolean isEmpty() {return n == 0;}
    public boolean isFull() {return n == a.length;}
    public void enqueue(Item item) {
    //raise full queue exception if full queue
        if (isFull()) throw new RuntimeException("Queue overflow");
        if (tail == a.length - 1) tail = -1;
        a[++tail] = item;
        n++;
    }
    public Item dequeue() {
    //raise empty queue exception if empty queue
        if (isEmpty()) throw new RuntimeException("Queue underflow");
        Item item = a[head++];
        if (head == a.length) head = 0;
        n--;
        return item;
    }
    public int size() {return n;}
    public static void main(String[] args) {
        queue<String> s = new queue<String>();
        s.enqueue("a");
        s.enqueue("b");
        System.out.println(s.dequeue());
        s.enqueue("c");
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
    }
}
