package com.day0811;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutationTest {
	// n개 중에 r개를 뽑는 순열은 불가능하다. nPn 을 위한 식이다
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		long start =System.currentTimeMillis();
		// 전처리 : 순열에 쓰일 수들을 오름차순 정렬
		Arrays.sort(input);
		
		do {
			System.out.println(Arrays.toString(input));
		} while (np(input));
		long end = System.currentTimeMillis();
		System.out.println(" 수행 시간 : "+(end-start)+" ms");
	}

	
	public static boolean np(int[] numbers) { // numbers 배열의 상태를 근거로 다음 순열 생성, 다음 순열 존재하면 true, 아니면 false
		int n = numbers.length;
		// 1. 꼭대기 찾기
		int i = n-1;
		while (i>0 && numbers[i-1] >= numbers[i]) {
			--i;
		}
		if (i == 0) {
			return false; // 다음 순열을 만들수 없는 이미 가장 큰 순열의 상태이다!
		}
		// 2.꼭대기의 바로 앞자리(i-1)의 값을 크게 만들 교환값 뒤에서 찾기
		int j = n-1;
		while (numbers[i-1] >= numbers[j]) {
			--j;
		}
		// 3. i-1 위차값과 j 위치값 교환
		swap(numbers,i-1,j);
		
		// 4. i 위치부터 맨뒤 까지의 수열을 가장 작은 형태의 오름차순으로 변경
		int k = n-1;
		while (i<k) {
			swap(numbers, i++, k--);
		}
		return true;
	}
	
	public static void swap(int[] numbers,int i,int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
}
