let c = [];
function permute(str, arr) {
    if (arr.length == 0 && !c.includes(str)) {
        c.push(str);
    } else {
        for (let i = 0; i < arr.length; i++) {
            let arr2 = arr.slice();
            arr2.splice(i, 1);
            permute(str + arr[i], arr2);
        }
    }
}

permute("", "this".split(""));
console.log(c);