package com.knowledge.tongyaxi.SortAlgorithms;

import java.util.Arrays;

/**
 * 归并排序
 * @author ytong
 *
 */
public class MergeSort {
	public static void mergeSort(int[] arr, int left, int right, int[] temp) {
		// 分解
		if (left < right) {
			int mid = (left + right) / 2;// 中间索引
			// 向左递归进行分解
			mergeSort(arr, left, mid, temp);
			// 向右递归进行分解
			mergeSort(arr, mid + 1, right, temp);// mid + 1，中间位置的后一个位才是右边序列的开始位置
			// 每分解一轮便合并一轮
			merge(arr, left, right, mid, temp);
		}
	}

	/**
	 * 合并的方法
	 *
	 * @param arr   待排序的数组
	 * @param left  左边有序序列的初始索引
	 * @param right 中间索引
	 * @param mid   右边有序序列的初始索引
	 * @param temp  做中转的数组
	 */
	public static void merge(int[] arr, int left, int right, int mid, int[] temp) {
		int i = left; // 初始化i，左边有序序列的初始索引
		int j = mid + 1;// 初始化j，右边有序序列的初始索引(右边有序序列的初始位置即为中间位置的后一个位置)
		int t = 0;// 指向temp数组的当前索引，初始为0
		// 先把左右两边的数据(已经有序)按规则填充到temp数组
		// 直到左右两边的有序序列，有一边处理完成为止
		while (i <= mid && j <= right) {
			// 如果左边有序序列的当前元素小于或等于右边有序序列的当前元素，就将左边的元素填充到temp数组中
			if (arr[i] <= arr[j]) {
				temp[t] = arr[i];
				t++;// 索引后移
				i++;// i后移
			} else {
				// 反之，将右边有序序列的当前元素填充到temp数组中
				temp[t] = arr[j];
				t++;// 索引后移
				j++;// j后移
			}
		}
		// 把有剩余数据的一边的元素填充到temp中
		while (i <= mid) {
			// 此时说明左边序列还有剩余元素
			// 全部填充到temp数组
			temp[t] = arr[i];
			t++;
			i++;
		}
		while (j <= right) {
			// 此时说明左边序列还有剩余元素
			// 全部填充到temp数组
			temp[t] = arr[j];
			t++;
			j++;
		}
		// 将temp数组的元素复制到原数组
		t = 0;
		int tempLeft = left;
		while (tempLeft <= right) {
			arr[tempLeft] = temp[t];
			t++;
			tempLeft++;
		}
	}



	public static void main(String[] args) {
		int[] arr = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };
		int[] temp = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1, temp);
		System.out.println(Arrays.toString(arr));
	}


}
