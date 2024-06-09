package milestone1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        stackStructure stack = new stackStructure();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Website");
            System.out.println("2. Delete Last Website");
            System.out.println("3. Reverse website list");
            System.out.println("4. Display all websites");
            System.out.println("5. Display bookmarked websites");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Page Name: ");
                    String pageName = scanner.nextLine();
                    System.out.print("Enter Page ID: ");
                    String pageId = scanner.nextLine();
                    System.out.print("Enter Date: ");
                    String date = scanner.nextLine();
                    System.out.print("Enter Site URL: ");
                    String siteUrl = scanner.nextLine();
                    System.out.print("Enter Bookmark (Yes/No): ");
                    String bookmarkStr = scanner.nextLine();
                    boolean bookmark = bookmarkStr.equalsIgnoreCase("Yes");

                    node newNode = new node(pageName, pageId, date, siteUrl, bookmark);
                    stack.add(newNode);
                    break;

                case 2:
                    node poppedNode = stack.pop();
                    if (poppedNode != null) {
                        System.out.println("Popped Node: " + poppedNode);
                    }
                    break;

                case 3:
                    stack.reverse();
                    System.out.println("Stack reversed.");
                    break;

                case 4:
                    stack.display();
                    break;

                case 5:
                    stack.displayBookmarked();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }
}
