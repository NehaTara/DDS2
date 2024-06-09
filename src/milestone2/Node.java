package milestone2;
class Node {
    char character;
    int frequency;
    Node left;
    Node right;

    public Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    public Node(int frequency, Node left, Node right) {
        this.character = '\0';
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
}

