

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static class Node {
		char root;
		Node left;
		Node right;

		Node(char root) {
			this.root = root;
		}
	}

	static Node nodeTree;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().replaceAll(" ", "").toCharArray();
			createNode(input[0], input[1], input[2]);
		}

		preorder(nodeTree);
		sb.append('\n');
		inorder(nodeTree);
		sb.append('\n');
		postorder(nodeTree);

		System.out.print(sb);
	}

	static void createNode(char root, char left, char right) {
		if (nodeTree == null) {
			nodeTree = new Node(root);
			if (left != '.')
				nodeTree.left = new Node(left);
			if (right != '.')
				nodeTree.right = new Node(right);
		} else {
			searchNode(nodeTree, root, left, right);
		}
	}

	static void searchNode(Node node, char root, char left, char right) {
		if (node == null)
			return;

		if (node.root == root) {
			if (left != '.')
				node.left = new Node(left);
			if (right != '.')
				node.right = new Node(right);
		} else {
			searchNode(node.left, root, left, right);
			searchNode(node.right, root, left, right);
		}
	}

	static void preorder(Node node) {
		if (node == null)
			return;
		sb.append(node.root);
		preorder(node.left);
		preorder(node.right);
	}

	static void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		sb.append(node.root);
		inorder(node.right);
	}

	static void postorder(Node node) {
		if (node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		sb.append(node.root);
	}
}