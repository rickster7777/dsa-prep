# Set Matrix Zeroes - Key Points & Catches

## Problem Summary
Set all matrix elements to 0 if that element is 0, using **O(1) extra space**.

---

## ⚠️ Critical Catches

### 1. **Must Track First Row/Column BEFORE Modifying Them**
- Cannot use `matrix[0][*]` and `matrix[*][0]` as markers until AFTER we check if they originally contained zeros
- If you use them directly, you'll lose the original state
- **Solution:** Store `firstRowZero` and `firstColZero` boolean flags at the start

### 2. **Cannot Break Inner Loop Early in Step 3**
- ❌ **Wrong:** Break after finding first zero in a row
- ✅ **Correct:** Continue scanning the entire row
- **Why:** Every zero's column needs to be marked in `matrix[0][j]`. If you break early, other zeros in that row won't mark their columns, and those columns won't be zeroed in other rows.
- **Example:** Row `[1, 0, 1, 0]` - if you break at index 1, the zero at index 3 won't mark column 3

### 3. **Start from Index [1][1] in Step 3, NOT [0][0]**
- Skip first row and first column initially
- These are being used as markers, so we'll handle them separately later
- Prevents overwriting the marker information we're building

### 4. **Order Matters in Step 4**
- Process cells `[i][j]` from index [1][1] onwards
- Check if `matrix[i][0] == 0` (row is marked) OR `matrix[0][j] == 0` (column is marked)
- If either is true, set `matrix[i][j] = 0`

### 5. **Step 5 Must Handle First Row/Column Last**
- Only zero the first row if `firstRowZero` is true
- Only zero the first column if `firstColZero` is true
- **Why:** We used them as markers, so we need to apply the original zero status at the end

---

## 🎯 Algorithm Overview

| Step | Purpose | Range |
|------|---------|-------|
| 1 | Check if first row has zero | `j: 0 → n-1` |
| 2 | Check if first column has zero | `i: 0 → m-1` |
| 3 | Mark zeros using first row/col | `i: 1 → m-1`, `j: 1 → n-1` |
| 4 | Apply markers to zero out cells | `i: 1 → m-1`, `j: 1 → n-1` |
| 5 | Zero first row/column based on flags | First row & column |

---

## 💡 Key Insights

✅ Using matrix itself to store state saves O(m+n) extra space  
✅ Two-pass approach: first collect info → then apply changes  
✅ First row and column act as "marker rows/columns"  
✅ Time: O(m×n), Space: O(1)  

---

## ❌ Common Mistakes

1. **Using matrix[0][*] and matrix[*][0] directly without saving original state**
2. **Breaking the inner loop when a row is marked (misses column markers)**
3. **Not handling first row/column separately at the end**
4. **Processing from [0][0] instead of [1][1] (overwrites markers)**
5. **Forgetting to check BOTH firstRowZero and firstColZero flags**

---

## 🔍 Example Walkthrough

```
Input:  [[1,1,1,1],
         [1,0,1,1],
         [1,1,1,0]]

After Step 1-2:  firstRowZero=false, firstColZero=false

After Step 3 (marking):
         [[1,0,1,0],    (marked columns 1 and 3)
          [1,0,1,1],    (marked row 1)
          [1,1,1,1]]    (marked row 2 - but wait, this is the marker setup phase)

After Step 4 (applying):
         [[1,0,1,0],
          [0,0,0,0],    (row marked as 0, so entire row zeroed)
          [0,0,0,0]]    (column 3 marked, so this cell zeroed)

Final Result: [[1,0,1,0],
               [0,0,0,0],
               [0,0,0,0]]
```
