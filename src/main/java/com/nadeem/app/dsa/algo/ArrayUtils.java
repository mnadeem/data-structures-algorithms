package com.nadeem.app.dsa.algo;

import java.awt.Point;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.logging.Logger;

import com.nadeem.app.dsa.adt.impl.ArrayHeap;
import com.nadeem.app.dsa.support.MutableInteger;

public final class ArrayUtils {
	private static final Logger LOGGER = Logger.getLogger(ArrayUtils.class.getName());

	private ArrayUtils () {

	}

	public static <T extends Comparable<? super T>> void reverse(T[] seed) {
		reverse(seed, 0, seed.length);
	}

	public static <T extends Comparable<? super T>> void reverse(T[] seed, int startIndexInclusive, int endIndexExclusive) {
		if (seed == null || seed.length == 0) {
			LOGGER.warning("Nothing to rotate");
		}
		int start = startIndexInclusive < 0 ? 0 : startIndexInclusive;
		int end = Math.min(seed.length, endIndexExclusive) - 1;
		while (start < end) {
			swap(seed, start, end);
			start++;
			end--;
		}
	}

	private static <T extends Comparable<? super T>> void swap(T[] seed, int firstIndex, int secondIndex) {
		T temp =  seed[firstIndex];
		seed[firstIndex] = seed[secondIndex];
		seed[secondIndex] = temp;
	}

	public static <T extends Comparable<? super T>> T[] immutableRotate(T[] seed, int numberOfPositions) {
		int length = seed.length;
		@SuppressWarnings("unchecked")
		T[] result =  (T[]) new Comparable[length];
		for (int i = 0; i < seed.length; i++) {
			result[i] = seed[(i+numberOfPositions)%length];
		}
		return result;
	}

	public static <T extends Comparable<? super T>>  void mutableRotate(T[] seed, int numberOfPositions) {
		reverse(seed, 0, numberOfPositions);
		reverse(seed, numberOfPositions, seed.length);
		reverse(seed, 0, seed.length);
	}

	public static <T> void mutableRotateMinSwap(T[] seed, int numberOfPositions) {

		for (int setIndex = 0; setIndex < MathUtil.iGCD(seed.length, numberOfPositions); setIndex++) {
			swapElementsInSet(seed, numberOfPositions, setIndex);
		}		
	}

	private static <T> void swapElementsInSet(T[] seed, int numberOfPositions, int setIndex) {
		int length = seed.length;
		T temp = seed[setIndex];
		int firstIncrementor = setIndex;
		int secondIncrementor;
		while(true) {
			secondIncrementor = firstIncrementor + numberOfPositions;
			if(secondIncrementor >= length) {
				secondIncrementor = secondIncrementor - length;
			}
			if (secondIncrementor == setIndex) {
				break;
			}				
			seed[firstIncrementor] = seed[secondIncrementor];
			firstIncrementor = secondIncrementor;
		}
		seed[firstIncrementor] = temp;
	}

	public static <T extends Comparable<? super T>> void mutableSelectionSort(T[] collection) {
		int endIndex = collection.length;
		for (int currentIndex = 0; currentIndex < endIndex; currentIndex++) {
			int minIndex = minIndex(collection, currentIndex, endIndex);
			if (currentIndex < minIndex) {
				swap(collection, currentIndex, minIndex);
			}
		}		
	}

	private static <T extends Comparable<? super T>> int minIndex(T[] collection, int startIndexInclusive, int endIndexExclusive) {
		int minIndex = startIndexInclusive;
		for (int i = startIndexInclusive + 1; i < endIndexExclusive; i++) {
			if (collection[i].compareTo(collection[minIndex]) < 0) {
				minIndex = i;
			}
		}
		return minIndex;
	}

	public static <T extends Comparable<? super T>> void mutableBubbleSort(T[] collection) {
		int endIndex = collection.length - 1;
		for (int currentIteration = 0; currentIteration < endIndex; currentIteration++) {
			bubbleUp(collection, currentIteration, endIndex);
		}	
	}

	private static <T extends Comparable<? super T>> void bubbleUp(T[] collection, int currentIteration, int endIndex) {
		for (int currentIndex = endIndex; currentIndex > currentIteration; currentIndex--) {
			if(collection[currentIndex].compareTo(collection[currentIndex-1]) < 0) {
				swap(collection, currentIndex, currentIndex-1);
			}
		}
	}

