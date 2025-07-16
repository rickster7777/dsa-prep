def longestOnes(nums, k):
    left = 0
    max_length = 0
    zero_count = 0
    
    for right in range(len(nums)):
        # If nums[right] is 0, increment the zero_count
        if nums[right] == 0:
            zero_count += 1
        
        # If the zero_count exceeds k, move the left pointer to shrink the window
        while zero_count > k:
            if nums[left] == 0:
                zero_count -= 1
            left += 1
        
        # Update the maximum length of the window
        max_length = max(max_length, right - left + 1)
    
    return max_length

nums = [1,1,1,0,0,0,1,1,1,1,0]
k = 2
print(longestOnes(nums, k))