package 排序;

/**
 * 插入排序
 * 局部有序到整体有序
 * 在一个局部中，把一个数插入到其所在位置，两两交换
 * 从小到大
 * 第三天
 */
public class ChaRuSort {
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
        // 外层控制循环的次数，直接从下标为1开始，
        for (int i = 1; i < arr.length; i++){
            // 内存循环，则是 0 - i 的范围内进行比较,可以取值到边界
            for (int j = i; j > 0; j--){
                int left = arr[j-1];
                int right = arr[j];
                if (right < left) {
                    int result = left ^ right;
                    arr[j] = result ^ right;
                    arr[j-1] = result ^ left;
                }
            }
        }
        return arr;
    }
}
