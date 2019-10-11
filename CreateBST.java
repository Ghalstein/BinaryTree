/*
* Creates a BST from a sorted Array
* In order to do this will have to cut the array in half to find the middle
* root element -- then branch off accordingly from each side
* From here the objective is to add the elements in a binary pattern
* Have to first add middle then right and left middles to that middle node
* until all nodes are complete
*/

public class CreateBST {

  public class ListNode {
    int value;
    ListNode right = null;
    ListNode left = null;

    public ListNode(int value) {
      this.value = value;
    }
  }

  // iterates recrusively through the rest of the array as pre-fix
  private static void generate(int[] arr, int mid, ListNode node) {
    int midpoint = mid / 2;
    // left node first
    if (mid - midpoint >= 0) {
      node.left = new ListNode(arr[mid - midpoint]);
      generate(arr, mid - midpoint, node.left);
    }
    if (mid + midpoint < arr.length) {
      node.right = new ListNode(arr[mid + midpoint]);
      generate(arr, mid + midpoint, node.right);
    }
  }

  // must be a sorted array to make a bst out of it
  public static ListNode generate(int[] arr) {
    int mid = 0;
    ListNode root = null;
    if (arr.length % 2 == 1) {
      mid = (arr.length / 2) + 1;
      root = new ListNode(arr[mid]);
    } else {
      mid = (arr.length / 2);
      root = new ListNode(arr[mid]);
    }

    generate(arr, mid, root);

    return root;
  }

  public static void main(String[] args) {
    int[] arr = {0,1,2,3,4,5,6,7,8,9,10};
    ListNode tree = generate(arr);
    System.out.println(tree.right);
    System.out.println(tree.left);
  }
}