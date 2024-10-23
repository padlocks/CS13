/**
 * MIT License
 *
 * Copyright (c) 2024 Scott Davis
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
 
package LinkedList;
class LinkedListSorter<T extends Comparable<T>> {

  // Method to sort the linked list
  public Node<T> sort(Node<T> head) {
    if (head == null || head.next == null) {
      return head;
    }

    // Step 1: Split the list into two halves
    Node<T> middle = getMiddle(head);
    Node<T> nextOfMiddle = middle.next;
    middle.next = null;

    // Step 2: Recursively sort each half
    Node<T> left = sort(head);
    Node<T> right = sort(nextOfMiddle);

    // Step 3: Merge the sorted halves
    return merge(left, right);
  }

  // Helper method to find the middle of the linked list
  private Node<T> getMiddle(Node<T> head) {
    if (head == null)
      return head;

    Node<T> slow = head;
    Node<T> fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  // Helper method to merge two sorted linked lists
  private Node<T> merge(Node<T> left, Node<T> right) {
    Node<T> result;

    if (left == null)
      return right;
    if (right == null)
      return left;

    if (left.data.compareTo(right.data) <= 0) {
      result = left;
      result.next = merge(left.next, right);
    } else {
      result = right;
      result.next = merge(left, right.next);
    }
    return result;
  }
}
