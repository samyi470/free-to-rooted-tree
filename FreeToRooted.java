import java.util.*;

public class FreeToRooted {
    public static TreeNode<Character> getRootedTree(boolean[][] adjMatrix) {
        TreeMap<Integer, Character> intCharMap = getIntCharMap();
        Queue<Character> nodes = new LinkedList<>();
        TreeNode<Character> root;

        //add first node to tree ('a')
        if (adjMatrix.length > 0) {
            root = new TreeNode<>(null, intCharMap.get(0));
        }
        else {
            root = null;
        }

        //loop through each row
        for (int i = 0; i < adjMatrix.length; i++) {
            //get char node associated with row
            char node = intCharMap.get(i);

            //loop through each col
            for (int j = 0; j < adjMatrix[i].length; j++) {
                //if there is a connection
                if (adjMatrix[i][j] == true) {
                    //add node into queue
                    nodes.add(intCharMap.get(j));
                }
            }

            //loop while row has connections
            while (!nodes.isEmpty()) {
                //if node doesn't exist in tree, add to current node
                char nextNode = nodes.remove();

                if (root.getNode(nextNode) == null) {
                    root.getNode(node).insert(nextNode);
                }
            }
        }

        return root;
    }

    public static TreeMap<Integer, Character> getIntCharMap() {
        TreeMap<Integer, Character> intCharMap = new TreeMap<>();
        int index = 0;

        for (char i = 'a'; i <= 'z'; i++) {
            intCharMap.put(index, i);
            index++;
        }

        return intCharMap;
    }

    public static boolean[][] getAdjMatrix() {
        boolean[][] adjMatrix = initializeAdjMatrix(9, 9);

        //set tree
        adjMatrix[0][1] = true;
        adjMatrix[0][3] = true;
        adjMatrix[0][4] = true;
        adjMatrix[1][0] = true;
        adjMatrix[1][2] = true;
        adjMatrix[1][6] = true;
        adjMatrix[2][1] = true;
        adjMatrix[2][7] = true;
        adjMatrix[2][8] = true;
        adjMatrix[3][0] = true;
        adjMatrix[4][0] = true;
        adjMatrix[4][5] = true;
        adjMatrix[5][4] = true;
        adjMatrix[6][1] = true;
        adjMatrix[7][2] = true;
        adjMatrix[8][2] = true;

        return adjMatrix;
    }

    public static boolean[][] getAdjMatrix1() {
        boolean[][] adjMatrix = initializeAdjMatrix(2, 2);

        adjMatrix[0][1] = true;
        adjMatrix[1][0] = true;

        return adjMatrix;
    }

    public static boolean[][] getAdjMatrix2() {
        boolean[][] adjMatrix = initializeAdjMatrix(11, 11);

        adjMatrix[0][1] = true;
        adjMatrix[0][2] = true;
        adjMatrix[0][3] = true;
        adjMatrix[1][0] = true;
        adjMatrix[1][4] = true;
        adjMatrix[1][5] = true;
        adjMatrix[1][6] = true;
        adjMatrix[2][0] = true;
        adjMatrix[3][0] = true;
        adjMatrix[3][8] = true;
        adjMatrix[3][9] = true;
        adjMatrix[3][10] = true;
        adjMatrix[4][1] = true;
        adjMatrix[5][1] = true;
        adjMatrix[6][1] = true;
        adjMatrix[8][3] = true;
        adjMatrix[9][3] = true;
        adjMatrix[10][3] = true;

        return adjMatrix;
    }

    private static boolean[][] initializeAdjMatrix(int row, int col) {
        boolean[][] adjMatrix = new boolean[row][col];

        //initialize to false
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                adjMatrix[i][j] = false;
            }
        }

        return adjMatrix;
    }

    public static void printMatrix(boolean[][] adjMatrix) {
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] == true) {
                    System.out.print("1 ");
                }
                else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("free tree 1 (adjacency matrix):");
        boolean[][] adjMatrix = getAdjMatrix();
        printMatrix(adjMatrix);
        System.out.println();

        TreeNode<Character> root = getRootedTree(adjMatrix);

        System.out.println("rooted tree 1:");
        root.print(0);
        System.out.println();
        System.out.println();


        System.out.println("free tree 2 (adjacency matrix):");
        adjMatrix = getAdjMatrix1();
        printMatrix(adjMatrix);
        System.out.println();

        root = getRootedTree(adjMatrix);

        System.out.println("rooted tree 2:");
        root.print(0);
        System.out.println();
        System.out.println();


        System.out.println("free tree 3 (adjacency matrix):");
        adjMatrix = getAdjMatrix2();
        printMatrix(adjMatrix);
        System.out.println();

        root = getRootedTree(adjMatrix);

        System.out.println("rooted tree 3:");
        root.print(0);
        System.out.println();
    }
}
