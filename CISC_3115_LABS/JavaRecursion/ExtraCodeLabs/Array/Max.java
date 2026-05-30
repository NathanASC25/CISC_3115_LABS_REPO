class Max {

int max(int arr[], int n) {
	if (n == 0) return -1;
	if (n == 1) return arr[0];
	// int maxVal = arr[0];
	// int otherVal = arr[n - 1];
	// if (otherVal > maxVal && n <= 2) {
	//     return otherVal;	
	// }
	int maximum = arr[n - 1];
	if (maximum > arr[0]) return maximum;
	return max(arr, n - 1);
}

}
