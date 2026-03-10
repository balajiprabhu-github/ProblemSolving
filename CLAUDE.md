# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

A Kotlin-based DSA learning repository focused on deep understanding of algorithms and data structures. The goal is mastery over speed — 0.1% better each day, no fixed timeline. Every concept is understood deeply before moving on.

## Learning Journey

### Philosophy
- Deep understanding over rushing through problems
- Always analyze Time and Space complexity with reasoning (not just the answer)
- Trace through examples by hand before and after implementing a solution
- Revisit and question assumptions — "why does this work?" matters as much as "does it work?"

### Notes
- Do NOT reference or read previously solved solutions in `easy/`, `medium/`, or `hard/`. It has been a few years since those were written and the user may have lost touch — treat every problem as fresh, build from scratch.

### Roadmap

**Phase 1: Foundations**
- Part 1: Big-O Analysis — `foundations/BigOExercises.kt`
- Part 2: Recursion Lab — `foundations/RecursionLab.kt`

**Phase 2: Core Data Structures**
- Arrays & Strings (two pointers, sliding window patterns)
- Hash Maps & Sets
- Linked Lists
- Stacks & Queues
- Binary Trees & BST
- Heaps / Priority Queues

**Phase 3: Core Algorithms**
- Binary Search (templates and variants)
- DFS / BFS (trees and graphs)
- Backtracking
- Dynamic Programming (bottom-up and top-down)
- Greedy

**Phase 4: Advanced**
- Graphs (Dijkstra, Union-Find, Topological Sort)
- Tries
- Advanced DP patterns

### Complexity Analysis Standard
Every solution (especially in `foundations/`) should include:
- Time complexity with step-by-step reasoning
- Space complexity noting call stack depth for recursive solutions
- A stack trace or worked example showing how the algorithm unfolds

## Commands

```bash
./gradlew build          # Full build with tests
./gradlew compileKotlin  # Compile only
./gradlew test           # Run all tests
./gradlew run            # Run main application
```

## Architecture

### Directory Structure
- `src/main/kotlin/easy/` — LeetCode easy problems (numbered files, e.g., `FizzBuzz412.kt`)
- `src/main/kotlin/medium/` — LeetCode medium problems
- `src/main/kotlin/hard/` — LeetCode hard problems
- `src/main/kotlin/foundations/` — Educational exercises (BigO analysis, recursion labs)
- `src/main/kotlin/datastructure/` — Reusable `ListNode`, `TreeNode`, and `sorting/` algorithms

### Conventions
- Each problem lives in its own file named `<ProblemName><Number>.kt` (e.g., `ValidPalindrome125.kt`)
- Solutions use encapsulated inner classes named `Solution` within each file
- Packages match directory: `easy`, `medium`, `hard`, `datastructure`, `foundations`
- `ListNode` and `TreeNode` from `datastructure/` are the standard types for linked list and tree problems
- Complexity analysis comments (Time/Space) are expected in `foundations/` and encouraged elsewhere

### Tech Stack
- Kotlin 1.7.10, JVM target Java 1.8
- Gradle 7.4.2 with Kotlin DSL (`build.gradle.kts`)
- JUnit for testing