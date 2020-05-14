package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 *
 * @author xb41101
 * @version Id: Test, v 0.1 2020/5/13 9:17 下午 yaman Exp $
 */
public class Test {
    static int arr[] = new int[10000000];
    static {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(1000);
        }
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        List<Integer> index = new ArrayList<>();
        int k = 3;
        if(k>arr.length){
            return;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(sumArr(arr,0,k,index));
        for (int i = 1; i < arr.length-k+1; i++) {
            int sum = sumArr(arr, i, k,index);
            int max = queue.peek();
            if (sum > max) {
                queue.poll();
                queue.add(sum);
                index.clear();
                addIndex(index,i,k);
            }

            if(sum == max){
                addIndex(index,i,k);
            }
        }
        System.out.println(index);
        System.out.printf("耗时(%s)ms" ,(System.currentTimeMillis()-time));
    }



    private static int sumArr(int[] arr, int index, int k,List<Integer> list) {
        int sum = 0;
        for (int i = index; i < Math.min(index + k, arr.length); i++) {
            sum += arr[i];
            list.add(i);
        }
        return sum;
    }

    private static void addIndex(List<Integer> list,int index,int k ){
        for (int i = index; i < index + k; i++) {
            list.add(i);
        }
    }
}
