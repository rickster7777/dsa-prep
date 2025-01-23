// var asteroidCollision = function (asteroids) {
//     const stack = [];
//     stack.push(asteroids[0]);

//     asteroids.shift(); // to remove the first element.

//     for (const num of asteroids) {
//         if (stack[stack.length - 1] > 0 && num > 0) {
//             stack.push(num);
//         } else if (stack[stack.length - 1] < 0 && num < 0) {
//             stack.push(num);
//         } else if (stack[stack.length - 1] > 0 && num < 0) {
//             if (stack[stack.length - 1] > Math.abs(num)) {
//                 continue;
//             } else if (stack[stack.length - 1] < Math.abs(num)) {
//                 stack[stack.length - 1] = num;
//             } else if (stack[stack.length - 1] === Math.abs(num)) {
//                 stack.pop();
//             }
//         } else if (stack[stack.length - 1] < 0 && num > 0) {
//             if (Math.abs(stack[stack.length - 1]) > num) {
//                 continue;
//             } else if (Math.abs(stack[stack.length - 1]) < num) {
//                 stack[stack.length - 1] = num;
//             }
//         } else {
//             stack.splice(stack.length - 1);
//         }
//     }

//     return stack;
// };


// GPT solution
var asteroidCollision = function (asteroids) {
    const stack = [];

    for (let num of asteroids) {
        // Process the current asteroid
        let collision = false;
        
        while (stack.length > 0 && stack[stack.length - 1] > 0 && num < 0) {
            // Collision happens: check which asteroid survives
            if (stack[stack.length - 1] > Math.abs(num)) {
                collision = true;  // The current asteroid gets destroyed
                break;
            } else if (stack[stack.length - 1] < Math.abs(num)) {
                // Pop the right-moving asteroid from the stack
                stack.pop();
            } else {
                // Both asteroids are the same size and destroy each other
                stack.pop();
                collision = true;
                break;
            }
        }
        
        if (!collision) {
            // If no collision, add the current asteroid to the stack
            stack.push(num);
        }
    }

    return stack;
};

const asteroids = [10,2,-5];
console.log(asteroidCollision(asteroids));

