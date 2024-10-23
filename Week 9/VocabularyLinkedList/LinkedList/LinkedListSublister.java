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

/**
 * Utility class for performing operations on LinkedList.
 */
class LinkedListSublister<T extends Comparable<T>> {

  /**
   * Creates a sublist from the specified range [fromIndex, toIndex).
   *
   * @param list      the original linked list
   * @param fromIndex the start index (inclusive)
   * @param toIndex   the end index (exclusive)
   * @return a new LinkedList containing the specified range of elements
   * @throws IndexOutOfBoundsException if fromIndex or toIndex is out of range
   */
  public LinkedList<T> subList(LinkedList<T> list, int fromIndex, int toIndex) {
    if (fromIndex < 0 || toIndex > list.size() || fromIndex > toIndex) {
      throw new IndexOutOfBoundsException("Invalid fromIndex or toIndex");
    }

    LinkedList<T> subList = new LinkedList<>();
    Node<T> current = list.head;
    int index = 0;

    // Traverse to the starting index
    while (current != null && index < fromIndex) {
      current = current.next;
      index++;
    }

    // Add elements from fromIndex to toIndex
    while (current != null && index < toIndex) {
      subList.add(current.data);
      current = current.next;
      index++;
    }

    return subList;
  }
}