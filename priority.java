public class priority<Item>{
    private int[] priority;
    private Item[] a;
    private int n;

    public priority() {a = (Item[]) new Object[100];priority = new int[100];n = 0;}

    public void enqueue(Item item, int pri) {
        //check the priority of the item to place it in the right place
        int i = 0;
        
        // while (i < n && pri > priority[i]) i++; change the search method to binary search
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (pri > priority[mid]) lo = mid + 1;
            else if (pri < priority[mid]) hi = mid - 1;
            else {
                i = mid;
                break;
            }
        }

        for (int j = n; j > i; j--) {
            priority[j] = priority[j - 1];
            a[j] = a[j - 1];
        }
        priority[i] = pri;
        a[i] = item;
        n++;
    }

    public Item dequeue() {return a[--n];}
    public boolean isEmpty() {return n == 0;}

    public static void main(String[] args) {
        priority<String> s = new priority<String>();
        s.enqueue("a", 1);
        s.enqueue("b", 3);
        s.enqueue("c", 2);
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
    }
    
}

// change it to decrease priority queue and dequeue the first one, it's structure should be like the queue.java, but with priority

// public class priority<Item>{
//     private Item[] prItems;
//     private int[] priority;
//     private int head;
//     private int tail;
//     private int n;
//     private int size;

//     public priority(int si) {prItems = (Item[]) new Object[si];priority = new int[si];head = 0;tail = -1;n = 0;}
//     public priority() {prItems = (Item[]) new Object[4];priority = new int[4];head = 0;tail = -1;n = 0;size=4;}

//     public int index(int i) {
//         int t = i;
//         t = t + head;
//         if (t > size - 1) return t - size;
//         else return t;
//     }

//     public void enqueue(Item item, int pri) {
//         //check the priority of the item to place it in the right place
//         int i = 0;
//         while (i < n && pri < priority[index(i)]) i++;
//         // System.out.println(i);
//         for (int j = n; j > i; j--) {
//             int temp = index(j);
//             int temp1 = index(j - 1);
//             priority[temp] = priority[temp1];
//             prItems[temp] = prItems[temp1];
//         // System.out.println();
//         }
//         priority[index(i)] = pri;
//         prItems[index(i)] = item;
//         n++;
//         this.tail=index(n-1);
//         // print out all the queue
//         for (int k = 0; k < n; k++) {
//             System.out.print(prItems[index(k)]);
//             System.out.print(" ");
//         }
//         System.out.println();
//     }



//     public Item dequeue() {
//         //raise empty queue exception if empty queue
//         if (isEmpty()) throw new RuntimeException("Queue underflow");
//         Item item = prItems[head];
//         priority[head] = 0;
//         head = index(1);
//         n--;
//         //print out all the queue
//         for (int k = 0; k < n; k++) {
//             System.out.print(prItems[index(k)]);
//             System.out.print(" ");
//         }
//         System.out.println();
//         return item;
//     }
//     public int size() {return n;}

//     public boolean isEmpty() {return n == 0;}

//     public static void main(String[] args) {
//         priority<String> s = new priority<String>();
//         s.enqueue("a", 11);
//         s.enqueue("b", 21);
//         s.enqueue("c", 12);
//         s.enqueue("d", 12);
//         s.dequeue();
//         s.dequeue();
//         s.dequeue();
//         s.enqueue("e", 33);
//         s.enqueue("f", 22);
//         s.dequeue();
//         s.enqueue("g", 11);
//         s.dequeue();
//         s.enqueue("h", 2);
//         s.enqueue("i", 20);
//         s.dequeue();       
//         s.dequeue();
//         s.dequeue();
//         s.dequeue();
//     }

// }