## 🧠 Step-by-Step Idea

### 1. **Total Solutions Without Upper Limit**

We want to count the number of **non-negative integer solutions** to:

\[
x + y + z = n
\]

This is a classic **stars and bars** problem. The number of solutions is:

\[
\binom{n + 2}{2}
\]

Because we are distributing `n` candies into 3 parts (children), and each child can get zero or more candies.

---

### 2. **Subtract Invalid Cases (Inclusion-Exclusion)**

Invalid cases occur when **at least one child** gets **more than** the allowed number of candies (`limit`).

Let’s define:

- **A**: Solutions where \( x > \text{limit} \)
- **B**: Solutions where \( y > \text{limit} \)
- **C**: Solutions where \( z > \text{limit} \)

We apply the **inclusion-exclusion principle**:

\[
\text{Valid solutions} = \binom{n + 2}{2}
- (|A| + |B| + |C|)
+ (|A \cap B| + |A \cap C| + |B \cap C|)
- |A \cap B \cap C|
\]

---

### How to Compute \(|A|\):

If \( x > \text{limit} \), substitute:

\[
x' = x - (\text{limit} + 1)
\]

Then the equation becomes:

\[
x' + y + z = n - (\text{limit} + 1)
\]

Which is the same as counting:

\[
\binom{n - (\text{limit} + 1) + 2}{2}
\]

But **only if** the right-hand side is **≥ 0** (otherwise, it's 0).

Apply the same substitution logic for \(|B|\), \(|C|\), and their intersections.
