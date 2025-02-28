# Binary Search Trees

## Table of Contents

0. [Table of Contents](#table-of-contents)
1. [Sets/Dictionaries](#setsdictionaries)
2. [Binary Search Trees](#binary-search-trees-1)
3. [BSTs as Maps](#bsts-as-maps)
4. [Fundamental Operations](#fundamental-operations)
5. [Tree Traversals](#tree-traversals)
6. [Sorting with a BST](#sorting-with-a-bst)
7. [Quicksort ~ BST Continuation](#quicksort--bst-continuation)
8. [Minimum and Maximum](#minimum-and-maximum)
9. [Predecessor and Successor](#predecessor-and-successor)
10. [Inexact Search](#inexact-search)
11. [Paging Through Nearby Elements](#paging-through-nearby-elements)
12. [Deletion](#deletion)
13. [Splits and Joins](#splits-and-joins)
14. [Augmenting with Subtree Sizes](#augmenting-with-subtree-sizes)
15. [Select and Rank](#select-and-rank)
16. [Dynamic Sequences](#dynamic-sequences)

## Sets/Dictionaries

- `insert(k)` - insert the key `k` into the set
- `remove(k)` - remove the key `k` from the set
- `find(k)` - find where key `k` is located in the set

| **Operation** | `find(k)`       | `insert(k)`      | `remove(k)`      |
|-----------------|---------------|----------------|----------------|
| unsorted array  | `O(n)`          | `O(n)`           | `O(1) + find`    |
| sorted array    | `O(lg n)`       | `O(n)`           | `O(n)`           |
| unsorted linked list | `O(n)`          | `O(1)`           | `O(1) + find`    |
| sorted linked list | `O(n)`          | `O(n)`           | `O(1) + find`    |
| universal hash tables | `O(1)`          | `O(1)`           | `O(1)`           |
| (balanced) binary search trees | `O(lg n)`       | `O(lg n)`        | `O(lg n)`        |

## Binary Search Trees

- A **tree** is a hierarchical, node-based data structure, where each node points to some number of *children*
- A **binary tree** is a tree where each node has at most *two children* (binary = 2)
    - One could think of a *linked list* as a *unary tree*
- The **binary search tree** property requires that the key of any node be *greater than* all nodes in its *left subtree*, and *less than* all nodes in its *right subtree*
- The *runtime* of BST operations depends on the **height** of a tree. How do we define the height of a tree?
- If the tree is *balanced*, all operations should take `O(lg n)`, because the height is `O(lg n)`

```java
public class Node 
{
    private int key;
    private Node parent;
    private Node left;
    private Node right;
    // ...
}
```

![BST Example](https://miro.medium.com/v2/resize:fit:1400/1*tUBYCHi32Zj0B2UCw0qmlA.png)

## BSTs as Maps

- A *histogram* for word lengths for each word in the *Gettysburg Address*
```java
public class Node 
{
    private int key;
    private int value;
    private Node parent;
    private Node left;
    private Node right;
    // ...
}
```

## Fundamental Operations

- Most operations can be defined *recursively* to run in `O(h)` time, where `h` is the height of the tree
```python
def find(tree, key):
    if tree == null then return False
    if key < tree.key then return find(tree.left, key)
    if key > tree.key then return find(tree.right, key)
    if key == tree.key then return True
```
```python
def insert(tree, key):
    if tree == null then return new Node(key)
    if key < tree.key then tree.left = insert(tree.left, key)
        else tree.right = insert(tree.right, key)
    return tree
```

## Tree Traversals

- We can enumerate the contents of a size `n` *binary search tree* in only `O(n)` time using an **in-order traversal**. How is this `O(n)`?
```python
def inorder(tree):
    if tree == null then return
    inorder(tree.left)
    print(tree.key)
    inorder(tree.right)
```
- Other common tree traversal types:
    - **Pre-order**: root > left > right
    - **Post-order**: left > right > root
    - **Euler tour**: root > left > root > right > root

## Sorting with a BST

- An inorder traversal prints the BST in *sorted order*, in `O(n)` time
- Therefore, we can sort with a BST by:
    - Inserting `n` elements in `O(n lg n)*` time
    - Doing an inorder traversal in `O(n)` time
- We can think of the BST as a "*dynamization*" of the sorting process
- The operation of building a BST looks exactly *like running quicksort*!

## Quicksort ~ BST Continuation

- There is a direct analogue between *running quicksort* and the process of *building a binary search tree*
- It is easy to see why they have the same running times!
- **Randomized quicksort** is analogous to building a binary search tree by inserting *in random order*
- The difference is we can *add new elements to the BST later*!

## Minimum and Maximum

- We can find the minimum or maximum in a BST quickly and easily
- **minimum**: Start at the root and down the *left spine*
- Symmetric for **maximum**

## Predecessor and Successor

## Inexact Search

## Paging Through Nearby Elements

## Deletion

## Splits and Joins

## Augmenting with Subtree Sizes

## Select and Rank

## Dynamic Sequences
