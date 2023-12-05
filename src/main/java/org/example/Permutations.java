package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutations {

    public void permuteRec(int i, int[] nums, List<List<Integer>> res, int count) {

        if (i == nums.length) {
            List<Integer> permutation = new ArrayList<>();

            System.out.print("[");

            int sz = nums.length;

            for(int j=0;j<sz;j++) {

                permutation.add(nums[j]);

                if(j==sz-1) {
                    System.out.print(nums[j]);
                }
                else {
                    System.out.print(nums[j]+",");
                }
            }

            res.add(permutation);

            if(count==res.size()) {
                System.out.print("]");
            }
            else {
                System.out.print("],");
            }
            return;
        }


        for (int j = i; j < nums.length; j++) {

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            permuteRec(i + 1, nums, res, count);

            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

        }

    }

    public List<List<Integer>> permute(int[] nums) {

        int fact = 1;
        for(int k=1; k<=nums.length;k++) {
            fact = fact * k;
        }

        System.out.print("[");
        List<List<Integer>> res = new ArrayList<>();
        permuteRec(0, nums, res, fact);
        System.out.print("]");
        return res;
    }

    public static void main(String args[]) {

        Permutations p1 = new Permutations();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        System.out.print("Enter the elements of the array separated by space: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        p1.permute(nums);

    }
}
