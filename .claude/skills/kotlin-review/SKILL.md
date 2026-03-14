---
name: kotlin-review
description: Review Kotlin DSA solution for idiomatic style, null safety, and Kotlin-specific best practices
argument-hint: [file or function to review]
user-invocable: true
---

Review the Kotlin solution `$ARGUMENTS` through the lens of idiomatic Kotlin. Cover each of these areas:

## 1. Idiomatic Kotlin
- Are Kotlin stdlib functions used where applicable? (`mapIndexed`, `filter`, `fold`, `zip`, `windowed`, `indices`, `until`, etc.)
- Is `data class` preferred over manual equals/hashCode?
- Are extension functions or local functions used to reduce clutter?
- Is `when` preferred over `if-else` chains?
- Are named arguments and default parameters used appropriately?

## 2. Null Safety
- Is `?` (nullable) vs non-null used correctly?
- Are `?.`, `?:`, `!!` used judiciously? Flag any `!!` that could be replaced.
- Is `let`, `run`, `also`, `apply` used in null-check contexts appropriately?

## 3. Collections & Sequences
- Are mutable collections used only when mutation is needed? Prefer `val list = mutableListOf()` over `var list = listOf()`.
- For lazy/chained operations on large inputs, is `asSequence()` considered?
- Are array vs list vs set choices justified?

## 4. Readability & Conciseness
- Can any verbose constructs be shortened with Kotlin idioms?
- Are variable names descriptive without being overly verbose?
- Is `it` overused in nested lambdas (should be named)?

## 5. Kotlin-Specific Anti-patterns to Flag
- Using `java.util.*` classes when Kotlin stdlib suffices
- Unnecessary `return` in the last expression of a lambda
- Using index-based loops when `forEach`/`for (x in y)` is cleaner
- Mutable state that could be made immutable

## Output Format
For each issue found, show:
- The original code snippet
- The improved idiomatic version
- A one-line explanation of why it's more Kotlin-idiomatic

End with a summary verdict: **Idiomatic** / **Mostly idiomatic with minor notes** / **Needs Kotlin idiom work**
