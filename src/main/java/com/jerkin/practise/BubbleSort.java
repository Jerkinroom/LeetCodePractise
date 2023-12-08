package com.jerkin.practise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @author 遥望不惑
 * @classname BubbleSort
 * @description 冒泡排序算法
 * 冒泡排序是通过一一比对进行实现
 * 每次比较的时候，如果前面比后面大，则交换位置
 * 比较次数会被递减，因为每一轮比对都会将最大的数放到最后
 * 时间复杂度：O(n^2)
 * @date 2023/12/08/ 11:42
 */
public class BubbleSort {

    public static void main(String[] args) {
        Integer[] array = {7, 8, 9, 10, 3, 2, 1, 4, 5, 6};
        sort03(array);
        String value = Arrays.asList(array).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(value);
    }
    //常规的
    private static void sort01(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    //在常规的冒泡排序中增加了减少无畏的操作，就是当
    //如果整个排序不发生交换了，就可以终止当前的排序操作
    //因为此时整个操作已经
    private static void sort02(Integer[] array) {
        boolean swapped = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }
    //优化的冒泡排序
    //在上一轮冒泡排序中进一步思考，如果在排序比对时，最后一次交换的位置
    //实际往后的位置已经排好序了，下次排序的时候就无序在进行了
    //所以将循环终点进一步缩短
    private static void sort03(Integer[] array) {
        boolean swapped = true;
        int index = -1;
        int swappedIndex = array.length - 1;

        while (swapped) {
            swapped = false;
            for (int i = 0; i <swappedIndex; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    index = i;
                    swapped = true;
                }
            }
            swappedIndex = index;
        }
    }

}


