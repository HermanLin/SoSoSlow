# SoSoSlow
Elaina Chung, Herman Lin, Lisa Eng

### Methodology
We ran 10 test cases 3 times each. We had chosen specific pivot positions to test each of the cases. The arrays were sorted and shuffled for the average case times. We used nanotime to time the program. 

### Runtime
##### Best Case: 
The best case runtime is O(nlogn). The partition is split in half each time.
##### Average Case:
The average case runtime is O(nlogn). The partition is split in roughly half each time.
##### Worst Case: 
The worst case runtime is O(n^2). The partition would just be one less than the previous.

### Time Measurements 
Our time measurements could be found here: https://docs.google.com/spreadsheets/d/1xQ-2bd2vyjtYSK553P0R_-8GQfpuf9PmwxuVHBtyXyQ/edit#gid=0. We saw that our hypothesis about the best, worst, and average case is correct. The outliers of the problem seem to be the first test as usual. 

### Pivot Selection and Data Arrangement
The pivot selection effects the runtime a lot. For the worse case, the pivot selection would be the least or the greatest value in the array, so the partition would only be one less, especially if the array is already sorted. The best case would be when the pivot is the median, so the partition would be halfed each time. 