	public static <T extends Comparable<? super T>> void mutableInsertionSort(T[] collection) {
		for (int index = 1; index < collection.length; index++)	{
			shiftAndInsert(collection, 1, index);
		}		
	}

	static <T extends Comparable<? super T>> void insert(T[] collection, int index) {
		T value = collection[index];
		int position = index;
		// Shift larger values to the right
		while (position > 0 && collection[position-1].compareTo(value) > 0)	{
			collection[position] = collection[position-1];
			position--;
		}
		collection[position] = value;//Insert into proper location
	}

	public static <T extends Comparable<? super T>> void mutableShellSort(T[] collection) {
		int interval = 1;
		int length = collection.length;
		while (interval < length / 3) {
			interval = interval * 3 + 1;
		}
		while (interval > 0) {
			for (int outer = interval; outer < length; outer++) {
				shiftAndInsert(collection, interval, outer);
			}
			interval = (interval - 1)/3;
		}
	}

	private static <T extends Comparable<? super T>> void shiftAndInsert(T[] collection, int interval, int outer) {
		T value = collection[outer];
		int inner= outer;
		// Shift larger values to the right
		while(inner > 0  && collection[inner - interval].compareTo(value) > 0) {
			collection[inner]= collection[inner - interval];
			inner = inner- interval;
		}
		//insert the number at correct, whole position
		collection[inner] = value;
	}

	public static <T extends Comparable<? super T>> void merge(T[] collection, int low, int mid, int high) {
		T[] tmp = doMerge(collection, low, mid, high);
		copyResult(collection, tmp, low);
	}

	private static <T extends Comparable<? super T>>  void copyResult(T[] collection, T[] tmp, int start) {
		for (int i = 0; i < tmp.length; i++) {
			collection[start+i] = tmp[i];
		}
		//System.arraycopy(tmp, 0, collection, start, tmp.length);
	}

	private static <T extends Comparable<? super T>> T[] doMerge(T[] collection, int low, int mid, int high) {
		int index = 0;
		int leftIndex = low;
		int rightIndex = mid + 1;
		@SuppressWarnings("unchecked")
		T[] tmp = (T[])new Comparable[high - low + 1];
		while(leftIndex <=mid || rightIndex <=high) {
			if(leftIndex > mid) {
				tmp[index++] = collection[rightIndex++];
			} else if(rightIndex > high) {
				tmp[index++] = collection[leftIndex++];
			} else	if (collection[leftIndex].compareTo(collection[rightIndex]) < 0) {
				tmp[index++]=collection[leftIndex++];
			} else {
				tmp[index++]=collection[rightIndex++];
			}
		}
		return tmp;
	}
	/**
	 * Refer this http://www.cs.nthu.edu.tw/~wkhon/algo08-tutorials/tutorial1b.pdf
	 * @param collection
	 * @param low
	 * @param mid
	 * @param high
	 */
	public static <T extends Comparable<? super T>>  void inPlaceMerge(T[] collection, int low, int mid, int high) {
		int left = low;
		int right = mid + 1;
		
		if(collection[mid].equals(collection[right])) {
			return ;//Skip the merge if required
		}
		while (left <= mid && right <= high) {			
			// Select from left:  no change, just advance left
			if (collection[left].compareTo(collection[right]) <= 0) {
				left ++;
			} else { // Select from right:  rotate [left..right] and correct
				T tmp = collection[right]; // Will move to [left]
				rotateRight(collection, left, right - left);
				collection[left] = tmp;
				// EVERYTHING has moved up by one
				left ++; right ++; mid ++;
			}
		}		
	}

	private static <T extends Comparable<? super T>> void rotateRight(T[] collection, int left, int numberOfElements) {
		System.arraycopy(collection, left, collection, left+1, numberOfElements);		
	}

	public static <T extends Comparable<? super T>> void recursiveMergeSort(T[] seed) {
		recursiveMergeSort(seed, 0, seed.length - 1);
	}

	private static <T extends Comparable<? super T>> void recursiveMergeSort(T[] seed, int start, int end) {
		if (start < end) {		
			int mid = (start + end)/2;
			recursiveMergeSort(seed, start, mid);
			recursiveMergeSort(seed, mid+1, end);
			merge(seed, start, mid, end);
		}
	}

