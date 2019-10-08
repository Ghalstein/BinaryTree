/*
* Creates a BST from a sorted Array
* In order to do this will have to cut the array in half to find the middle
* root element -- then branch off accordingly from each side
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

  private ListNode root = null;


  public CreateBST (int[] sortedArr) {
    if (sortedArr.length % 2 == 1) {
      this.root = new ListNode(sortedArr[(sortedArr.length / 2) + 1]);
    }
    else this.root = new ListNode(sortedArr[sortedArr.length / 2]);
  }

  // creates the left side
  private static void left(int[] arr, int currIndex, ListNode curr) {
    while (currIndex >= 0) {
      if (curr.right == null) {
        curr.right = new ListNode(arr[currIndex--]);
      } else if (curr.left == null) {
        curr.left = new ListNode(arr[currIndex--]);
      }
    }
  }

  // creates the right side
  private static void right(int[] arr, int currIndex, ListNode curr) {
    while (currIndex < arr.length) {

    }
  }




  public static void main(String[] args) {

  }
}