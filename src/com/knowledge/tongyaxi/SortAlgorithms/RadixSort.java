package com.knowledge.tongyaxi.SortAlgorithms;

import java.util.Arrays;

/**
 * 基数排序
 * @author ytong
 *
 */
public class RadixSort {

	public static void radixSort(int[] arr) {
		// 第一轮(针对每个元素的个位进行排序处理)

		// 定义一个二维数组，模拟桶，每个桶就是一个一维数组
		// 为了防止放入数据的时候桶溢出，我们应该尽量将桶的容量设置得大一些
		int[][] bucket = new int[10][arr.length];
		// 记录每个桶中实际存放的元素个数
		// 定义一个一维数组来记录每个桶中每次放入的元素个数
		int[] bucketElementCounts = new int[10];

		for (int j = 0; j < arr.length; j++) {
			// 取出每个元素的个位
			int digitOfElement = arr[j] % 10;
			// 将元素放入对应的桶中
			// bucketElementCounts[digitOfElement]就是桶中的元素个数，初始为0，放在第一位
			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
			// 将桶中的元素个数++
			// 这样接下来的元素就可以排在前面的元素后面
			bucketElementCounts[digitOfElement]++;
		}
		// 按照桶的顺序取出数据并放回原数组
		int index = 0;
		for (int k = 0; k < bucket.length; k++) {
			// 如果桶中有数据，才取出放回原数组
			if (bucketElementCounts[k] != 0) {
				// 说明桶中有数据，对该桶进行遍历
				for (int l = 0; l < bucketElementCounts[k]; l++) {
					// 取出元素放回原数组
					arr[index++] = bucket[k][l];
				}
			}
			// 第一轮处理后，需要将每个bucketElementCounts[k]置0
			bucketElementCounts[k] = 0;
		}
		System.out.println("第一轮:" + Arrays.toString(arr));

		// ----------------------------

		// 第二轮(针对每个元素的十位进行排序处理)
		for (int j = 0; j < arr.length; j++) {
			// 取出每个元素的十位
			int digitOfElement = arr[j] / 10 % 10;
			// 将元素放入对应的桶中
			// bucketElementCounts[digitOfElement]就是桶中的元素个数，初始为0，放在第一位
			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
			// 将桶中的元素个数++
			// 这样接下来的元素就可以排在前面的元素后面
			bucketElementCounts[digitOfElement]++;
		}
		// 按照桶的顺序取出数据并放回原数组
		index = 0;
		for (int k = 0; k < bucket.length; k++) {
			// 如果桶中有数据，才取出放回原数组
			if (bucketElementCounts[k] != 0) {
				// 说明桶中有数据，对该桶进行遍历
				for (int l = 0; l < bucketElementCounts[k]; l++) {
					// 取出元素放回原数组
					arr[index++] = bucket[k][l];
				}
			}
			// 第二轮处理后，需要将每个bucketElementCounts[k]置0
			bucketElementCounts[k] = 0;
		}
		System.out.println("第二轮:" + Arrays.toString(arr));

		// ----------------------------

		// 第三轮(针对每个元素的百位进行排序处理)
		for (int j = 0; j < arr.length; j++) {
			// 取出每个元素的百位
			int digitOfElement = arr[j] / 100 % 10;
			// 将元素放入对应的桶中
			// bucketElementCounts[digitOfElement]就是桶中的元素个数，初始为0，放在第一位
			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
			// 将桶中的元素个数++
			// 这样接下来的元素就可以排在前面的元素后面
			bucketElementCounts[digitOfElement]++;
		}
		// 按照桶的顺序取出数据并放回原数组
		index = 0;
		for (int k = 0; k < bucket.length; k++) {
			// 如果桶中有数据，才取出放回原数组
			if (bucketElementCounts[k] != 0) {
				// 说明桶中有数据，对该桶进行遍历
				for (int l = 0; l < bucketElementCounts[k]; l++) {
					// 取出元素放回原数组
					arr[index++] = bucket[k][l];
				}
			}
			// 第三轮处理后，需要将每个bucketElementCounts[k]置0
			bucketElementCounts[k] = 0;
		}
		System.out.println("第三轮:" + Arrays.toString(arr));
	}



	public static void main(String[] args) {
		int[] arr = { 53, 3, 542, 748, 14, 214 };
		radixSort(arr);
	}

}
