/*

LeetCode 297: Serialize and Deserialize Binary Tree — Notes
Key Idea
Serialize: Convert a binary tree into a string.
Deserialize: Reconstruct the original tree from that string.
The serialization format can be anything as long as deserialization recreates the exact tree.
Approach: Preorder Traversal + Null Markers
Why Preorder?

Preorder visits nodes in the order:

Root → Left → Right

During serialization:

Store every node value.
Store "N" for every null child.

Example:

        1
       / \
      2   3
         / \
        4   5

Serialized string:

1,2,N,N,3,4,N,N,5,N,N
Why are Null Markers Needed?

Without nulls:

1,2,3,4,5

Multiple different trees can produce the same sequence.

Adding "N" preserves the exact structure.

Serialization Algorithm
If node is null
Append "N"
Return
Append node value.
Serialize left subtree.
Serialize right subtree.
Deserialization Algorithm

Maintain an index over the serialized values.

Read current value.
If "N"
Return null.
Create a node.
Recursively build left subtree.
Recursively build right subtree.
Return the node.


| Operation   | Time | Space |
| ----------- | ---- | ----- |
| Serialize   | O(n) | O(n)  |
| Deserialize | O(n) | O(n)  |

where n = number of nodes.
*/
import java.util.*;

public class Codec {

    // -------------------- Serialize --------------------

    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);

        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {

        // Store null marker
        if (root == null) {
            sb.append("N,");
            return;
        }

        // Store current node
        sb.append(root.val).append(",");

        // Serialize left subtree
        serializeHelper(root.left, sb);

        // Serialize right subtree
        serializeHelper(root.right, sb);
    }

    // -------------------- Deserialize --------------------

    int index = 0;

    public TreeNode deserialize(String data) {

        String[] values = data.split(",");
        index = 0;

        return deserializeHelper(values);
    }

    private TreeNode deserializeHelper(String[] values) {

        // If current value is null marker
        if (values[index].equals("N")) {
            index++;
            return null;
        }

        // Create node
        TreeNode root = new TreeNode(Integer.parseInt(values[index]));
        index++;

        // Build left subtree
        root.left = deserializeHelper(values);

        // Build right subtree
        root.right = deserializeHelper(values);

        return root;
    }
    public static void main(String[] args) {

    /*
             1
            / \
           2   3
              / \
             4   5
    */

    TreeNode root = new TreeNode(1);

    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);

    Codec codec = new Codec();

    // Serialize the tree
    String serialized = codec.serialize(root);
    System.out.println("Serialized Tree:");
    System.out.println(serialized);

    // Deserialize the string back into a tree
    TreeNode deserializedRoot = codec.deserialize(serialized);

    // Serialize again to verify correctness
    String serializedAgain = codec.serialize(deserializedRoot);

    System.out.println("\nSerialized Again After Deserialization:");
    System.out.println(serializedAgain);

    // Verify both serialized strings are identical
    System.out.println("\nTrees are identical: " +
            serialized.equals(serializedAgain));
}
}