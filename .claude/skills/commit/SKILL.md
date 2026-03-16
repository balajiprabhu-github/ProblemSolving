---
name: commit
description: Commit DSA progress with best practices and auto-update session memory
user-invocable: true
---

You are helping a DSA learner commit their daily progress. Follow these steps in order.

---

## Step 1: Inspect the Changes

Run `git diff` and `git status` to understand what changed. Identify:
- Which problems were added or modified
- Whether it's a new solution, brute force, optimized approach, or complexity analysis
- Which file(s) are involved

---

## Step 2: Craft the Commit Message

Follow these best practices:

**Format:**
```
<type>: <short summary> (LC <number>)

<optional body — only if something non-obvious needs explaining>
```

**Types:**
- `solve` — new solution (brute force or optimized)
- `optimize` — improved an existing solution
- `refactor` — cleaned up code without changing logic
- `analysis` — added time/space complexity comments only
- `add` — new problem scaffold or skeleton

**Rules:**
- Summary line: max 72 characters, imperative mood ("Solve", not "Solved")
- Be specific: include the approach used (e.g., "two-pointer", "brute force")
- Do NOT use vague messages like "update", "progress", "wip"

**Good examples:**
```
solve: Add brute force and two-pointer for Trapping Rain Water (LC 42)
optimize: Replace O(n²) trap with O(n) two-pointer approach (LC 42)
analysis: Add Time/Space complexity for Container With Most Water (LC 11)
```

Stage only relevant files (avoid `.gradle/`, build artifacts). Use specific file paths, not `git add .`.

---

## Step 3: Create the Commit

Use a HEREDOC to pass the message:
```bash
git add <specific files>
git commit -m "$(cat <<'EOF'
<your message here>

Co-Authored-By: Claude Sonnet 4.6 <noreply@anthropic.com>
EOF
)"
```

---

## Step 4: Update Session Memory (AUTOMATED — always do this)

After every commit, update the memory file at:
`~/.claude/projects/-Users-balajiprabhu-ProblemSolving/memory/project_progress.md`

Rules for updating:
1. Read the current memory file first
2. Update `Last updated:` to today's date
3. Mark newly completed problems with ✓ under the correct phase/pattern
4. If a problem is partially done (e.g., brute force only), note exactly what's done and what's pending
5. Update the `**Currently working on:**` line to reflect what's next
6. Never remove history — only add or update entries

The memory must always answer: *"If I restart Claude Code tomorrow, what do I need to know to pick up exactly where I left off?"*

---

## Step 5: Confirm

Tell the user:
- The commit hash (first 7 chars)
- What was committed
- What the memory now says about current progress