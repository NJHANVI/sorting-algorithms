function bubble(arr) {
    let n = arr.length;
    for (let i =0;i <n-1; i++) {
        for (let j=0;j<n-1-i; j++) {
            if (arr[j] > arr[j + 1]) {
                let temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    return arr;
}
function selection(arr){
    let n= arr.length;
    for(let i=0;i<n-1;i++){
        let smallest=i;
        for(let j=i;j<n;j++){
            if(arr[j]<arr[smallest]){
                smallest=j;
            }
        }
        let  t=arr[smallest];
        arr[smallest]=arr[i];
        arr[i]=t;
    }
    return arr;
}

function conquer(arr, si, ei, mid) {
    let merged = [];
    let idx1 = si;
    let idx2 = mid + 1;
    while (idx1 <= mid && idx2 <= ei) {
        if (arr[idx1] <= arr[idx2]) {
            merged.push(arr[idx1++]);
        } else {
            merged.push(arr[idx2++]);
        }
    }
    while (idx1 <= mid) {
        merged.push(arr[idx1++]);
    }
    while (idx2 <= ei) {
        merged.push(arr[idx2++]);
    }
    for (let i = 0, j = si; i < merged.length; i++, j++) {
        arr[j] = merged[i];
    }
}
function divide(arr, si, ei) {
    if (si >= ei) {
        return;
    }
    let mid = si + Math.floor((ei - si) / 2);
    divide(arr, si, mid);
    divide(arr, mid + 1, ei);
    conquer(arr, si, ei, mid);
}
let arr1 = [10, 7, 8, 9, 1, 5];
let n = arr.length;
divide(arr, 0, n - 1);
for (let i = 0; i < n; i++) {
    console.log(arr[i]);
}
let arr = [10, 7, 8, 9, 1, 5];
let b_array = bubble(arr);
console.log("sorted array: " + sortedArr.join(" "));

let arr2 = [10, 7, 8, 9, 1, 5];
let s_array = selection(arr);
console.log("sorted array: " + sortedArr.join(" "));
