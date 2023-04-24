import org.example.Node;
import org.example.TreeBuilder;
import org.junit.Assert;
import org.junit.Test;

public class TreeBuilderTest {
    @Test
    public void constructTreeWithValidInput(){
        int[][] inputArr = new int[4][2];
        inputArr[0][0] = 4;
        inputArr[0][1] = 5;
        inputArr[1][0] = 5;
        inputArr[1][1] = 3;
        inputArr[2][0] = 1;
        inputArr[2][1] = 5;
        inputArr[3][0] = 2;
        inputArr[3][1] = 5;
        Node root = new Node(1);
        Node child = new Node(5);
        child.addChild(new Node(4));
        child.addChild(new Node(3));
        child.addChild(new Node(2));
        root.addChild(child);
        Assert.assertEquals(root, TreeBuilder.constructTree(inputArr));
    }

    @Test
    public void constructTreeWithValidInput2(){
        int[][] inputArr = new int[3][2];
        inputArr[0][0] = 4;
        inputArr[0][1] = 3;
        inputArr[1][0] = 5;
        inputArr[1][1] = 1;
        inputArr[2][0] = 5;
        inputArr[2][1] = 3;

        Node root = new Node(1);
        Node child = new Node(5);
        Node child2 = new Node(3);
        child2.addChild(new Node(4));
        child.addChild(child2);
        root.addChild(child);
        Assert.assertEquals(root, TreeBuilder.constructTree(inputArr));
    }

    @Test
    public void constructTreeWithValidInput1(){
        int[][] inputArr = new int[4][2];
        inputArr[0][0] = 2;
        inputArr[0][1] = 1;
        inputArr[1][0] = 3;
        inputArr[1][1] = 5;
        inputArr[2][0] = 1;
        inputArr[2][1] = 4;
        inputArr[3][0] = 1;
        inputArr[3][1] = 3;
        Node root = new Node(1);
        root.addChild(new Node(2));
        root.addChild(new Node(4));
        Node child = new Node(3);
        child.addChild(new Node(5));
        root.addChild(child);
        Assert.assertEquals(root, TreeBuilder.constructTree(inputArr));
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputArrayIsNull(){
        TreeBuilder.constructTree(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputArrayIsEmpty(){
        int[][] inputArr = {};
        TreeBuilder.constructTree(inputArr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rootNodeIsNotPresent(){
        int[][] inputArr = new int[2][2];
        inputArr[0][0] = 4;
        inputArr[0][1] = 5;
        inputArr[1][0] = 5;
        inputArr[1][1] = 3;
        TreeBuilder.constructTree(inputArr);
    }
}
