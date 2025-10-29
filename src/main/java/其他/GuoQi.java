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
        huaFenPro(arr,target);
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
    // 分为三个区间了
    private static void huaFenPro(int[] arr, int target) {
        // 跟上面很相似的思路：但是出现了等于在中间隔断了
        // 左区域起始位置
        int leftArea = -1;
        // 右区域起始位置
        int rightArea = arr.length;
        // 开始遍历原数组，进行划分
        for (int i = 0; i < arr.length; i++) {
            // 遍历到的当前值
            int number = arr[i];
            // 当前值跟target进行比较
            if (target > number){
                // 此时这个数字就应该被划分到左侧，应该是区域位置++,交换当前值和左区域前一个值
                leftArea ++;
                // 进行交换
                int temp = arr[leftArea];
                arr[leftArea] = number;
                arr[i] = temp;
            }else if(target == number) {
                // 这里什么也不做，i++即可
            }else {
                // 也就是number > target，应该被划分到右侧位置，然后交换右侧的左一个位置
                // 右侧位置++
                rightArea--;
                //右侧位置与当前数值进行交换，被划分到右侧了
                int temp = arr[rightArea];
                arr[rightArea] = number;
                arr[i] = temp;
                // 此时右侧的一个数据被划分到了当前位置，所以此时应该原地踏步
                i--;
            }
            // 如果i的位置应到了右边的区域了，那就可以跳出了
            // todo 这里会有问题的。带梳理
            if (leftArea == rightArea){
                break;
            }
            //int[] arr = {3, 9, 8, 12, 6, 10};
            //int target = 9;
        }

    }
}
