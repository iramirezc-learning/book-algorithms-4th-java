# Chapter 3: Sorting

## Section 4: Priority Queues

[<- go back to index](../../../../index.md)

### Exercises

#### 2.4.33 *Index priority-queue implementation*. Implement the basic operations in the index priority queue API on page 320 by modifying *Algorithm 2.6* as follows: Change `pq[]` to hold indices, add an array `keys[]` to hold the `key` values, add an array `pq[]` that is the inverse of `pq[]` - `qp[i]` gives the position of `i` in `pq[]` (the index such that `pq[j]` is `i`). Then modify the code in *Algorithm 2.6* to maintain these data structures. Use the convention that `qp[i] = -1` if `i` is not on the queue, and include a method `contains()` that tests this condition. You need to modify the helper methods `exchange()` and `less()` but not `sink()` or `swim()`.

[**Code ->** E2433.java](./E2433.java)

#### 2.4.34 *Index priority-queue implementation (additional operations)*. Add `minIndex()`, `changeKey()`, and `delete()` to your implementation of Exercise 2.4.33.

[**Code ->** E2434.java](./E2434.java)
