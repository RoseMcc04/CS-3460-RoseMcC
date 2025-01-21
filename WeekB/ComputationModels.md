# Understanding Models of Computation

## Table of Contents 

0. [Table of Contents](#table-of-contents)
1. [Models of Computation](#models-of-computation)
2. [Turing Machine](#turing-machine)
3. [Random Access Machine (RAM)](#random-access-machine-ram)
4. [Comparison Model](#comparison-model)
5. [Abstraction in Expressing Algorithms](#abstraction-in-expressing-algorithms)

## Models of Computation

- What are the *primitive operations* available to our algorithm?
- How realistic should this model be?

## Turing Machine

- A model defined by an *infinite length tape* containing input, a *head* that can read from or write to whichever cell of the input tape is located above, and a *state register* to track the current state

## Random Access Machine (RAM)

- In the RAM model, instructions are executed *sequentially*
- Memory is an array of words, any individual memory location is accessible in *constant time* `O(1)`
- rithmetic operations like addition, subtraction, multiplication, division, modulus, and comparison are all `O(1)` operations
- Is this a realistic model of computation?
    - In the real world, *memory access* takes substantially longer than *arithmetic operations*
    - Does not take *caching* into consideration

## Comparison Model

- Only allowed to make *pairwise comparisons*
- Data is a "*black box*," and defines its own *comparison operations*
- Why choose such a restrictive model?
    - RAM model seems much more powerful!

## Abstraction in Expressing Algorithms

- **Problem:** Given a sorted array of `n` integers, does there exist two integers that add to a target value `t`?
- **Naive Solution**: For every pair of elements, check if the sum if `t`
    - There are `(n 2)` pairs: `Θ(n^2)`
- **Better Solution:** Since the array is sorted, for each element `Ai`, we can binary search the array for the matching element, `t - Ai` 
    - **Analysis:** Doing at most `n` binary searches, this takes `O(n*lg(n))`
