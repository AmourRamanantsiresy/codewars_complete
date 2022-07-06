//let count = 0, x = 0, y = 0, pos = true, dir = true, moins = 0, rotate = 0, x2 = 0, y2 = 0;

/**
   The function spriralize returns an array containing 0 and 1 whose shape is a spiral
    like : spiralize(5) 
    1 1 1 1 1 1 1 1 1 1 
    0 0 0 0 0 0 0 0 0 1 
    1 1 1 1 1 1 1 1 0 1 
    1 0 0 0 0 0 0 1 0 1 
    1 0 1 1 1 1 0 1 0 1 
    1 0 1 0 0 1 0 1 0 1 
    1 0 1 0 0 0 0 1 0 1 
    1 0 1 1 1 1 1 1 0 1 
    1 0 0 0 0 0 0 0 0 1 
    1 1 1 1 1 1 1 1 1 1 
 */

function spiralize(n) {
    let count = 0, x = 0, y = 0,
        x1 = -1, y1 = -1,
        pos = true, dir = true,
        moins = 0, rotate = 0;
    let res = createTable(n);
    while (!(x === x1 && y === y1)
        && !(x === x1 - 1 && y === y1)
        && !(x === x1 && y === y1 - 1)
        && !(x === x1 && y === y1 + 1)
        && !(x === x1 + 1 && y === y1)
    ) {
        x1 = x, y1 = y;
        if (dir) {
            for (let i = pos ? x : y; i < res.length - moins; i++) {
                pos ? x = i : y = i;
                res[pos ? y : i][pos ? i : x] = 1;
            } if (!pos) {
                dir = !dir;
            }
        } else {
            for (let i = pos ? x : y; i >= moins; i--) {
                pos ? x = i : y = i;
                res[pos ? y : i][pos ? i : x] = 1;
            } if (pos) {
                moins += 2;
            } else {
                dir = !dir;
            }
        } pos = !pos;
    }
    return res;
}


//function that create 2 dimensional table with 
//the length of the array inside the principal array
//and the length of the principal array are equals n
function createTable(n) {
    let res = [];
    for (let i = 0; i < n; i++) {
        let temp = [];
        for (let j = 0; j < n; j++) {
            temp.push(0);
        }
        res.push(temp);
    }
    return res;
}