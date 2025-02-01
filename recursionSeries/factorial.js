const fact = (n) => {

    //base case
    if (n === 0) {
        return 1;
    }


    let smallerProblem = n - 1;
    let biggerProblem = n * fact(smallerProblem);

    return biggerProblem;
}

const ans = fact(5);
console.log(ans);