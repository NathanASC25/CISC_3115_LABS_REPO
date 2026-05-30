class ProductOffOdds {

int productOfOdds(int arr[], int n) {
    if (n == 1) {
    	if (arr[0] % 2 == 1) return arr[0];
    	return 1;
    }
    if (n == 2) {
        if (arr[0] % 2 == 1 && arr[1] % 2 == 1 && arr.length == 2) return arr[0] * arr[1];
        if (arr[1] % 2 == 1) return arr[1];
        return 1;
    }
    if (arr[0] % 2 == 1) {
    	if (arr[n - 1] % 2 == 0) return arr[0] * productOfOdds(arr, n - 1);
        return arr[0] * arr[n - 1] * productOfOdds(arr, n - 1);
    }
    else {
    	if (arr[n - 1] % 2 == 1) return arr[n - 1] * productOfOdds(arr, n - 1);
    	return productOfOdds(arr, n - 1);
    }
}

}
