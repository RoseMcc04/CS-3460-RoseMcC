# Measuring Runtimes: Big O and Asymptotic Notation

## Table of Contents

0. [Table of Contents](#table-of-contents)
1. [Measuring Runtimes](#measuring-runtimes)
2. [Asymptotic Notation](#asymptotic-notation)
3. [Running Times](#running-times)
4. [Fundamental Data Structures](#fundamental-data-structures)
    1. [Arrays](#arrays)
    2. [Linked Lists](#linked-lists)
        1. [Linked List Variations](#linked-list-variations)
    3. [Array vs. Linked List Performance](#array-vs-linked-list-performance)
5. [Abstract Data Types (ADTs)](#abstract-data-types-adts)
    1. [*Example ADT: Dynamic Sequence*](#example-adt-dynamic-sequence)
        1. [Specification](#specification)
        2. [Implementation](#implementation)
        3. [Applications of Sequences](#applications-of-sequences)
        4. [Sequences: BigInteger](#sequences-biginteger)

## Measuring Runtimes

- Why not use *wall-clock time*?
    - May not take *input size* into account
    - May not take *resource allocation* into account
    - May not take *hardware specs* into account
    - Could do empirical performance testing
```java
public static int linear_search(int[] array, int target) 
{
    for (int i = 0; i < array.length; i++) 
        if (arr[i] == target) return i;
    return -1;
}
```
```java
public static int binary_search(int[] array, int target) 
{
    int lo = 0, hi = array.length - 1;
    while (lo < hi) 
    {
        int mid = lo + (hi - lo) / 2;
        if (target < array[mid]) hi = mid - 1;
        else if (target > array[mid]) lo = mid + 1;
        else return mid;
    }
    return -1;
}
```
- Different inputs make a huge difference
- Do you want to measure *worst-case*? *Average case*?

## Asymptotic Notation

- *Linear search*: `O(n)`
- *Binary search*: `O(lg n)`
- What does `O(f(n))` mean?
    - Runtime is exactly `f(n)`? *No.*
    - Upper-bounded by `f(n)`? 
    - Upper-bounded by `c x f(n)`? *Close.*
    - Upper-bounded by `c x f(n)` as `n --> ∞`
- Provides an upper-bound on running time, ignoring *multiplicative factors*, *constant factors*, and *lower-order terms*
- Captures what really matters regarding algorithm performance: *How does worst-case performance scale with input size?*
- There is more than just Big-O notation...
    - `O(f(n))` is *an upper bound* (`<=`)
    - `Ω(f(n))` is *a lower bound* (`>=`)
    - `Θ(f(n))` is upper-bound *and* lower-bound (`=`)

## Running Times

- Why do we almost always focus on *worst-case performance*?

| **Category**       | **Notation**                  |
|--------------------|-------------------------------|
| Constant           | `O(1)`                          |
| Logarithmic        | `O(lg n)`                       |
| Linear             | `O(n)`                          |
| Polynomial         | `O(n²)`, `O(n³)`, `O(n¹⁰⁰)`, `...`    |
| 😐 Exponential     | `O(2ⁿ)`, `O(3ⁿ)`, `...`             |
| 🙁 Worse           | `O(n!)`, `O(nⁿ)`, `O(α(n))`, `...`    |
- Why do not we write the *base* of the logarithm?
- Yes, but *why* do not they matter?
    - Converting between bases is just *multiplying by a constant* (`lga(n)` = `lga(b)` * `lgb(n)`)
    - Usually, lg(n) means lg2(n)

## Fundamental Data Structures

- Arrays
- Linked Lists

### Arrays

- In Java, arrays are dynamically allocated in contiguous memory
- Arrays are Objects and take O(n) to allocate
- Array contents are accessed with indexing starting at 0
```java
int[] a = new int[5];

// Valid indices for the above array are 0 through 4
a[4] = 0;
```

### Linked Lists

- There are *many variations* on how to set up Linked Lists:
    - *Additional pointers*
    - *Doubly linked lists*
    - *Dummy nodes*
```java
public class LinkedList<T> 
{
    public class Node<T> 
    {
        public Node<T> data;
        public T data;
    }
    public Node<T> head;
}
```

#### Linked List Variations

- *Doubly*-Linked Lists
![Doubly Linked List](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6IAPFb1O5fe5IHWF5WRYyFo0EwPm0-Pex3w&s)
- *Dummy Nodes*
![Dummy Nodes](https://media.cheggcdn.com/media/fb0/s282x178/fb068a13-cddd-4d55-96be-f6b8b41c84c7/phpaUWkBj.png)

### Array vs. Linked List Performance

- Retrieve or opdate any element:
    - Array: `O(1)`
    - Linked List: `O(n)`
- Insert or remove from middle:
    - Array: `O(n)`
    - Linked List: `O(1)`
- Insert or delete from ends:
    - Array: `O(1)`
    - Linked List: `O(1)`

- Consider using a *circular* array to avoid overrunning array bounds

## Abstract Data Types (ADTs)

### *Example ADT: Dynamic Sequence*

#### Specification

#### Implementation

#### Applications of Sequences

#### Sequences: BigInteger