	public static <T extends Comparable<? super T>> void iterativeMergeSort(T[] seed) {

		for (int i = 1; i <seed.length; i=i+i)
	    {
	        for (int j = 0; j < seed.length - i; j = j + i+i)
	        {
	        	inPlaceMerge(seed, j, j + i-1, Math.min(j+i + i -1, seed.length -1));
	        }
	    }		
	}

	public static <T extends Comparable<? super T>> void recursiveQuickSort(T[] seed) {
		doRercursiveQuickSort(seed, 0, seed.length - 1);		
	}

	private static <T extends Comparable<? super T>> void doRercursiveQuickSort(T[] seed, int low, int high) {
		if (low < high) {
			int partitionIndex = inplacePartitionIndex(seed, low, high);
			doRercursiveQuickSort(seed, low, partitionIndex - 1);
			doRercursiveQuickSort(seed, partitionIndex+1, high);			
		}
	}

	private static <T extends Comparable<? super T>> int inplacePartitionIndex(T[] seed, int lo, int hi) {
		int left = lo;
        int right = hi - 1;
        T partitionElement = seed[hi];
        while (left <=right) { 

        	// scan until reaching value equal or larger than pivot (or right marker)
            while (left <= right &&(seed[left].compareTo(partitionElement) < 0))
                left++;

            // scan until reaching value equal or smaller than pivot (or left marker)
            while (left <= right &&(seed[right].compareTo(partitionElement) > 0))
                right--;

            // check if pointers cross
            if (left <= right) { // indices did not strictly cross
            	// so swap values and shrink range
            	swap(seed, left, right);
	            left++;
	            right--;
            }
        }

        // put pivot into its final place (currently marked by left index)
        swap(seed, left, hi);

        return left;
	}

	public static <T extends Comparable<? super T>> void iterativeQuickSort(T[] seed) {
		doIterativeQuickSort(seed, 0, seed.length -1);
	}

	private static <T extends Comparable<? super T>> void doIterativeQuickSort(T[] seed, int lo, int hi) {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.push(lo);
		stack.push(hi);

		while (!stack.isEmpty()) {
			int high = stack.pop();
			int low = stack.pop();

			int partitionIndex = inplacePartitionIndex(seed, low, high);

			if (partitionIndex - 1 > low) {
				stack.push(low);
				stack.push(partitionIndex - 1);
			}
			if (partitionIndex + 1 < high) {
				stack.push(partitionIndex + 1);
				stack.push(high);
			}			
		}
	}
	
	public static <T extends Comparable<? super T>> void iterativeMaxHeapSort(T[] seed) {
		ArrayHeap<T> heap = new ArrayHeap<T>(seed.length);
		for (int i = 0; i < seed.length; i++) {
			heap.enqueue(seed[i]);
		}
		for (int i = 0; i < seed.length; i++) {
			seed[i] = heap.dequeue();
		}
	}

	

	public static int nextHigherNumber(int number) {
		Integer[] array = convertToArray(number);
		int pivotIndex = pivotMaxIndex(array);
		int digitInFirstSequence = pivotIndex -1;
		int lowerDigitIndexInSecondSequence = lowerDigitIndex(array[digitInFirstSequence], array, pivotIndex);
		swap(array, digitInFirstSequence, lowerDigitIndexInSecondSequence);
		doRercursiveQuickSort(array, pivotIndex, array.length - 1);
		return arrayToInteger(array);
	}

	private static int pivotMaxIndex(Integer[] array) {
		int index = array.length - 1;
		while(index > 0) {
			if (array[index-1] < array[index]) {
				break;
			}
			index--;
		}		
		return index;
	}

	private static int lowerDigitIndex(int number, Integer[] array, int fromIndex) {
		int lowerMaxIndex = fromIndex;
		int lowerMax = array[lowerMaxIndex];
		while (fromIndex < array.length - 1) {
			if (array[fromIndex]> number && lowerMax > array[fromIndex]) {
				lowerMaxIndex = fromIndex; 
			}
			fromIndex ++;
		}
		return lowerMaxIndex;
	}

	public static Integer[] convertToArray(int number) {
	    int i = 0;
	    int length = (int) Math.log10(number);
	    int divisor = (int) Math.pow(10, length);
	    Integer temp[] = new Integer[length + 1];

	    while (number != 0) {
	        temp[i] = number / divisor;
	        if (i < length) {
	            ++i;
	        }
	        number = number % divisor;
	        if (i != 0) {
	            divisor = divisor / 10;
	        }
	    }
	    return temp;
	}
	public static int arrayToInteger(Integer[] array) {
		int number = 0;
		for (int i = 0; i < array.length; i++) {
			number+=array[i] * Math.pow(10, array.length-1-i);
		}
		return number;
	}

