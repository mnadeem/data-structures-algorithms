package com.nadeem.app.dsa.algo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.nadeem.app.dsa.algo.ArrayUtils.MaxMin;

public class ArrayUtilsTest {
	private Integer[] seed;

	@Before
	public void doBeforeEachTestCase() {
		this.seed = new Integer[]{4,2,3,1,5,8,7,6};
	}

	@Test
	public void wholeArrayReverse() {
		ArrayUtils.<Integer>reverse(seed);
		assertThat(seed[0], is(6));
	}

	@Test
	public void partialArrayReverse() {
		ArrayUtils.<Integer>reverse(seed, 1, 5);
		assertThat(seed[1], is(5));
	}

	@Test
	public void imMutableRotationTest() {
		int numberOfPositions = 3;
		Object[] result =  ArrayUtils.<Integer>immutableRotate(seed, numberOfPositions);
		assertThat((Integer)result[0], is(1));
		assertThat((Integer)result[7], is(3));
	}

	@Test
	public void mutableRotationTest() {
		int numberOfPositions = 3;
		ArrayUtils.<Integer>mutableRotate(seed, numberOfPositions);
		assertThat(seed[0], is(1));
		assertThat(seed[7], is(3));
	}

	@Test
	public void mutableRotationMinSwapTest() {
		int numberOfPositions = 3;
		ArrayUtils.<Integer>mutableRotateMinSwap(seed, numberOfPositions);
		assertThat(seed[0], is(1));
		assertThat(seed[7], is(3));
	}

	@Test
	public void selectionSortFirstTest() {
		ArrayUtils.<Integer>mutableSelectionSort(seed);
		Integer[] result = new Integer[]{1,2,3,4,5,6,7,8};
		assertThat(seed, equalTo(result));
	}

	@Test
	public void bubbleSortFirstTest() {
		ArrayUtils.<Integer>mutableBubbleSort(seed);
		Integer[] result = new Integer[]{1,2,3,4,5,6,7,8};
		assertThat(seed, equalTo(result));
	}

	@Test
	public void insertionSortFirstTest() {
		ArrayUtils.<Integer>mutableInsertionSort(seed);
		Integer[] result = new Integer[]{1,2,3,4,5,6,7,8};
		assertThat(seed, equalTo(result));
	}

	@Test
	public void shellSortFirstTest() {
		ArrayUtils.<Integer>mutableShellSort(seed);
		Integer[] result = new Integer[]{1,2,3,4,5,6,7,8};
		assertThat(seed, equalTo(result));
	}

	@Test
	public void mergeArrayFirstTest() {
		Integer[] collection = new Integer[]{5,6,7,8,1,2,3,4};
		ArrayUtils.<Integer>merge(collection, 0,3,7);
		Integer[] result = new Integer[]{1,2,3,4,5,6,7,8};
		assertThat(collection, equalTo(result));
	}

	@Test
	public void inPlaceMergeFirstTest() {
		Integer[] collection = new Integer[]{5,6,7,8,1,2,3,4};
		ArrayUtils.<Integer>inPlaceMerge(collection, 0,3,7);
		Integer[] result = new Integer[]{1,2,3,4,5,6,7,8};
		assertThat(collection, equalTo(result));
	}
	
	@Test
	public void recursiveMergeSortFirstTest() {
		ArrayUtils.<Integer>recursiveMergeSort(seed);
		Integer[] result = new Integer[]{1,2,3,4,5,6,7,8};
		assertThat(seed, equalTo(result));
	
	}
	
	@Test
	public void iterativeMergeSortFirstTest() {
		ArrayUtils.<Integer>iterativeMergeSort(seed);
		Integer[] result = new Integer[]{1,2,3,4,5,6,7,8};
		assertThat(seed, equalTo(result));	
	}
	
	@Test
	public void recursiveQuickSortFirstTest() {
		ArrayUtils.<Integer>recursiveQuickSort(seed);
		Integer[] result = new Integer[]{1,2,3,4,5,6,7,8};
		assertThat(seed, equalTo(result));	
	}
	
