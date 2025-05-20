import java.io.*;

public class Main
{
	private static long seed = 5;


	private static int rand()
	{
		seed = seed * 25214903917L + 11L;

		return (int)((seed >> 16) & 0x7fff);

	}
	public static int[] sorted;
	public static int[] answer;

	public static void run(int[] data,int n){
		mergeSort(data,0,n-1);
    }
	
	public static void mergeSort(int[] data,int left,int right){
		int mid = (left + right) / 2;
		if(left<right){
			mergeSort(data,left,mid);
			mergeSort(data,mid+1,right);
			merge(data,left,mid,right);
		}
	}

	public static void merge(int[] data,int left, int mid, int right){
		int indexA = left, indexB = mid+1, i = left;
		for(;indexA<=mid && indexB <= right;i++){
			if(data[indexA] < data[indexB]){
				sorted[i] = data[indexA];
				indexA++;
			}
			else{
				sorted[i] = data[indexB];
				indexB++;
			}
		}
		for(;i<=right;i++){
			if(indexA<=mid){
				sorted[i] = data[indexA];
				indexA++;
			}
			if(indexB<=right){
				sorted[i] = data[indexB];
				indexB++;
			}
		}

		for(i=left;i<=right;i++){
			data[i] = sorted[i];
		}
	}
	

	public static void main(String args[]) throws Exception
	{

		// int[] data = new int[100];

		// for (int c = 0; c < 100; c++)
		// {
		// 	data[c] = rand();
		// }

		// Test.run(data);
		
		// int SCORE = 0;

		// for (int c = 0; c < 99; c++)
		// {
		// 	if (data[c] > data[c + 1])
		// 	{
		// 		SCORE++;
		// 	}
		// }

		// System.out.printf("SCORE: %d\n", SCORE);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		answer = new int[n];
		sorted = new int[n];
		for(int i=0;i<n;i++){
			answer[i] = Integer.parseInt(br.readLine());
		}
		run(answer,n);
		for(int i=0;i<n;i++){
			sb.append(answer[i]).append("\n");
		}
		System.out.println(sb);
	}
}
