package com.knowledge.tongyaxi.SortAlgorithms;

import java.util.Arrays;

/**
 * 快�?�排�?
 * @author ytong
 *
 */
public class QuickSort {
	public static void quickSort(int[] arr, int left, int right) {
		int l = left;// 左下标
		int r = right;// 右下标
		int pivot = arr[(left + right) / 2];// 找到中间的值
		// 将比pivot小的值放在其左边，比pivot大的值放在其右边
		while (l < r) {
			// 在pivot左边寻找，直至找到大于等于pivot的值才退出
			while (arr[l] < pivot) {
				l += 1;// 将l右移一位
			}
			// 在pivot右边寻找，直至找到小于等于pivot的值才退出
			while (arr[r] > pivot) {
				r -= 1;// 将r左移一位
			}
			if (l >= r) {
				// 左右下标重合，寻找完毕，退出循环
				break;
			}
			// 交换元素
			int temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;

			//倘若发现值相等的情况，则没有比较的必要，直接移动下标即可

			// 如果交换完后，发现arr[l]==pivot，此时应将r左移一位
			if (arr[l] == pivot) {
				r -= 1;
			}
			// 如果交换完后，发现arr[r]==pivot，此时应将l右移一位
			if (arr[r] == pivot) {
				l += 1;
			}
		}
		// 如果l==r，要把这两个下标错开，否则会出现无限递归，导致栈溢出的情况
		if (l == r) {
			l += 1;
			r -= 1;
		}
		// 向左递归
		if (left < r) {
			quickSort(arr, left, r);
		}
		// 向右递归
		if (right > l) {
			quickSort(arr, l, right);
		}
	}



	public static void main(String[] args) {
		int[] arr = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}


}
