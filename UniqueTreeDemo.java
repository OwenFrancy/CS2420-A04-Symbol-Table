package a04_Tree;

import java.util.List;

/**
 * The {@code UniqueTreeDemo} class serves as a driver program to test and validate
 * the functionality of the {@link UniqueTree} class. It provides a sample tree structure
 * using a list of integer arrays, where each array represents a node and its left and
 * right child indices. This class ensures that the implemented methods in
 * {@link UniqueTree} work for arbitrary tree structures.
 *
 * <p>The provided tree structure uses the following format for each node:
 * <ul>
 *   <li>Element at index 0: The value of the node</li>
 *   <li>Element at index 1: The index of the left child in the list (or {@code null} if no left child)</li>
 *   <li>Element at index 2: The index of the right child in the list (or {@code null} if no right child)</li>
 * </ul>
 *
 * @author CS Starter Code + Ash Bullock + Owen Francy
 */
class UniqueTreeDemo {


    public static void main(String[] args) {
        // This is starter code to help you test your method implementations.
   	    // Ensure your code works for any tree structure, not just the provided example.

        List<Integer[]> treeData = List.of(
            new Integer[]{52, 1, 2}, // root: 52; left child: 23 (index 1) right child: 87 (index 2)
            new Integer[]{23, 3, 4},
            new Integer[]{87, 5, 6},
            new Integer[]{34, 7, 8},
            new Integer[]{45, 9, 10},
            new Integer[]{67, 11, null},
            new Integer[]{78, 12, 13},
            new Integer[]{12, null, null},
            new Integer[]{19, null, null},
            new Integer[]{33, 14, 15},
            new Integer[]{49, null, null},
            new Integer[]{56, null, null},
            new Integer[]{69, 16, null},
            new Integer[]{85, null, null},
            new Integer[]{62, null, null},
            new Integer[]{13, null, null},
            new Integer[]{24, null, null}
        );

        UniqueTree tree = new UniqueTree(treeData);

        List<Integer[]> leftTreeData = List.of(
        	new Integer[] {1,1,null},
        	new Integer[] {2,2,null},
        	new Integer[] {3,3,null},
        	new Integer[] {4,4,null},
        	new Integer[] {5,null,null}
        );

        UniqueTree leftTree = new UniqueTree(leftTreeData);

        List<Integer[]> rightTreeData = List.of(
        	new Integer[] {1,null,1},
        	new Integer[] {2,null,2},
        	new Integer[] {3,null,3},
        	new Integer[] {4,null,4},
        	new Integer[] {5,null,null}
        );

        UniqueTree rightTree = new UniqueTree(rightTreeData);

        int passes = 0;
        int fails = 0;

        {
        	int expected = 6;
        	int actual = tree.countLeafParents();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("countLeafParents()    expected: %d  actual: %d\n", expected, actual);
        }

        {
        	double expected = 49.0;
        	double actual = tree.averageOfOddNumbers();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("averageOfOddNumbers() expected: %f  actual: %f\n", expected, actual);
        }

        {
        	int expected = 376;
        	int actual = tree.sumOfRightChildren();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("sumOfRightChildren()  expected: %d  actual: %d\n", expected, actual);
        }

        {
        	int expected = 75;
        	int actual = tree.greatestDifference();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("greatestDifference()  expected: %d  actual: %d\n", expected, actual);
        }

        System.out.println("\ndoubleEvenNumbers()\n");
        tree.doubleEvenNumbers();

        {
        	int expected = 6;
        	int actual = tree.countLeafParents();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("countLeafParents()    expected: %d  actual: %d\n", expected, actual);
        }

        {
        	double expected = 49.0;
        	double actual = tree.averageOfOddNumbers();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("averageOfOddNumbers() expected: %f  actual: %f\n", expected, actual);
        }

        {
        	int expected = 454;
        	int actual = tree.sumOfRightChildren();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("sumOfRightChildren()  expected: %d  actual: %d\n", expected, actual);
        }

        {
        	int expected = 143;
        	int actual = tree.greatestDifference();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("greatestDifference()  expected: %d  actual: %d\n", expected, actual);
        }

        System.out.println("\nleftTree\n");

        {
        	int expected = 1;
        	int actual = leftTree.countLeafParents();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("countLeafParents()    expected: %d  actual: %d\n", expected, actual);
        }

        {
        	double expected = 3.0;
        	double actual = leftTree.averageOfOddNumbers();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("averageOfOddNumbers() expected: %f  actual: %f\n", expected, actual);
        }

        {
        	int expected = 0;
        	int actual = leftTree.sumOfRightChildren();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("sumOfRightChildren()  expected: %d  actual: %d\n", expected, actual);
        }

        {
        	int expected = 4;
        	int actual = leftTree.greatestDifference();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("greatestDifference()  expected: %d  actual: %d\n", expected, actual);
        }

        System.out.println("\ndoubleEvenNumbers()\n");
        leftTree.doubleEvenNumbers();

        {
        	int expected = 1;
        	int actual = leftTree.countLeafParents();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("countLeafParents()    expected: %d  actual: %d\n", expected, actual);
        }

        {
        	double expected = 3.0;
        	double actual = leftTree.averageOfOddNumbers();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("averageOfOddNumbers() expected: %f  actual: %f\n", expected, actual);
        }

        {
        	int expected = 0;
        	int actual = leftTree.sumOfRightChildren();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("sumOfRightChildren()  expected: %d  actual: %d\n", expected, actual);
        }

        {
        	int expected = 7;
        	int actual = leftTree.greatestDifference();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("greatestDifference()  expected: %d  actual: %d\n", expected, actual);
        }

        System.out.println("\nrightTree\n");

        {
        	int expected = 1;
        	int actual = rightTree.countLeafParents();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("countLeafParents()    expected: %d  actual: %d\n", expected, actual);
        }

        {
        	double expected = 3.0;
        	double actual = rightTree.averageOfOddNumbers();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("averageOfOddNumbers() expected: %f  actual: %f\n", expected, actual);
        }

        {
        	int expected = 14;
        	int actual = rightTree.sumOfRightChildren();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("sumOfRightChildren()  expected: %d  actual: %d\n", expected, actual);
        }

        {
        	int expected = 4;
        	int actual = rightTree.greatestDifference();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("greatestDifference()  expected: %d  actual: %d\n", expected, actual);
        }

        System.out.println("\ndoubleEvenNumbers()\n");
        rightTree.doubleEvenNumbers();

        {
        	int expected = 1;
        	int actual = rightTree.countLeafParents();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("countLeafParents()    expected: %d  actual: %d\n", expected, actual);
        }

        {
        	double expected = 3.0;
        	double actual = rightTree.averageOfOddNumbers();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("averageOfOddNumbers() expected: %f  actual: %f\n", expected, actual);
        }

        {
        	int expected = 20;
        	int actual = rightTree.sumOfRightChildren();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("sumOfRightChildren()  expected: %d  actual: %d\n", expected, actual);
        }

        {
        	int expected = 7;
        	int actual = rightTree.greatestDifference();
        	if (expected == actual) {
        		System.out.print(" P ");
        		++passes;
        	} else {
        		System.out.print(" F ");
        		++fails;
        	}
        	System.out.printf("greatestDifference()  expected: %d  actual: %d\n", expected, actual);
        }

        System.out.printf("\n%d Passed %d Failed\n", passes, fails);
    }
}