	public static int trappedWaterVolume(int[] heights) {
		int[] leftBar = new int[heights.length];
		int[] rightBar = new int[heights.length];
		
		leftBar[0] = 0;
		for (int i = 1; i < leftBar.length; i++) {
			leftBar[i] = Math.max(leftBar[i-1], heights[i-1]);
		}
		
		rightBar[rightBar.length - 1] = 0;
		for (int i = rightBar.length - 2; i >= 0; i--) {
			rightBar[i] = Math.max(rightBar[i+1], heights[i+1]);
		}
		
		int volume = 0;
		for (int i = 0; i < heights.length; i++) {
			int currentVolume = Math.min(leftBar[i], rightBar[i]) - heights[i];
			if (currentVolume > 0) {
				volume += currentVolume;
			}
		}		
		return volume;
	}
	/**
	 * 
	 *@see <a href="http://stackoverflow.com/a/2680697/1709793">For Refrence</a>
	 */
	public static int[] product(int[] nums) {
		int[] products = new int[nums.length];
		int p =1;
		for (int i = 0; i < nums.length; i++) {
			products[i] = p;
			p*=nums[i];
		}
		p = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			products[i] *= p;
			p *=nums[i];
		}
		
		return products;
	}

	public static int maxPlatforms(Integer[] arr, Integer[] dep) {
		recursiveMergeSort(arr);
		recursiveMergeSort(dep);
		int platforms =0;
		int maxPlatforms = 0;
		int arrivalIndex=0, departIndex=0;
		while (arrivalIndex < arr.length && departIndex < arr.length) {
			if (arr[arrivalIndex] < dep[departIndex]) {
				platforms++;
				arrivalIndex++;
				if (platforms > maxPlatforms) {
					maxPlatforms = platforms;
				}
			} else {
				platforms --;
				departIndex++;
			}
		}

		return maxPlatforms;
	}
	//Refer this http://stackoverflow.com/a/5117685/1709793
	public static void arrangeToFormBiggestNumberLexicographically(Integer[] seed) {
		Arrays.sort(seed, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				String ab = String.valueOf(o1) + String.valueOf(o2);
				String ba = String.valueOf(o2) + String.valueOf(o1);
				return ba.compareTo(ab);
			}
		});
		
	}

	public static Integer[] nextGreaterElements(Integer[] items, PrintStream stream) {
		Integer[] result = new Integer[items.length];
		Deque<NextGenItem> stack = new ArrayDeque<NextGenItem>(items.length);
		stack.push(new NextGenItem(items[0], 0));
		for (int i = 1; i < result.length; i++) {
			while (!stack.isEmpty() && stack.peek().element < items[i]) {
				NextGenItem nextGen = stack.pop();
				result[nextGen.index] = items[i];
				//stream.println(String.format("Next Greater Element of %d is %d", nextGen.element, items[i]));
			}
			stack.push(new NextGenItem(items[i], i));
		}
		while (!stack.isEmpty()) {
			NextGenItem nextGen = stack.pop();
			result[nextGen.index] = null;
			//stream.println(String.format("No Next Greater Element for  %d ", stack.pop()));			
		}
		
		return result;
	}
	
	private static class NextGenItem {
		public Integer element;
		public int index;
		public NextGenItem(Integer ele, int ind) {
			this.element = ele;
			this.index = ind;
		}
	}

	public static int maxSum(int[] array) {
		int currentSum=array[0], maxSum = array[0];
		for (int i = 1; i < array.length; i++) {
			currentSum = Math.max(currentSum + array[i], array[i]);
			if (currentSum > maxSum) {
				maxSum = currentSum;
			}
		}
		return maxSum;
	}

	public static int firstRepeatingElement(int[] elements) {
		int index = -1;
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = elements.length - 1; i >=0; i--) {
			if (set.contains(elements[i])) {
				index = i;
			}
			set.add(elements[i]);
		}
		if (index != -1) {
			return elements[index];
		}
		throw new IllegalArgumentException("No repeating elements found");
	}

	public static int largestDifference(int[] data) {
		int minElement=data[0], maxDifference=0;
		
		for (int i = 1; i < data.length; i++) {
			minElement = Math.min(minElement, data[i]);
			maxDifference = Math.max(maxDifference, data[i] - minElement);
		}
		return maxDifference;
	}

	public static int maxProfitOneTransaction(int[] stockPrices) {
		int maxProfit = 0, minPrice = stockPrices[0];
		for (int i = 0; i < stockPrices.length; i++) {
			minPrice = Math.min(minPrice, stockPrices[i]);
			maxProfit = Math.max(maxProfit, stockPrices[i] - minPrice);
		}		
		return maxProfit;
	}

	public static int maxProfitTwoTransaction(int[] stockPrices) {
		int[] profit = new int[stockPrices.length];
		int minPrice = stockPrices[0];
		for (int i = 1; i < stockPrices.length; i++) {
			minPrice = Math.min(minPrice, stockPrices[i]);
			profit[i] = Math.max(profit[i - 1], stockPrices[i] - minPrice);
		}
		int maxProfit = 0;
		int maxPrice = stockPrices[stockPrices.length-1];
		int maxTotalProfit = 0;
		for (int i = stockPrices.length-1; i > 0; i--) {
			maxPrice = Math.max(maxPrice, stockPrices[i]);
			maxProfit = Math.max(maxProfit, maxPrice - stockPrices[i]);
			maxTotalProfit = Math.max(maxTotalProfit, maxProfit + profit[i - 1]);
		}
		return maxTotalProfit;
	}

	public static int maxProfitMultipleNonOverlappingTransaction(int[] stockPrices) {
		int profit = 0;
		for (int i = 1; i < stockPrices.length; i++) {
			profit += Math.max(0, stockPrices[i] - stockPrices[i-1]);
		}
		return profit;
	}
	
	// Refer http://stackoverflow.com/questions/9514191/maximizing-profit-for-given-stock-quotes
	// http://stackoverflow.com/questions/9514191/maximizing-profit-for-given-stock-quotes
	//https://github.com/benyl/leetcode/blob/master/Best%20Time%20to%20Buy%20and%20Sell%20Stock%20(I%20%26%20II%20%26%20III).cc
	public static int maximizeProfit(int[] stockValues) {
		int[] doBuy = new int[stockValues.length];
		for (int i = 0; i < doBuy.length; i++) {
			doBuy[i] = 1; //1 for buy, 0 for sell
		}
		int maxProfitSoFar = 0;
		int profit = 0;
		for (int i = stockValues.length - 1; i >=0; i--) {
			if (maxProfitSoFar < stockValues[i]) {
				doBuy[i] = 0;
				maxProfitSoFar = stockValues[i];
			}
			profit += maxProfitSoFar - stockValues[i];
		}
		System.out.println(String.format(" %d %s", profit, Arrays.toString(doBuy)));
		return profit;
	}

	public static int zeroIndexToGetMaxOnes(int[] binArray) {
		int prevPrevIndex = -1, prevIndex = -1,currentLenght= -1, maxLenght = -1, requiredIndex = -1;
		
		for (int currentIndex = 0; currentIndex < binArray.length; currentIndex++) {
			if (binArray[currentIndex] == 0) {
				if (prevPrevIndex != -1) {
					currentLenght = currentIndex - (prevPrevIndex + 1);
					if (currentLenght > maxLenght) {
						maxLenght = currentLenght;
						requiredIndex = prevIndex;
					}
				}
				prevPrevIndex = prevIndex;
				prevIndex = currentIndex;
			} else {// case when last element is not zero, and input contains more than 3 zeros
				if (prevIndex != -1 && prevPrevIndex != -1) {
					currentLenght = currentIndex - (prevPrevIndex + 1);
					if (currentLenght > maxLenght) {
						maxLenght = currentLenght;
						requiredIndex = prevIndex;
					}
				}
			}
		}

		if (maxLenght == -1) { // less than three zeros
			if (prevPrevIndex != -1) { // 2 zeros
				if (prevIndex > (binArray.length - prevPrevIndex - 1)) {
					requiredIndex = prevPrevIndex;
				} else {
					requiredIndex = prevIndex;
				}
				
			} else { // one zero
				requiredIndex = prevIndex;
			}
		}
		return requiredIndex;
	}

	public static int[] zeroIndexToGetMaxOnes(int[] arr, int maxZeroes) {
		// Left and right indexes of current window
		int wL = 0, wR = 0;

		// Left index and size of the widest window
		int bestL = 0, bestWindow = 0;

		// Count of zeroes in current window
		int zeroCount = 0;

		// While right boundary of current window doesn't cross
		// right end
		while (wR < arr.length) {
			// If zero count of current window is less than m,
			// widen the window toward right
			if (zeroCount <= maxZeroes) {
				if (arr[wR] == 0)
					zeroCount++;
				wR++;
			}

			// If zero count of current window is more than m,
			// reduce the window from left
			if (zeroCount > maxZeroes) {
				if (arr[wL] == 0)
					zeroCount--;
				wL++;
			}

			// Updqate widest window if this window size is more
			if (wR - wL > bestWindow) {
				bestWindow = wR - wL;
				bestL = wL;
			}
		}

		int result[] = new int[maxZeroes];
		int resultIndex = 0;
		for (int i = 0; i < bestWindow; i++) {
			if (arr[bestL + i] == 0) {
				result[resultIndex] = bestL + i;
				resultIndex++;
			}
		}
		return result;
	}

	public static int maxInSortedRotatedArray(int[] array) {
		return doMaxInSortedRotatedArray(array, 0, array.length - 1);
	}

	private static int doMaxInSortedRotatedArray(int[] array, int low, int high) {
		if (low > high) {
			return -1;
		} else if (low == high) {
			return low;
		}
		int mid = low + (high - low)/2;
		if (low < mid && array[low] > array[low + 1]) {
			return low;
		} else if(mid < high && array[mid] > array [mid + 1]) {
			return mid;
		} else if (mid > low && array[mid] < array[mid - 1]) {
			return mid - 1;
		}

		if (array[mid] < array[mid + 1]) {
			return doMaxInSortedRotatedArray(array, mid + 1, high);
		} else {
			return doMaxInSortedRotatedArray(array, low, mid - 1);
		}
	}
	
	//https://www.careercup.com/question?id=5767484059680768
	public static int numberOfMazePaths(int[][] maze) {
		MutableInteger numberOfPaths = new MutableInteger(0);
		List<Point> visited = new ArrayList<Point>();
		List<Point> endsVisited = new ArrayList<Point>();
		for (int i = 0; i < maze[0].length; i++) {
			visited.clear();
			endsVisited.clear();
			if (isValidMazeEntry(maze, 0, i)) {
				traverseMaze(maze,  visited, endsVisited, numberOfPaths, 0, i);
			}
		}
		return numberOfPaths.getValue();
	}

	private static boolean isValidMazeEntry(int[][] maze, int row, int column) {
		int ENTRY_POINT = 1;
		return maze[row][column] == ENTRY_POINT;
	}

	private static void traverseMaze(int[][] maze, List<Point> visited, List<Point> endsVisited, MutableInteger numberOfPaths, int row, int column) {
		if (isValidMazeLocation(maze, visited, row, column)) {
			visited.add(new Point(row, column));
			if (isValidExit(maze,endsVisited,  row, column)) {
				endsVisited.add(new Point(row, column));
				visited.clear();
				numberOfPaths.increment();
			} else {
				traverseMaze(maze,visited, endsVisited,numberOfPaths, row + 1, column);
				traverseMaze(maze,visited,endsVisited,numberOfPaths, row -1, column);
				traverseMaze(maze,visited,endsVisited, numberOfPaths, row, column + 1);
				traverseMaze(maze,visited,endsVisited,numberOfPaths, row, column - 1);
			}			
		}
	}

	private static boolean isValidMazeLocation(int[][] maze, List<Point> visited, int row, int column) {
		int INVALID_PATH = -1;
		boolean result = false;
		if (row >= 0 && row < maze.length && column >= 0 && column < maze[row].length) {
			if (maze[row][column] != INVALID_PATH && !visited.contains(new Point(row, column))) {
				result = true;
			}		
		}
		return result;
	}

	private static boolean isValidExit(int[][] maze, List<Point> endsVisited, int row, int column) {
		int EXIT_POINT = 2;
		return row == maze.length-1 && maze[row][column] == EXIT_POINT && !endsVisited.contains(new Point(row, column));
	}

	public static Integer[] commonElementsIn3SortedArrays(int[] arr1, int[] arr2, int[] arr3) {
		List<Integer> result = new ArrayList<Integer>();
		int i=0, j=0, k=0;
		while (i < arr1.length && j < arr2.length && k < arr3.length) {
			
			if (arr1[i] == arr2[j] && arr2[j]== arr3[k]) {
				result.add(arr1[i]);
				i++;j++;k++;
			} else if (arr1[i] < arr2[j]) {
				i++;
			} else if (arr2[j] < arr3[k]) {
				j++;
			} else {
				k++;
			}
		}		
		return result.toArray(new Integer[0]);
	}

	public static Integer[] commonElementsInNSortedArrays(int[][] arrays) {
		int baseIndex = 0, currentIndex = 0, totalMatchFound= 0;
		int[] indices = new int[arrays.length - 1];
		boolean smallestArrayTraversed = false;
		List<Integer> result = new ArrayList<Integer>();
		while (!smallestArrayTraversed && baseIndex < arrays[0].length) {
			totalMatchFound = 0;
			for (int array = 1; array < arrays.length; array++) {
				currentIndex = indices[array - 1];
				while (currentIndex < arrays[array].length && arrays[array][currentIndex] < arrays[0][baseIndex]) {
					currentIndex ++;					
				}

				if (currentIndex < arrays[array].length) {
					if (arrays[array][currentIndex] == arrays[0][baseIndex]) {
						totalMatchFound++;
					}
				} else {
					smallestArrayTraversed = true;
				}
				indices[array - 1] = currentIndex;
			}
			if (totalMatchFound == arrays.length - 1) {
				result.add(arrays[0][baseIndex]);
			}
			baseIndex++;
		}

		return result.toArray(new Integer[0]);
	}
	
	public static int findMissingInSortedSeq(int[] intArray, int left, int right) {
	    if (right == left + 1) return intArray[right] - 1;
	    int pivot = left + (right - left) / 2;
	    if (intArray[pivot] == intArray[left] + (intArray[right] - intArray[left]) / 2 - (right - left) % 2)
	        return findMissingInSortedSeq(intArray, pivot, right);
	    else 
	        return findMissingInSortedSeq(intArray, left, pivot);
	}

	public static int transitionPoint(int[] array) {
		return findTransitionPoint(array, 0 , array.length - 1);
	}

	private static int findTransitionPoint(int[] array, int startIndex, int endIndex) {
		int start = startIndex;
		int end = startIndex + 1;
		while (end < endIndex && array[end] != 1) {
			start = end;
			end <<= 1;			
		}
		int mid = (start + end) / 2;
		
		while(start < end && array[start + 1] != 1) {
			if (array[mid] == 0) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		if (start == end) {
			return -1;
		}
		
		return start + 1;
	}
	
	public static <T extends Comparable<? super T>> MaxMin<T> findMaxMin(T[] seed) {
		int length = seed.length;
		int start;
		T max, min;
		if (length%2 ==0) {
			if (seed[0].compareTo(seed[1]) < 0 ) {
				min = seed[0];
				max = seed[1];
			} else {
				min = seed[1];
				max = seed[0];
			}
			start = 2;
		} else {
			min = seed[0];
			max = seed[0];
			start = 1;
		}
		while (start < length-1) {

			if (seed[start].compareTo(seed[start+1]) <0) {
				if(min.compareTo(seed[start]) > 0) {
					min = seed[start];
				}
				if(max.compareTo(seed[start+1]) <0) {
					max = seed[start+1];
				}
			} else {
				if(min.compareTo(seed[start+1]) > 0) {
					min = seed[start+1];
				}
				if(max.compareTo(seed[start]) <0) {
					max = seed[start];
				}
			}
			start = start +2;			
		}		

		return new MaxMin<T>(min, max);
	}

	public final static  class MaxMin<T extends Comparable<? super T>> {
		private T max;
		private T min;
		public MaxMin(T newMin, T newMax) {
			this.min = newMin;
			this.max = newMax;
		}
		public T getMax() {
			return max;
		}
		public T getMin() {
			return min;
		}

	}

	public static int connectRopesWithMinCost(int[] costs) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int i = 0; i < costs.length; i++) {
			minHeap.add(costs[i]);
		}
		int minCost = 0;
		while(minHeap.size() > 1) {
			int first = minHeap.poll();
			int second = minHeap.poll();
			int combined = first + second;
			minCost += combined;
			minHeap.add(combined);
		}
		return minCost;
	}
}
