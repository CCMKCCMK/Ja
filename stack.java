// public class stack {
//     private char[] stackArray;
//     private int top;
//     private int maxSize;

//     public stack(int s) {
//         maxSize = s;
//         stackArray = new char[maxSize];
//         top = -1;
//     }

//     public void push(char j) {
//         stackArray[++top] = j;
//     }

//     public char pop() {
//         return stackArray[top--];
//     }


//     public boolean isEmpty() {
//         return (top == -1);
//     }

//     public int size() {
//         return top + 1;
//     }

//     public static void main(String[] args) {
//         //operator
//         stack s = new stack(100);
//         s.push('+');
//         s.push('-');
//         s.push('*');
//         System.out.println(s.pop());
//         System.out.println(s.pop());
//         System.out.println(s.pop());
//         //number
//         stack s1 = new stack(100);
//         s1.push('1');
//         s1.push('2');
//         s1.push('3');
//         System.out.println(s1.pop());
//         System.out.println(s1.pop());
//         System.out.println(s1.pop());
        
//     }
    
// }

// Path: stack.java
// This is base on linked list
// public class stack {
//     private Node first;
//     private int n;

//     private class Node {
//         char item;
//         Node last;
//     }

//     public stack() {
//         first = null;
//         n = 0;
//     }

//     public boolean isEmpty() {
//         return first == null;
//     }

//     public void push(char item) {
//         Node oldfirst = first;
//         first = new Node();
//         first.item = item;
//         first.last = oldfirst;
//         n++;
//     }

//     public char pop() {
//         char item = first.item;
//         first = first.last;
//         n--;
//         return item;
//     }

//     public char peek() {
//         return first.item;
//     }

//     public int size() {
//         return n;
//     }

//     public static void main(String[] args) {
//         LinkedStack s = new LinkedStack();
//         s.push('a');
//         s.push('b');
//         s.push('c');
//         System.out.println(s.pop());
//         System.out.println(s.pop());
//         System.out.println(s.pop());
//     }

// }

// change this to make it generic

// public class stack<Item> {

//     private Node first;
//     private int n;

//     private class Node {
//         Item item;
//         Node last;
//     }

//     public stack() {
//         first = null;
//         n = 0;
//     }

//     public boolean isEmpty() {
//         return first == null;
//     }

//     public void push(Item item) {
//         Node oldfirst = first;
//         first = new Node();
//         first.item = item;
//         first.last = oldfirst;
//         n++;
//     }

//     public Item pop() {
//         Item item = first.item;
//         first = first.last;
//         n--;
//         return item;
//     }

//     public Item peek() {
//         return first.item;
//     }

//     public int size() {
//         return n;
//     }

//     public static void main(String[] args) {
//         //string
//         stack<String> s = new stack<String>();
//         s.push("a");
//         s.push("b");
//         s.push("c");
//         System.out.println(s.pop());
//         System.out.println(s.pop());
//         System.out.println(s.pop());
//         //integer
//         stack<Integer> s1 = new stack<Integer>();
//         s1.push(1);
//         s1.push(2);
//         s1.push(3);
//         System.out.println(s1.pop());
//         System.out.println(s1.pop());
//         System.out.println(s1.pop());
        
//     }

// }


// change to arraylist

// import java.util.ArrayList;

// public class stack<Item> {
    
//         private ArrayList<Item> stackArray;
//         private int top;
    
//         public stack() {
//             stackArray = new ArrayList<Item>();
//             top = -1;
//         }
    
//         public void push(Item j) {
//             stackArray.add(j);
//             top++;
//         }
    
//         public Item pop() {
//             return stackArray.remove(top--);
//         }

//         public Item peek() {
//             return stackArray.get(top);
//         }

//         public boolean isEmpty() {
//             return (top == -1);
//         }

//         public int size() {
//             return top + 1;
//         }

//         public static void main(String[] args) {
//             //string
//             stack<String> s = new stack<String>();
//             s.push("a");
//             s.push("b");
//             s.push("c");
//             System.out.println(s.pop());
//             System.out.println(s.pop());
//             System.out.println(s.pop());
//             //integer
//             stack<Integer> s1 = new stack<Integer>();
//             s1.push(1);
//             s1.push(2);
//             s1.push(3);
//             System.out.println(s1.pop());
//             System.out.println(s1.pop());
//             System.out.println(s1.pop());
            
//         }

//     }

// use resize method to make it more efficient

public class stack<Item> {
    
    private Item[] stackArray;
    private int top;
    private int initSize;

    public stack() {
        initSize = 256;
        stackArray = (Item[]) new Object[initSize];
        top = -1;
    }

    public stack(int size) {
        initSize = size;
        stackArray = (Item[]) new Object[initSize];
        top = -1;
    }

    public void push(Item j) {
        if (top == initSize - 1) resize(2 * initSize);
        stackArray[++top] = j;
    }

    public Item pop() {
        Item item = stackArray[top--];
        if (top == initSize / 4) resize(initSize / 2);
        return item;
    }

    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < top; i++) temp[i] = stackArray[i];
        stackArray = temp;
        initSize = max;
    }

    public boolean isEmpty() {return (top == -1);}
    public int size() {return top + 1;}

    public static void main(String[] args) {
        //string
        stack<String> s = new stack<String>();
        s.push("a");
        s.push("b");
        s.push("c");
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        //integer
        stack<Integer> s1 = new stack<Integer>(10);
        s1.push(1);
        s1.push(2);
        s1.push(3);
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        
    }

}