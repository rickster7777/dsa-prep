# Binary Search Templates & Decision Guide

## TEMPLATE 1 — Find an Exact Value (Classic Binary Search)

### When to use:
- The problem says "find target"
- Return index or true/false
- Example: LeetCode 704. Binary Search

### Mental rule:
**If mid is wrong, discard it completely**

### Why this never breaks:
- `l <= r` → guarantees progress
- `mid + 1` / `mid - 1` → mid is gone forever
- No infinite loops

### Golden Rule:
👉 **If you're returning immediately on `nums[mid] == target`, you must use `mid ± 1`**

### Template:
```python
if nums[mid] == target:
    return mid
elif nums[mid] < target:
    l = mid + 1   # discard mid
else:
    r = mid - 1   # discard mid
.
return -1
```

---

## TEMPLATE 2 — Find a Boundary (Most LeetCode Problems)

### When to use:
- First / last occurrence
- Minimum / maximum
- Lower bound / upper bound
- "Smallest X such that…"

### Related Problems:
- 34. Find First and Last Position
- 69. Sqrt(x)
- 875. Koko Eating Bananas
- 410. Split Array Largest Sum

### Mental rule:
**mid might be the answer → NEVER discard it**

### Key insight:
- If condition is true → mid is a valid candidate
- So you save it
- Then try to find a better (smaller) one

### Template:
```python
if condition(mid):
    ans = mid
    r = mid - 1   # keep mid, move left
else:
    l = mid + 1

return ans
```

### Golden Rule:
👉 **If you assign `ans = mid`, you never do `l = mid`**

---

## TEMPLATE 3 — Binary Search on Answer (Most Advanced)

### When to use:
- You're not searching an array
- You search a range of answers
- Condition is monotonic (false → true OR true → false)

### Example:
"What is the minimum speed such that Koko eats all bananas?"

### Mental rule:
**I don't care about mid itself — I care if it works**

### Template:
```python
l, r = MIN, MAX

while l < r:
    mid = l + (r - l) // 2
    
    if can(mid):
        r = mid        # keep mid
    else:
        l = mid + 1

return l
```

### Why `while l < r`?
- Guarantees termination
- One value left → that's the answer

### Golden Rules:
👉 **If you use `l = mid`, you must use `while l < r`**
👉 **Otherwise you WILL infinite loop**

---

## Step-by-Step LeetCode Approach

### Before coding:

1. **Step 1 — Ask:**
   - Am I finding an exact value or a boundary?

2. **Step 2 — Choose template:**
   - Exact value → **Template 1**
   - Boundary / min / max → **Template 2 or 3**

3. **Step 3 — DO NOT IMPROVISE**
   - Copy template
   - Only change:
     - `condition`
     - `return value`

---

## Decision Flowchart

```
START
  |
  v
Is the array / search space SORTED or MONOTONIC?
  |
  |-- NO --> ❌ Binary search is wrong tool → STOP
  |
  |-- YES
        |
        v
Are you trying to find an EXACT value/index?
        |
        |-- YES
        |      |
        |      v
        |  🎯 TEMPLATE 1: Exact Match
        |  - while l <= r
        |  - discard mid (mid ± 1)
        |
        |-- NO
              |
              v
Are you looking for a FIRST / LAST / MIN / MAX /
"smallest X such that..." ?
              |
              |-- YES
              |      |
              |      v
              |  🎯 TEMPLATE 2/3: Boundary Search
              |  - while l < r OR l <= r + ans
              |  - keep mid (l = mid or r = mid)
              |
              |-- NO
                    |
                    v
Is the problem searching an ANSWER RANGE
(not array indices)?
                    |
                    |-- YES
                    |      |
                    |      v
                    |  🎯 TEMPLATE 3: Binary Search on Answer
                    |  - while l < r
                    |  - condition(mid)
                    |
                    |-- NO
                          |
                          v
❌ Re-check problem (probably not binary search)
```

---

## Final Confidence Booster

### If your binary search ever:
- Infinite loops
- Misses edge cases
- Works "most of the time"

👉 **You're mixing templates.**

### Key Insight:
**Binary search is not intuition-based.**
**It's template-based.**

---

## Quick Reference

| Scenario | Template | Loop | Mid Handling | Return |
|----------|----------|------|--------------|--------|
| Find exact value | 1 | `l <= r` | Discard (`mid ± 1`) | `mid` or `-1` |
| Find boundary (min/max) | 2 | `l <= r` or `l < r` | Keep (`ans = mid`) | `ans` |
| Search answer range | 3 | `l < r` | Keep (`r = mid`) | `l` |
