package milestone1;

public class stackStructure {
    private node top;

    public stackStructure() {
        this.top = null;
    }

    public void push(node node) {
        node.next = top;
        top = node;
    }

    public node pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        node temp = top;
        top = top.next;
        return temp;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void reverse() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        node prev = null;
        node current = top;
        node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        top = prev;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        node current = top;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public void displayBookmarked() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        node current = top;
        boolean found = false;
        while (current != null) {
            if (current.bookmark) {
                System.out.println(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No bookmarked sites.");
        }
    }
}
