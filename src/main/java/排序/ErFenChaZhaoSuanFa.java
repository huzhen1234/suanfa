package 排序;

/**
 * 二分查找算法：一种搜索算法，对半砍
 * 给定一个数组，一个目标值，分析该目标值是否存在于该数组中。默认该数组已经有序
 * 存在则返回其下标值，不存在则返回-1
 */
public class ErFenChaZhaoSuanFa {
    public static void main(String[] args) {
        // 目标数组，默认有序(无序可以通过一些排序算法来排序)
        int[] arr = new int[]{0,2,4,5,7,8,10,24,45,86,94};
        int index = find(arr,7);
        System.out.println(index);

    }

    public static int find(int[] arr,int target){
        // 为空，长度为1的情况
        if (arr  == null || (arr.length == 1 && arr[0] != target)) return -1;
        if (arr.length == 1 && arr[0] == target) return 0;

        // 其他情况 开始对半砍
        int begin = 0;
        int end = arr.length -1;
        return findIndex(arr,begin,end,target);

    }

    /**
     * 无限对半分方法
     * @param arr 原始数组
     * @param begin 区间开始的位置
     * @param end 区间结束的位置
     * @param target 目标值
     * @return 目标值所在的数组下标
     */
    private static int findIndex(int[] arr, int begin, int end,int target) {
        // 最终会来到 开始 == 结束
//        if (begin == end && arr[begin] != target) return -1;  -- 错误点：可能导致 begin > end的情况导致 -1的存在
        if (begin > end) return -1;
        int middle = (begin + end) / 2;
        int middleNumber = arr[middle];
        // 如果中间值大于目标值，则表明在其左区间，可以取middle-1，因为middle的值已经大于目标值了，所以这个闭区间没必要加入到下次的区间了
        if (middleNumber > target) {
            return findIndex(arr, begin, middle - 1, target);
        } else if (middleNumber == target) {
            return middle;
        } else { //如果中间值小于目标值，则表明在其右区间
            return findIndex(arr, middle + 1, end, target);
        }
    }

}
