import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    private T data;
    private List<TreeNode<T>> children;
    private TreeNode<T> parent;

    public TreeNode(TreeNode<T> parent, T data) {
        this.data = data;
        children = new ArrayList<TreeNode<T>>();
        this.parent = parent;
    }

    public void insert(T data) {
        children.add(new TreeNode<>(this, data));
    }

    private boolean isLeaf() {
        if (children.size() == 0) {
            return true;
        }

        return false;
    }

    public TreeNode getNode(T value) {
        TreeNode<T> returnNode = null;

        //check if current node contains value
        if (data.equals(value)) {
            returnNode = this;
        }

        //otherwise check children if not leaf
        else if (!isLeaf()) {
            int i = 0;

            //loop through children to check if children contain value
            while ((returnNode == null) && (i < children.size())) {
                returnNode = children.get(i).getNode(value);
                i++;
            }
        }

        //return first instance of value (pre-order traversal)
        return returnNode;
    }

    public void print(int level) {
        //if parent is not a leaf
        if (!this.equals(null)) {
            int midpoint = children.size() / 2;

            //spacing between levels
            String spacing = "";
            for (int i = 0; i < level; i++) {
                spacing += "   ";
            }

            //print right of middle
            for (int i = (children.size() - 1); i >= midpoint ; i--) {
                children.get(i).print(level + 1);
            }

            System.out.println(spacing + "[" + data + "]");

            //print left of middle
            for (int i = (midpoint - 1); i >= 0; i--) {
                children.get(i).print(level + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("testing basic tree node");

        TreeNode<Character> root = new TreeNode<>(null, 'a');
        System.out.println();

        root.insert('b');
        root.insert('d');
        root.insert('e');

        TreeNode<Character> inserter = root.getNode('e');
        inserter.insert('f');

        inserter = root.getNode('b');
        inserter.insert('c');
        inserter.insert('g');

        inserter = root.getNode('c');
        inserter.insert('h');
        inserter.insert('i');

        root.print(0);
    }
}