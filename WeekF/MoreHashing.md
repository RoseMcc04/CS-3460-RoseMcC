# More Hashing

## Table of Contents

0. [Table of Contents](#table-of-contents)
1. [Hashing - So Far...](#hashing---so-far)
2. [Maps](#maps)
    1. [Specification](#specification)
    2. [Implementation](#implementation)
3. [Collisions](#collisions)
    1. [Exploiting Collisions](#exploiting-collisions)

## Hashing - So Far...

- Hash functions
    - Modular hashing, Multiplicative hashing
    - *Universal hashing* - `O(1)` expected guarantee
- Hash table
    - Supports operations *insert*, *remove*, *find*
    - Resolving collisions with *chaining* and *probing*
- Hashing large objects
    - Polynomial hash functions

## Maps

- We can augment the elements in a hash table with *additional information*
- **Example:** Find the most frequently occurring word in a text file
- **Solution:** Store each string in a hash table, augmented with an integer count
- We can think of this hash table as a "*mapping*" from strings to ints
```text
when
mr
bilbo
baggins
of
bag
end
announced
that
he
would
shortly
be
celebrating
his
...
```
- Hash-based **map data structures** are supported in many languages (e.g., Perl, Python, Javacript) using simple *array indexing notation*
```python
# Example 1

xid = 101192168
students[xid] = "John"

# Example 2

grade["John"] = 100
```
- These look like arrays, but they are actually *hash tables*!

- We can *search* for large records based on a key
- A key that uniquely identifies a record is called a **primary key**
- Records are stored outside of the hash table, follow *pointer* to find record
- How do we search for records organized by another key? *Build another hash table*

### Specification

- `put(key, value)` - add or update *key-value pair*
- `get(key)` - get *value* associated with *key*
- optionally, `delete(key)` and `contains(key)`

### Implementation

![Hash Map Visual Implementation](https://miro.medium.com/v2/resize:fit:1200/1*l9eCykFTYwvLZgy62id5Ag.png)

## Collisions

- **Are collisions always a bad thing?** No, we can use collisions to solve interesting problems!

### Exploiting Collisions

![Jumble Example](https://bloximages.chicago2.vip.townnews.com/poststar.com/content/tncms/assets/v3/editorial/4/4c/44ca8e33-51ae-5e83-9d39-3ecffd334fc3/5bed27de8bddb.preview.jpg)

- Given a dictionary of English words, how do we unscramble these words?
- How do we *brute force* this solution?
- Can we design a solution that takes advantage of *hash collisions*? How can we transform our input?
- **Consider:** convert words into a histogram of letter frequency
