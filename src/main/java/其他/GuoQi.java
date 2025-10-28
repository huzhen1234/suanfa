package 其他;

/**
 * 荷兰国旗问题
 * 给定一个数组，指定一个数，使得小于这个数在左区间，大于这个数在右区间，并返回区间位置
 * 其实对于其逻辑来讲很简单。就是该区域刚开始为在数组的最左侧，可以理解为-1这个位置。数组从下标为0开始遍历，
 * 如碰到 > target，则下标++，如果碰到 < target 则与区域的下一个位置交换位置，然后下标++，区域位置++
 */
public class GuoQi {
    public static void main(String[] args) {
        int[] arr = new int[]{3,6,8,9,1,2,7,9,56,3,25,89};
        int target = 32;
        huaFen(arr,target);
        for (int i : arr) {
            System.out.print(i + "\n");
        }
    }

    private static void huaFen(int[] arr, int target) {
        int quYuIndex = -1;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] <= target){
                // 当前值 <= target 则与区域的下一个位置交换,此时区域的下标++，数组下标++
                // todo 注意点：当异或的两个值相等时是为0的
                if (arr[i] != arr[++quYuIndex]){
                    int result = arr[i] ^ arr[quYuIndex];
                    arr[i] = result ^ arr[i];
                    arr[quYuIndex] = result ^ arr[quYuIndex];
                }
            }
        }
        System.out.println("下标位置为：" + quYuIndex);
    }


    // todo 升级版 分为三个区域：小于 等于 大于
}
