package club.huitu.ds.tree.binarytree;

import org.junit.Test;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

/**
 * @author hiutu
 * Created by huitu on 2019/9/20.
 */
public class BinaryTreeTest {


    @Test
    public void test() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        List<Integer> list = Arrays.asList(5, 3, 9, 8, 4, 2, 7, 0, null, 1, 6);

        printLine("insert");
        list.forEach(item -> tree.insert(item));
        tree.printAll(0);
        System.out.println();

        printLine("contains");
        list.forEach(item -> {
            System.out.println("contains[" + item + "]:" + tree.contains(item));
        });
        System.out.println("contains[" + 99 + "]:" + tree.contains(99));
        System.out.println();

        printLine("min/max");
        System.out.println(tree.findMin());
        System.out.println(tree.findMax());
        System.out.println();

        printLine("remove");
        tree.remove(7);
        tree.remove(8);
        tree.remove(11);
        tree.remove(3);
        tree.printAll(0);
        System.out.println();

    }


    private void printLine(String title) {
        String lineChars = "================================";
        System.out.println(MessageFormat.format(lineChars + " {0} " + lineChars, title));
    }
    
}
