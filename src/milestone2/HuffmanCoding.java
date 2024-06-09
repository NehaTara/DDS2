package milestone2;
import java.util.Scanner;

public class HuffmanCoding {
    private CustomQueue queue1;
    private CustomQueue queue2;
    private CustomHashMap huffmanCodes;
    private Node root;

    public HuffmanCoding(int capacity) {
        this.queue1 = new CustomQueue(capacity);
        this.queue2 = new CustomQueue(capacity);
        this.huffmanCodes = new CustomHashMap(capacity);
    }

    public void buildTree(CustomHashMap frequencyMap) {
        for (char key : frequencyMap.keys()) {
            queue1.enqueue(new Node(key, Integer.parseInt(frequencyMap.get(key))));
        }

        while (queue1.getSize() + queue2.getSize() > 1) {
            Node left = removeMin();
            Node right = removeMin();
            Node newNode = new Node(left.frequency + right.frequency, left, right);
            queue2.enqueue(newNode);
        }

        root = removeMin();
        generateCodesRecursive(root, "");
    }

    private Node removeMin() {
        if (queue1.isEmpty()) {
            return queue2.dequeue();
        }
        if (queue2.isEmpty()) {
            return queue1.dequeue();
        }
        if (queue1.peek().frequency < queue2.peek().frequency) {
            return queue1.dequeue();
        } else {
            return queue2.dequeue();
        }
    }

    private void generateCodesRecursive(Node node, String code) {
        if (node.character != '\0') {
            huffmanCodes.put(node.character, code);
        } else {
            generateCodesRecursive(node.left, code + "0");
            generateCodesRecursive(node.right, code + "1");
        }
    }

    public String encode(String input) {
        StringBuilder encodedString = new StringBuilder();
        for (char c : input.toCharArray()) {
            encodedString.append(huffmanCodes.get(c));
        }
        return encodedString.toString();
    }

    public String decode(String encodedString) {
        StringBuilder decodedString = new StringBuilder();
        Node currentNode = root;
        for (char bit : encodedString.toCharArray()) {
            currentNode = (bit == '0') ? currentNode.left : currentNode.right;
            if (currentNode.character != '\0') {
                decodedString.append(currentNode.character);
                currentNode = root;
            }
        }
        return decodedString.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to encode:");
        String input = scanner.nextLine();

        CustomHashMap frequencyMap = new CustomHashMap(100);
        for (char c : input.toCharArray()) {
            String frequency = frequencyMap.get(c);
            if (frequency == null) {
                frequencyMap.put(c, "1");
            } else {
                frequencyMap.put(c, Integer.toString(Integer.parseInt(frequency) + 1));
            }
        }

        HuffmanCoding huffmanCoding = new HuffmanCoding(100);
        huffmanCoding.buildTree(frequencyMap);

        String encodedString = "";

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Show Huffman Codes");
            System.out.println("2. Encode String");
            System.out.println("3. Decode String");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    for (char key : frequencyMap.keys()) {
                        System.out.println(key + ": " + huffmanCoding.huffmanCodes.get(key));
                    }
                    break;
                case 2:
                    encodedString = huffmanCoding.encode(input);
                    System.out.println("Encoded string: " + encodedString);
                    break;
                case 3:
                    if (encodedString.isEmpty()) {
                        System.out.println("Please encode the string first.");
                    } else {
                        System.out.println("Decoded string: " + huffmanCoding.decode(encodedString));
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
