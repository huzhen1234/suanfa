package 排序;

/**
 * 冒泡排序算法
 * 思想：左右两两比较交换，选择从小到大还是从大到小排序
 * 从小到大：两两交换，大的变到左边，依此遍历，直到最后，此时每遍历一次则确定一个最大值放在最右侧。
 */
public class MaoPaoSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,6,8,9,1,2,7,9,56,3,25,89};
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
        //此时需要外层循环来控需要循环几次？这里从直接从1开始，因为我理解是交换的第一轮，需要交换 n-1 轮。也就是从1到arr.length
        for (int i = 1; i <= arr.length; i++) {
            // 内层逻辑(两两比较交换)，都是从0位置开启，直到最后一位(每遍历一次则确定一位放到最右边，则 --),此时终止位置一直在变化，收到第几次循环次数的影响
            // 第一次循环，需要比较 n-1次，第二次循环需要比较 n-2次 。。。。
            for (int j = 0; j < arr.length - i; j++) {
                // 比较逻辑 如果左边的值大于右边的值，则两两交换
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
