# Hash Tables

## Table of Contents

0. [Table of Contents](#table-of-contents)
1. [Specification](#specification)
2. [Implementation](#implementation)
3. [Sets/Dictionaries](#setsdictionaries)
4. [*Direct Access Table - Attempt 1*](#direct-access-table---attempt-1)
5. [Hash Tables](#hash-tables-1)
6. [*Collision Resolution - Chaining*](#collision-resolution---chaining)
7. [*Collision Resolution - Probing*](#collision-resolution---probing)
8. [Probe Sequences](#probe-sequences)
9. [Choosing a Good Hash Function](#choosing-a-good-hash-function)
10. [What Next?](#what-next)

## Specification

- `insert(k)`: insert the key `k` into the set
- `remove(k)`: remove the key `k` from the set
- `find(k)`: find there the key `k` is located in the set

## Implementation

- We could attempt this approach of sets/dictionaries with four structures:
    - an unsorted array
    - a sorted array
    - an unsorted linked list
    - a sorted linked list

## Sets/Dictionaries

| Structure             | `find(k)`  | `insert(k)`  | `remove(k)`  |
|-----------------------|-----------|-------------|-------------|
| Unsorted array       | `O(n)`    | `O(1)`      | `O(1) + find`  |
| Sorted array         | `O(lg n)` | `O(n)`      | `O(n)`      |
| Unsorted linked list | `O(n)`    | `O(1)`      | `O(1) + find`  |
| Sorted linked list   | `O(n)`    | `O(1) + find` | `O(1) + find` |
| **Hash Table**       | `O(1)*`   | `O(1)*`     | `O(1)*`     |

- `*` subject to some expected or amortized qualifiers

## *Direct Access Table - Attempt 1*

```text
4     
        6
    7
9           2
```
```text
_____________________
| |2| |4| |6|7| |9| |
---------------------
```
- Maintain a large *array* of booleans (or pointers)
- Key `k` will be stored at location `A[k]`
- What is the runtime of `insert(k)`, `remove(k)`, and `find(k)`?
    - `O(1)` *worst case*
- Drawbacks:
    - *Space*, and as a corollary initialization time
    - How do we store strings? Images? Videos?

## Hash Tables

## *Collision Resolution - Chaining*

## *Collision Resolution - Probing*

## Probe Sequences

## Choosing a Good Hash Function

## What Next?