	@Test
	public void iterativeQuickSortFirstTest() {
		ArrayUtils.<Integer>iterativeQuickSort(seed);
		Integer[] result = new Integer[]{1,2,3,4,5,6,7,8};
		assertThat(seed, equalTo(result));	
	}
	
	@Test
	public void iterativeHeapSortFirstTest() {
		ArrayUtils.<Integer>iterativeMaxHeapSort(seed);
		Integer[] result = new Integer[]{8,7,6,5,4,3,2,1};
		assertThat(seed, equalTo(result));	
	}
	
	
	@Test
	public void convertToArrayTest() {
		Integer[] array= ArrayUtils.convertToArray(1234);
		assertThat(array, equalTo(new Integer[]{1,2,3,4}));		
	}
	
	@Test
	public void arrangeToFormBiggestNumberLexicographicallyTest() {
		Integer[] input = new Integer[]{9,1,95,17,5};
		ArrayUtils.arrangeToFormBiggestNumberLexicographically(input);
		assertThat(input, equalTo(new Integer[]{9,95,5,17,1}));
		
		input = new Integer[]{54,546,548,60};
		ArrayUtils.arrangeToFormBiggestNumberLexicographically(input);
		assertThat(input, equalTo(new Integer[]{60,548,546,54}));
	}
	
	@Test
	public void arrayToIntegerTest() {
		Integer[] array = new Integer[]{1,2,3,4};
		assertThat(ArrayUtils.arrayToInteger(array), is(1234));
	}
	
	@Test
	public void nextHigherNumberTest() {
		assertThat(ArrayUtils.nextHigherNumber(34722641), is(34724126));
		assertThat(ArrayUtils.nextHigherNumber(123), is(132));
	}

	@Test
	public void trappedWaterVolumeTest() {
		int[] levels = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int volume = ArrayUtils.trappedWaterVolume(levels);
		assertThat(volume, is(6));
	}
	
	@Test
	public void productOfValidUndicesTest() {
		int[] levels = new int[]{2,3,4,5};
		int[] products = ArrayUtils.product(levels);
		assertThat(products, equalTo(new int[]{60, 40, 30, 24}));
	}
	@Test
	public void maxNumberOfPlatformsTest() {
		Integer arr[] = new Integer[] { 900, 940, 950, 1100, 1500, 1800 };
		Integer dep[] = new Integer[] { 910, 1200, 1120, 1130, 1900, 2000 };
		int maxPlatforms = ArrayUtils.maxPlatforms(arr, dep);
		assertThat(maxPlatforms, is(maxPlatforms));
	}
	
	@Test
	public void formBiggestNumberByConcArrayElementsTest() {
		Integer seed[] = new Integer[] {5,54,56};
		
		ArrayUtils.arrangeToFormBiggestNumberLexicographically(seed);
		assertThat(seed, equalTo(new Integer[]{56,5,54}));
		
		Integer[] array2 = new Integer[]{54, 546, 548, 60};
		ArrayUtils.arrangeToFormBiggestNumberLexicographically(array2);
		assertThat(array2, equalTo(new Integer[]{60,548,546,54}));
	}
	
	@Test
	public void nextGreaterElementTest() {
		Integer[] result = ArrayUtils.nextGreaterElements(new Integer[]{98, 23, 54, 12, 20, 7, 27}, System.out);
		assertThat(result, equalTo(new Integer[]{null, 54, null, 20, 27, 27, null}));
	}
	
