# Stacks and Queues

## Table of Contents

0. [Table of Contents](#table-of-contents)
1. [Stacks](#stacks)
    1. [Specification](#specification)
    2. [Implementation](#implementation)
        1. [Stacks with Arrays](#stacks-with-arrays)
        2. [Stacks with Linked Lists](#stacks-with-linked-lists)
    3. [*Stacks Example: Parsing*](#stacks-example-parsing)
    4. [*Stacks Example: Arithmetic*](#stacks-example-arithmetic)
    5. [*Stacks Example: Parsing Postix*](#stack-example-parsing-postfix)
    5. [*Stacks Example: Parsing Infix*](#stacks-example-parsing-infix)
    6. [*Stacks Example: Reversing*](#stacks-example-reversing)
    7. [*Stacks Example: Recursion*](#stacks-example-recursion)
    8. [*Stacks Example: Applications*](#stacks-example-applications)
2. [Queues](#queues)
    1. [Specification](#specification-1)
    2. [Implementation](#implementation-1)
        1. [Queues with Arrays](#queues-with-arrays)
    3. [*Queues Example: Scheduling*](#queues-example-scheduling)
    4. [*Queues Example: Simulations*](#queues-example-simulations)
    5. [*Queues Example: Producer-Consumer*](#queues-example-producer-consumer)

## Stacks

### Specification

- `push(x)` - insert the object `x` onto the stack 
- `pop()` - remove and return the object on top of the stack
- Last-in, first-out (*LIFO*)
- Operations only happen on one end of the data structure

### Implementation

- Underlying Array
- Underlying Linked List

#### Stacks with Arrays

```java
public T pop() 
{
    return data[--top];
}

public void push(T elem) 
{
    data[top++] = elem;
}

public T peek() 
{
    return data[top - 1];
}
```

![Stack Array Image](https://miro.medium.com/max/1075/1*QMifqahZm4DGQ91GkOhu4g.png)

#### Stacks with Linked Lists

```java
public T pop() 
{
    T elem = head.data;
    head = head.next;
    return elem;
}

public void push(T elem) 
{
    head = new Node<T>(head, elem);
}

public T peek() 
{
    return head.data;
}
```

![Stack Linked List Image](https://media.geeksforgeeks.org/wp-content/uploads/20240508162652/stack-as-linked-list.png)

### *Stacks Example: Parsing*

- Balancing brackets
    - Check if brackets are balanced/matching
    - On open bracket, push onto stack
    - On close bracket, pop and check for match
```c
[ 5 + 7 * ( 3 / 2 ) - 1 ] * 2
```
- Parson component of a compiler
    - Recursive-descent parsers
    - Shift-reduce parsers
    - Simple precedence parsers

### *Stacks Example: Arithmetic*

- Infix expressions - operand *operator* operand
```c
[ 5 + 7 * ( 6 / 2 ) - 1 ] * 2
```
- Postfix expressions - operand operand *operator*
```c
5 7 6 2 / * + 1 - 2 *
```

### *Stack Example: Parsing Postfix*

- keep a stack of *operands*
- parse tokens from left to right
- operators *pop* two operands, *push* result back onto stack
- a balanced expression will result in one value remaining on the stack

### *Stacks Example: Parsing Infix*

- keep a stack of *operands*
- parse tokens from left to right
- write operands directly to output
- operators pop entries off stack based on precedence rules
- resulting output is in *postfix notation*

### *Stacks Example: Reversing*

- Stacks can easily reverse a sequence
    - Pushing values from sequence onto stack
    - Popping from the stack will reverse the input
- Testing for a palindrome - "*never odd or even*"
- Reverse a linked list
```java
Stack<Integer> s = new Stack<Integer>;
while (num > 0) 
{
    int bit = num % 2;
    num = num / 2;
    // System.out.print(bit);
    s.push(bit);
}
while (!s.isEmpty()) 
{
    System.out.print(s.pop());
}
```

### *Stacks Example: Recursion*

- Program state is stored on a stack
```java
private static void mystery(int num) 
{
    if (num <= 0) return;
    System.out.print(num + " ");
    mystery(num - 1);
    System.out.print(num + " ");
}
```
- Functional programming languages use recursion
- `car` - first element of sequence
- `cdr` - rest of sequence

### *Stacks Example: Applications*

- Browsing a directory structure
- Undo/Redo buttons in software
- Back/Forward buttons in browsers
- Advanced algorithms like depth first search, graph and tree traversals, recursive backtracking, network algorithms, etc.

## Queues

### Specification

- `enqueue(x)` - insert the object `x` at the back of the queue
- `dequeue()` - remove and return object from the end of the queue
- First-in, first-out (*FIFO*)
- Insertions and deletions happen at opposite ends of the dynamic sequence

### Implementation

- Underlying Array
- Underlying Linked List

#### Queues with Arrays

```java
public void enqueue(T elem) 
{
    data[back++] = elem;
}

public T dequeue() 
{
    T elem = data[0];
    for (int i = 1; i <= back; i++)
        data[i - 1] = data[i];
    back -= 1;
    return elem;
}
```

![Queue Array Image](https://media.geeksforgeeks.org/wp-content/cdn-uploads/20230726165642/Queue-Data-structure1.png)

### *Queues Example: Scheduling*

- *CPU* and *disk scheduling*
- Queueing jobs or requests
    - webserver, printer, download manager, etc.
- Songs or videos in a *playlist*
- Queues = pipelines
    - **Amazon**: orders
    - **Netflix**: packets in the video buffer
    - **Banking**: pending transactions
    - **Hospital**: patient wait list

### *Queues Example: Simulations*

- Simulations are a good way to study complex processes and behavior
- Very effective way to observe and analyze physical and biological processes
- *Time-based simulations observe what happens at regular, frequent intervals*
- *Event-based simulations* place all key events into a queue and execute them in order

### *Queues Example: Producer-Consumer*

- **Producer-Consumer problem:** One process produces while another process consumers
- Instructions to device drivers
- Asynchronous communication between processes and threads
- Online multiplayer netcode (delay vs rollback)
- I/O and file streams, handling interrupts
- Pipes connecting programs and processes
```shell
>>> cat file | grep target | wc -l
```
