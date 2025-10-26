package 排序;

/**
 * 归并排序，分为两部分，左右部分，先使得左边有序，右边有序，然后借用一个辅助数组，分别两个下标指向左侧开始位置、右侧开始位置
 * 进行比较，谁小拷贝谁，并右移
 * 采用递归方式，有一个递归数，递归的结束条件为L=R也就是数组长度为1的时候。
 * 目前困惑点：
 */
public class GuiBingSort {
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
        // 开始调用递归算法
        diff2(arr,0,arr.length-1);
        return arr;
    }


    /**
     * 重新理了一下逻辑之后的代码
     */
    private static void diff2(int[] arr, int begin, int end) {
        // 如果开始位置==结束位置 那么数组就只有一个数，就不用比较
        if (begin == end) return;
        // 如果不是则进行继续拆分划分
        // 中间位置
        int middle = begin + ((end - begin) >> 1);
        // 左递归数
        diff2(arr,begin,middle);
        // 右递归数
        diff2(arr,middle + 1,end);
        // 合并左右区间的数,注意递归层数。不要多想，可以画图理一下层级关系
        merge(arr,begin,end,middle);

    }

    /**
     * 合并：就是比较左右区间的数值大小，然后设置到辅助数组中
     */
    private static void merge(int[] arr, int begin, int end, int middle) {
        // 开辟一块空间作为辅助数组
        int[] help = new int[end-begin+1];
        // 辅助数组的移动下标
        int helpIndex = 0;
        // 左区间的移动下标
        int leftIndex = begin;
        // 右区间的移动下标
        int rightIndex = middle + 1;
        // 当双方都没有越界时
        while(leftIndex <= middle && rightIndex <= end){
            // 如果左边的值 > 右边的值则把右边的值先放入到辅助数组，然后辅助数组和右边的数组下标++
            help[helpIndex++] = arr[leftIndex] > arr[rightIndex] ? arr[rightIndex++] : arr[leftIndex++];
        }
        // 下面就是有一方越界了？那么就是单独处理越界的一部分了。
        // 如果是右侧先越界了 ==> 右侧数据已经全部插入到辅助数组中了
        while(leftIndex <= middle){
            help[helpIndex++] = arr[leftIndex++];
        }
        // 如果是左侧先越界了
        while(rightIndex <= end){
            help[helpIndex++] = arr[rightIndex++];
        }
        // 这也是困惑点之一，就是借用了辅助数组之后如何使得原来数组变得有序呢？这里我们是直接对原来数组进行操作的。
        // 以起始位置开始，也就是begin位置开始进行设置，这样不会影响原始数据，只会使得在一个区间内保持有序，并不会缺少数据和覆盖数据
        for (int i = 0; i < help.length; i++){
            arr[begin+i] = help[i];
        }
    }
}
