import java.io.*;
import java.util.*;

public class P_5639_이진_검색_트리 {
    static StringBuilder sb = new StringBuilder();
    static Node root;

    static void insertNode(int x) {
        Node now = root;
        while (true) {
            if (x < now.value) {
                if (now.left == null) {
                    now.left = new Node(x);
                    return;
                }
                now = now.left;
            } else {
                if (now.right == null) {
                    now.right = new Node(x);
                    return;
                }
                now = now.right;
            }
        }
    }

    static void print(Node node) {
        if (node.left != null) print(node.left);
        if (node.right != null) print(node.right);
        sb.append(node.value).append('\n');
        if (node == root) System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        root = new Node(x);

        String input;
        while (true) {
            input = br.readLine();

            if (input == null || input.equals("")) break;

            insertNode(Integer.parseInt(input));
        }
        print(root);
    }
}

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
    }
}