	@Test
	public void maxSumArrayTest() {
		int maxSum = ArrayUtils.maxSum(new int[]{-2,1,-3,4,-1,2,1,-5,4});
		assertThat(maxSum, is(6));
		
		maxSum = ArrayUtils.maxSum(new int[]{-2,-1,-1,-4,-1,-2,-1,-5,-4});
		assertThat(maxSum, is(-1));
	}

	
	@Test
	public void firstRepeatingElementTest() {
		int [] elements = {1,2,5,7,5,3,10,2};
		int element = ArrayUtils.firstRepeatingElement(elements);
		assertThat(element, is(2));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void firstRepeatingElementTestWithException() {
		int [] elements = {1,2,5,7,3,10};
		int element = ArrayUtils.firstRepeatingElement(elements);
		assertThat(element, is(2));
	}

	@Test
	public void largestDifference() {
		int price[] = {10, 22, 5, 75, 65, 80};
		int maxProfit = ArrayUtils.largestDifference(price);
		assertThat(maxProfit, is(75));
	}


	@Test
	public void maxProfitWithOneTransactionTest() {
		int stockPrices[] = {100,80,120,130,70,60,100,125};
		int maxProfit = ArrayUtils.maxProfitOneTransaction(stockPrices);
		assertThat(maxProfit, is(65));
	}
	
	@Test
	public void maxProfitWithTwoTransactionsTest() {
		int stockPrices[] = {10, 22, 5, 75, 65, 80};
		int maxProfit = ArrayUtils.maxProfitTwoTransaction(stockPrices);
		assertThat(maxProfit, is(87)); 

		maxProfit = ArrayUtils.maxProfitTwoTransaction(new int[]{2, 30, 15, 10, 8, 25, 80});
		assertThat(maxProfit, is(100)); 
		
		maxProfit = ArrayUtils.maxProfitTwoTransaction(new int[]{100, 30, 15, 10, 8, 25, 80});
		assertThat(maxProfit, is(72)); 
		
		maxProfit = ArrayUtils.maxProfitTwoTransaction(new int[]{90, 80, 70, 60, 50});
		assertThat(maxProfit, is(0)); 
	}

	@Test
	public void maxProfitWithMultipleNonOverlappingTransactionsTest() {
		int stockPrices[] = {100, 180, 260, 310, 40, 535, 695};
		int maxProfit = ArrayUtils.maxProfitMultipleNonOverlappingTransaction(stockPrices);
		assertThat(maxProfit, is(865)); 
		
		stockPrices = new int[]{1,3,1,2};
		maxProfit = ArrayUtils.maxProfitMultipleNonOverlappingTransaction(stockPrices);
		assertThat(maxProfit, is(3)); 
	}

	@Test
	public void maximizeProfitTest() {
		int []stockValues = {1,3,1,2};
		int profit = ArrayUtils.maximizeProfit(stockValues);
		assertThat(profit, is(3));
	}
	
	@Test
	public void replace0ToGetMaxOnesTest() {
		int[] binArray = {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
		int index = ArrayUtils.zeroIndexToGetMaxOnes(binArray);
		assertThat(index, is(9));
		
		binArray = new int[]{1,0,1,1,1,0};
		index = ArrayUtils.zeroIndexToGetMaxOnes(binArray);
		assertThat(index, is(1));
		
		binArray = new int[]{0,1,1,1,0,1};
		index = ArrayUtils.zeroIndexToGetMaxOnes(binArray);
		assertThat(index, is(4));
		
		binArray = new int[]{1,1,1,0,1,0};
		index = ArrayUtils.zeroIndexToGetMaxOnes(binArray);
		assertThat(index, is(3));
		
		binArray = new int[]{0,1,1,1,0};
		index = ArrayUtils.zeroIndexToGetMaxOnes(binArray);
		assertThat(index, is(4));
		
		binArray = new int[]{1,1,1,1,0};
		index = ArrayUtils.zeroIndexToGetMaxOnes(binArray);
		assertThat(index, is(4));
		
		binArray = new int[]{0,1,1,1,1};
		index = ArrayUtils.zeroIndexToGetMaxOnes(binArray);
		assertThat(index, is(0));
	}

	@Test
	public void replaceMZeroesToGetMaxOnesTest() {
		int binArray[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
		int m= 2;
		int result[] = ArrayUtils.zeroIndexToGetMaxOnes(binArray, m);
		assertThat(result, equalTo(new int[]{5,7}));
		
		binArray = new int[]{1,0,1,1,1,0};
		result = ArrayUtils.zeroIndexToGetMaxOnes(binArray, 1);
		assertThat(result, equalTo(new int[]{1}));
		
		binArray = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
		result = ArrayUtils.zeroIndexToGetMaxOnes(binArray, 1);
		assertThat(result, equalTo(new int[]{9}));
		
		binArray = new int[]{0,1,1,1,0,1};
		result = ArrayUtils.zeroIndexToGetMaxOnes(binArray, 1);
		assertThat(result, equalTo(new int[]{4}));
		
		binArray = new int[]{1,1,1,0,1,0};
		result = ArrayUtils.zeroIndexToGetMaxOnes(binArray, 1);
		assertThat(result, equalTo(new int[]{3}));
		
		binArray = new int[]{0,1,1,1,0};
		result = ArrayUtils.zeroIndexToGetMaxOnes(binArray, 1);
		assertThat(result, equalTo(new int[]{0}));
		
		binArray = new int[]{1,1,1,1,0};
		result = ArrayUtils.zeroIndexToGetMaxOnes(binArray, 1);
		assertThat(result, equalTo(new int[]{4}));
		
		binArray = new int[]{0,1,1,1,1};
		result = ArrayUtils.zeroIndexToGetMaxOnes(binArray, 1);
		assertThat(result, equalTo(new int[]{0}));
	}
	
	@Test
	public void maxInSortedRotatedArrayTest() {
		int array[] = {5, 6, 1, 2, 3, 4};
		int index = ArrayUtils.maxInSortedRotatedArray(array);
		assertThat(index, is(1));

		array = new int[]{1,2,3,4};
		index = ArrayUtils.maxInSortedRotatedArray(array);
		assertThat(index, is(3));
		
		array = new int[]{1, 2};
		index = ArrayUtils.maxInSortedRotatedArray(array);
		assertThat(index, is(1));
		
		array = new int[]{2, 1};
		index = ArrayUtils.maxInSortedRotatedArray(array);
		assertThat(index, is(0));
		
		array = new int[]{5, 6, 7, 1, 2, 3, 4};
		index = ArrayUtils.maxInSortedRotatedArray(array);
		assertThat(index, is(2));
		
		array = new int[]{3, 4, 5, 1, 2};
		index = ArrayUtils.maxInSortedRotatedArray(array);
		assertThat(index, is(2));
		
		array = new int[]{2, 3, 4, 5, 6, 7, 8, 1};
		index = ArrayUtils.maxInSortedRotatedArray(array);
		assertThat(index, is(6));
		
		array = new int[]{6, 7, 8, 1, 2, 3};
		index = ArrayUtils.maxInSortedRotatedArray(array);
		assertThat(index, is(2));
		
		array = new int[]{3, 7, 8, 5, 4, 3};
		index = ArrayUtils.maxInSortedRotatedArray(array);
		assertThat(index, is(2));
		
		array = new int[]{2, 3, 7, 8, 5, 4, 3 , 2};
		index = ArrayUtils.maxInSortedRotatedArray(array);
		assertThat(index, is(3));
		
		array = new int[]{2,3,4,5,6,7,8,6,4,3,2};
		index = ArrayUtils.maxInSortedRotatedArray(array);
		assertThat(index, is(6));
	}
	
	@Test
	public void numberOfMazePathsTest() {
		int[][] maze = {
						{1,-1, -1,-1}, 
						{0, 0, 0, 0}, 
						{-1,-1,0,-1},
						{-1,-1,0, 0},
						{-1,-1,2, 2}};
		int numberOfPaths = ArrayUtils.numberOfMazePaths(maze);
		assertThat(numberOfPaths, equalTo(2));
		
		 maze = new int[][]{
					{1,-1,1,-1}, 
					{0, 0, 0, 0}, 
					{-1,-1,0,-1},
					{-1,-1,0, 0},
					{-1,-1,2, 2}};
		numberOfPaths = ArrayUtils.numberOfMazePaths(maze);
		assertThat(numberOfPaths, equalTo(4));
	}
	
	@Test
	public void commonElementsIn3SortedArrayTest() {
		int arr1[] = {1, 5, 10, 20, 40, 80};
		int arr2[] = {6, 7, 20, 80, 100};
		int arr3[] = {3, 4, 15, 20, 30, 70, 80, 120};
		Integer result[] = ArrayUtils.commonElementsIn3SortedArrays(arr1, arr2, arr3);
		assertThat(result, equalTo(new Integer[]{20, 80}));
	}
	
	@Test
	public void commonElementsInNSortedArrayTest() {
		int arr[][] = { {1, 5, 10, 20, 40, 80},
						{6, 7, 20, 80, 100},
						{3, 4, 15, 20, 30, 70, 80, 120}
					   };

		Integer result[] = ArrayUtils.commonElementsInNSortedArrays(arr);
		assertThat(result, equalTo(new Integer[]{20, 80}));
		
		arr = new int[][]{
                {23, 34, 67, 89, 123, 566, 1000},
                {11, 22, 23, 24,33, 37, 185, 566, 987, 1223, 1234},
                {23, 43, 67, 98, 566, 678},
                {1, 4, 5, 23, 34, 76, 87, 132, 566, 665},
                {1, 2, 3, 23, 24, 344, 566}
              };
              
        result = ArrayUtils.commonElementsInNSortedArrays(arr);
      	assertThat(result, equalTo(new Integer[]{23, 566}));
	}
	
	@Test
	public void findMissingNumberInSortedSequenceTest() {
		int[] array = new int[]{3, 4, 5, 6, 7, 8, 10};
		int result = ArrayUtils.findMissingInSortedSeq(array, 0, array.length - 1);
		assertThat(result, equalTo(9));
		
		array = new int[]{1, 3, 4, 5, 6, 7, 8, 9, 10};
		result = ArrayUtils.findMissingInSortedSeq(array, 0, array.length - 1);
		assertThat(result, equalTo(2));
		
		/*array = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10};
		result = ArrayUtils.findMissingInSortedSeq(array, 0, array.length - 1);
		assertThat(result, equalTo(1));*/
	}
	
	@Test
	public void tranisitionPointOf0And1Test() {
		int[] array = new int[] {0,0,0,0,0,1,1,1};
		int result = ArrayUtils.transitionPoint(array);
		assertThat(result, equalTo(5));
	}
	
	@Test
	public void maxMinLessComparisionsTest() {
		MaxMin<Integer> maxmin = ArrayUtils.<Integer>findMaxMin(seed);
		assertThat(maxmin.getMin(), is(1));
		assertThat(maxmin.getMax(), is(8));		
	}
	
	@Test
	public void connectRopesWithMinCostTest() {
		int minCost = ArrayUtils.connectRopesWithMinCost(new int[]{4,3,2,6});
		assertThat(minCost, equalTo(29));
		
		minCost = ArrayUtils.connectRopesWithMinCost(new int[]{3, 1, 2});
		assertThat(minCost, equalTo(9));
	}
	
	@Test
	public void minSwapToBringPairsAdjecentTest() {
		// For simplicity, it is assumed that arr[0] is
	    // not used.  The elements from index 1 to n are
	    // only valid elements
	    Integer arr[] = {0, 3, 5, 6, 4, 1, 2};
	 
	    // if (a, b) is pair than we have assigned elements
	    // in array such that pairs[a] = b and pairs[b] = a
	    //{1->3, 2->6, 4->5}  // 1 is partner of 3 and so on
	    Integer pairs[] = {0, 3, 6, 1, 5, 4, 2};
	    
	    int swapsRequired = ArrayUtils.minSwapToBringPairsAdjecent(arr, pairs);
	    assertThat(swapsRequired, equalTo(2));
	}
}
