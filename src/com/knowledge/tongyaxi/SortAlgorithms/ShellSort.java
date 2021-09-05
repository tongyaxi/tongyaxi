package com.knowledge.tongyaxi.SortAlgorithms;

import java.util.Arrays;

import org.junit.Test;

/**
 * 希尔排序
 * @author ytong
 *
 */
public class ShellSort {
	@Test
	public void ShellSort1() {
		int[] arr = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// 对数组元素进行分组
			for (int i = gap; i < arr.length; i++) {
				// 遍历各组中的元素
				for (int j = i - gap; j >= 0; j -= gap) {
					// 交换元素
					if (arr[j] > arr[j + gap]) {
						int temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}
		}

		System.out.println(Arrays.toString(arr));
	}


}
