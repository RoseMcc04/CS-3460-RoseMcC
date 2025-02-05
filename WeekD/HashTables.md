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

- Like abov e, we maintain an array of size `m`
- Decide `h()`, a *hash function*
- Key `k` is stored at index `h(k)`
    - *Example: `h(k) = (2971*k + 101923) % m`*
- What happens when `h(k1)` = `h(k2)`?
    - This is known as a *collision*
    - This is inevitable as a larger set gets mapped to a smaller set according to the *Pigeonhole Principle*

## *Collision Resolution - Chaining*

- ![Chaining Diagram](https://he-s3.s3.amazonaws.com/media/uploads/0e2c706.png)

- Each cell is the head of a linked list containing all elements colliding on that cell
- `find(k)`: search the correct linked list - runtime depends on distribution of keys
- `insert(k)`: insert at the head of the correct linked list - `O(1)`
- `remove(k)`: remove from the correct linked list - `O(1) + find`
- Performance is good if keys are spread *uniformly* across table cells
- Hashing `n` keys into a table of size `m`, on average, produces lists of size `n/m`. If `m` = `O(n)`, then the length of each individual list is `O(1)` in expectation
- *Universal hashing* gives an `O(1)` *expected* guarantee for `find(k)`

## *Collision Resolution - Probing*

- ![Probing Diagram](https://image2.slideserve.com/4862991/hash-table-using-linear-probing-open-addressing-l.jpg)

- In the case of collision, we scan along a *probe sequence*
- `insert(k)` start at `h(k)`, keep scanning until we find an empty slot
- `find(k)`: start at `h(k)`, scan the probe sequence until we find the element or reach an empty slot
- Performance is generally good as long as...
    - the table is *slightly larger* than `n`
    - the *hash function* spreads keys unpredictably
- Collision Resolution:
    - `insert(k)`: try to store key `k` in `i` in `i` = `h(k)` (if unoccupied). Scan along the probe sequence as long as `h(k)` is greater to or equal to that of the current element. Once we reach an empty spot, or an element with a larger hash value, store it, and if necessary, displace the element at that location
    - `find(k)`: Scan along the probe sequence until we either find the element, find an empty spot, or find an element with a larger hash value
    - `remove(k)`: Perform `find(k)`, and after removing the element, adjust elements toward the left to fill the gaps
- All operations take `O(1)` time, as long as the table is large enough (slightly larger than `n`), and we use a good hash function that spreads values out
- Our choice of *probe sequence* matters too!
- Great *cache performance* (compared to chaining)

## Probe Sequences

- *Linear Probing*:
    - Start at `h(k)`, continue to adjacent cells `h(k) + 1`, `h(k) + 2`, `h(k) + 3`, ...
    - Great *cache locality*, very sensitive to *unevenly distributed* hash functions, constant *expected* runtimes for all operations, depending on load
    - Can be shown that with constant load factor, closters have a maximum size of `O(lg n)` *with high probability*
- *Quadratic Probing*: 
    - Start at `h(k)`, add successive values of a quadratic polynomial
    - *e.g., `h(k) + 1^2`, `h(k) + 2^2`, `h(k) + 3^2`, ...*
    - Slightly worse *cache locality*, but better addresses clustering problems
    - Must carefully choose a quadratic that visits *every possible location* (Table size `m ∈ P` can help)
- *Double Hashing*:
    - Start at `h1(k)`, add successive multiples of a second hash function `h2(k)`
    - Certain properties must be true of the relationship between `h1(k)`, `h2(k)`, and `m`
    - `h1(k)` and `h2(k)` must be *pairwise independent*, and all values of `h2(k)` must be *coprime* with `m`

## Choosing a Good Hash Function

## What Next?

