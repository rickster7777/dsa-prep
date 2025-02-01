// var peakIndexInMountainArray = function (arr) {
//     let len = arr.length - 1;

//     let n = Math.floor(len / 2);
//     let m = Math.ceil(len / 2)

//     let max = Math.max(arr[n], arr[m]);

//     if (arr[n] === max) {
//         return n;
//     }
//     return m;
// };


var peakIndexInMountainArray = function (arr) {
    let peak = -1;
    mount = -1;

    for (let i = 1; i < arr.length - 1; i++) {
        if (arr[i] > mount) {
            mount = arr[i];
            peak = i;
        }
    }
    return peak;
};
//const arr = [0,10,5,2];
// const arr = [0,1,0];
 const arr = [0, 2, 1, 0];
console.log(peakIndexInMountainArray(arr));