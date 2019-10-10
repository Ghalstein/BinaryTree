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

  
   // must be a sorted array to make a bst out of it
   public static ListNode generate(int[] arr) {
    ListNode root = null;
    if (sortedArr.length % 2 == 1) {
      root = new ListNode(sortedArr[(sortedArr.length / 2) + 1]);
    }
    else root = new ListNode(sortedArr[sortedArr.length / 2]);

    return root;

  }

  }




  public static void main(String[] args) {

  }
}