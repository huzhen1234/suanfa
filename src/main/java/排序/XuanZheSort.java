package 排序;

/**
 * 选择排序
 * 思路：就是在给定的一组数据中，选定一个数作为最小值(一般都是从下表0开始的)，从0开始一直到n-1进行逐行比较直到选择出最小的值然后放到指定的位置
 * 每循环一次则固定一位最小值在左侧，则剩下比较次数为 n-2
 * 第一天
 */
public class XuanZheSort {
    public static void main(String[] args) {
        int[] arr = new int[]{6,1,5};
        arr = sort(arr);
        for (int number : arr){
            System.out.print(number + "\n");
        }
    }

    public static int[] sort(int[] arr){
        if (arr == null){
            return new int[0];
        }
        // 首先判断数组长度为0/1则直接返回即可
        if (arr.length == 0 || arr.length == 1){
            return arr;
        }
        int endIndex = arr.length; // 数组长度
        // 开始处理逻辑
        for (int i = 0; i <= endIndex -1; i++ ){
            int minNumber = arr[i]; // 默认以一次循环开始的第一位为最小值
            int minNumberIndex = i; // 默认以一次循环开始的第一位为最小值
            for (int j = i+1; j <= endIndex -1; j++){
                // 循环比较后面的值是不是比最小值还要小，开始位置为前面的位置+1
                if (minNumber > arr[j]){
                    minNumber = arr[j]; // 如果后面的值比预定最小的值要小，则设置为最小值,循环比较一整轮选出一轮中最小的值
                    minNumberIndex = j; // 记录最小值的位置，实际最小的值
                }
            }
            // 循环一整轮之后，获取到最小值 minNumber，并且也获取到了最小值的位置
            // 交换位置，循环起始位置和实际位置交换
            int temp = arr[i]; // 先设置为逻辑上最小值
            arr[i] = minNumber; // 把实际值放到循环开始位置
            arr[minNumberIndex] = temp; // 把逻辑上最小的值放到实际最小值的位置上，实现交换
        }
        return arr;
    }
}
