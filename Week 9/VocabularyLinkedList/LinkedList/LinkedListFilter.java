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

import java.util.function.Predicate;

public class LinkedListFilter<T extends Comparable<T>> {
  /**
   * Removes elements from the linked list based on the given filter condition.
   *
   * @param list   the linked list from which elements are to be removed
   * @param filter the condition for removing elements
   * @throws NullPointerException if the provided list is null
   */
  public void removeIf(LinkedList<T> list, Predicate<T> filter) {
    if (list == null || list.head == null)
      return;

    // Remove matching elements from the head
    while (list.head != null && filter.test(list.head.data)) {
      list.head = list.head.next;
      list.size--; // Update size
    }

    // Remove matching elements from the rest of the list
    Node<T> current = list.head;
    while (current != null && current.next != null) {
      if (filter.test(current.next.data)) {
        current.next = current.next.next;
        list.size--; // Update size
      } else {
        current = current.next;
      }
    }
  }
}