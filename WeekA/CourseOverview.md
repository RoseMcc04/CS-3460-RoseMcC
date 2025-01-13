# Introduction and Course Overview

## Table of Contents
0. [Table of Contents](#table-of-contents)
1. [Course Overview](#course-overview)
2. [Why Study Data Structures?](#why-study-data-structures)
3. [Why Discuss Algorithm Design?](#why-discuss-algorithm-design)
4. [Programming `!=` Algorithm Design](#programming--algorithm-design)
5. [A Good Algorithm (or Data Structure)](#a-good-algorithm-or-data-structure)
6. [*Study: The Stable Marriage Problem*](#study-the-stable-marriage-problem)
    1. [*A Stable Marriage Solution?*](#a-stable-marriage-solution)
7. [The Gale-Shapely Algorithm](#the-gale-shapely-algorithm)

## Course Overview

- The goal of this course is to provide an *introduction to data structures and algorithms* in a *fun, fast-paced environment*
- Together, we will learn:
    - *Elementary data structures* (such as arrays, linked lists, queues, and stacks)
    - *Fundamental algorithmic processes* (such as searching, selection, and sorting)
    - *Algorithmic analysis* (using tooks such as asymptotic notation, recurrence relations, and proof techniques)
    - Important data structures such as *hash tables, priority queues, and binary search trees*
    - *Useful graph algorithms* to traverse a graph and compute a shortest path
    - *Algorithm design techniques* using abstractions, and to *improve our practical coding skills*

## Why Study Data Structures?

- Data structures are at the core of *every part* of computing!
- *Operating systems, compiler design, programming languages, networking, databases, graphics, and more!*
- All of the easy problems are *solved*! Every field is making use of *data science* to solve their hard problems
- *Science, engineering, finance, arts and humanities, commerce, health and wellness*
- Learning to write *efficient* solutions is crucially important -- efficiency is everything!
- Developing proficiency with data structures and algorithm design are one of the key things that separate a *computer scientist* from a *programmer*
- Algorithms and data structures, above all else, are *fun*!

## Why Discuss Algorithm Design?

- An *algorithm* is a step-by-step process to solve a computational problem; a *data structure* is a tool used to store, organize, update, and retrieve data
- You cannot talk about one without the other!

## Programming `!=` Algorithm Design

- Both are valuable skills, but they are not the same!
- *"Computer Science is no more about computers than astronomy is about telescopes,"* attributed to Dijkstra
- Programming and software engineering proficiency are important to the success of most programming projects and careers
- Problem-solving skills and programming skills are not the same, *but they do reinforce each other*!

## A Good Algorithm (or Data Structure)

- Always terminates and produces a "correct" output
    - Some algorithms give an answer that is *close enough*
    - Some randomized algorithms *fail*, but with *vanishingly small probability*
- Makes *efficient use of resources*
    - Usually we focus on *runtime* (time is our most precious resource!)
    - Sometimes we care about *memory usage*, *processor allocation*, *power consumption*, or the use of other shared resources
- Is usually *simple*! The optimal solution is often...
    - *elegant*
    - *easy to explain*
    - simple to *analyze*
    - simple to *implement*, *test*, and *debug*

## *Study: The Stable Marriage Problem*

- Given *n* men and *n* women with preference lists, can we find a *stable marraige*?
```text
[1 2 3 4] M1     W1 [1 2 3 4]
[4 2 3 1] M2     W2 [4 2 3 1]
[4 3 2 1] M3     W3 [4 3 2 1]
[4 2 3 1] M4     W4 [4 2 3 1]
```
- A *stable marriage* is a matching that contains no *blocking pairs*
- A *blocking pair* is any man and woman who would *prefer to be with one another* than who they are currently paired with
    - *Ex.: M2 would rather be with W3 and M3 would rather be with W2*
- The stable marriage problem in the real world:
    - matching *students* to *dormitories*
    - matching *medical students* to *hospital residencies*
    - matching many *users* to few *servers*
- Countless interesting variation!

### *A Stable Marriage Solution*

- W1 accept M1's proposal. M2 proposes to W4.
- W4 accepts M2's proposal. M3 proposes to W4. 
- W4 rejects M3's proposal. M3 proposes to W3. 
- W3 accepts M3's proposal. M4 proposes to W4. 
- W4 accepts M4's proposal, breaking up with M2. M2 proposes to W2. 
- W2 accepts M2's proposal, creating a stable marriage.

(1.) Does this algorithm always *terminate*?
    - 
(2.) Is it guaranteed to produce a *stable marriage*?
    - 

- This algorithm is called the *Gale-Shapely algorithm*

## The Gale-Shapely Algorithm

- Always finds a *stable matching*
- Always terminates. (How would you prove this?)
- *Order of proposals* does not matter
- Optimal for men, sub-optimal for women
