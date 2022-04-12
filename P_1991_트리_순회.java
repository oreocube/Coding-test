import java.io.*;
import java.util.*;

public class P_1991_트리_순회 {
    static StringBuilder sb = new StringBuilder();
    static Node[] tree;
    static int point = -18;

    static void preorder(int x) {
        sb.append((char) (x + 'A' - 1));
        if (tree[x].left != point) preorder(tree[x].left);
        if (tree[x].right != point) preorder(tree[x].right);
    }

    static void inorder(int x) {
        if (tree[x].left != point) inorder(tree[x].left);
        sb.append((char) (x + 'A' - 1));
        if (tree[x].right != point) inorder(tree[x].right);
    }

    static void postorder(int x) {
        if (tree[x].left != point) postorder(tree[x].left);
        if (tree[x].right != point) postorder(tree[x].right);
        sb.append((char) (x + 'A' - 1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int index = st.nextToken().charAt(0) - 'A' + 1;
            int left = st.nextToken().charAt(0) - 'A' + 1;
            int right = st.nextToken().charAt(0) - 'A' + 1;
            tree[index] = new Node(left, right);
        }

        preorder(1);
        sb.append('\n');
        inorder(1);
        sb.append('\n');
        postorder(1);
        System.out.println(sb);
    }

    static class Node {
        int left, right;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}


