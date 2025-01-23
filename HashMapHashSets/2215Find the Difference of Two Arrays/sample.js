var findDifference = function (nums1, nums2) {
    let set1 = new Set(nums1);
    let set2 = new Set(nums2);


    let result = [
        [...set1].filter(x => !set2.has(x)),
        [...set2].filter(x => !set1.has(x))
    ];

    return result;
};

const nums1 = [1, 2, 3], nums2 = [2, 4, 6];

console.log(findDifference(nums1, nums2));