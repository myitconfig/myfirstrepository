import java.util.Arrays;

public class SortEight{
	// 直接插入排序
	public static int[] insertSort(int[] strArr){
			for (int i = 1;i < strArr.length;i++) {
				for (int j = i-1;j >= 0 ;j-- ) {
					if (strArr[j+1] < strArr[j]) {
						int temp = strArr[j+1];
						strArr[j+1] = strArr[j];
						strArr[j] = temp;
					}
				}
			}
			return strArr;
	}
//选择排序
	public static int[] selectSort(int[] intArr){
		for (int i=0;i<intArr.length-1 ;i++ ) {
			for (int j=i+1;j<intArr.length ;j++ ) {
				if (intArr[i] < intArr[j]) {
					int temp = intArr[j];
					intArr[j] = intArr[i];
					intArr[i] = temp;
				}
			}
		}
		return intArr;
	}
//冒泡排序
	public static void mpSort(int[] intArr){
		for (int i=0;i<intArr.length-1 ;i++ ) {
			boolean flag=true;
			for (int j=0;j<intArr.length-1-i ;j++ ) {
				if (intArr[j] < intArr[j+1]) {
					int temp = intArr[j+1];
					intArr[j+1] = intArr[j];
					intArr[j] = temp;
					flag=false;
				}
			}
			if (flag) {break;}
		}
		System.out.println(Arrays.toString(intArr));
	}
	//快速排序
public static int[] quikSort(int[] list,int left,int right) {
        //left<right是用来判断两边的索引是否还在走，如果相等了说明不能继续排序就结束了。同时也是左右位置的一个标记。
        if(left<right) {
            //获取索引位置
            int point=divider(list, left, right);
            //递归排序左右索引两边的数组
            quikSort(list, left, point-1);
            quikSort(list, point+1, right);
        }
		return list;
    }
    //排序并返回本轮的索引位置
    public static int divider(int[] list,int left,int right) {
        int pair=list[left];
        //持续循环知道两边的索引相遇，也就是查完了数组的所有元素，就结束，返回当前的索引位置。
        while(left<right) {
            //先从右边开始查找，找到比基准元素pair小的就停止，当然这里从左还是从右开始都是可行的。
            while(left<right&&list[right]>=pair) {
                right--;
            }
            swap(list, left, right);
            //查找左边，找到比基准元素大的就停止，然后交换数据。
            while(left<right&&list[left]<=pair) {
                left++;
            }
            swap(list, left, right);
        }
        return left;
    }
    //交换位置
    public static void swap(int[] list,int a,int b) {
        if(list!=null&&list.length>0) {
            int mm=list[a];
            list[a]=list[b];
            list[b]=mm;
        }
    }

public static int[] heapsort(int[] list) {
        //这里第一个父节点位置length/2-1,然后前面的所有节点都是父节点。这样顺序进行堆处理，生成最大或最小堆
        for(int i=list.length/2-1;i>=0;i--) {
            heapAjust(list,i,list.length);
        }
        //交换末尾元素与第一个元素，交换过后对第一个元素处理一次，这样又变成了一个堆，然后继续循环知道结束
        for(int i=list.length-1;i>0;i--) {
            swap(list, i, 0);
            //这里的长度为i是因为已经排序好的元素不在处理它，如果处理了排序就会乱掉
            heapAjust(list, 0, i);
        }
        return list;
    }
    /**
     * 
     * @param parent 父元素位置
     * @param length 数组长度
     */
    private static void heapAjust(int[] list, int parent, int length) {
        //获取当前父元素的值
        int temp=list[parent];
        //对于完全二叉树父元素的左孩子位置是当前位置*2+1
        int leftchild=parent*2+1;
        //这里leftchild<length的作用是判断当前的父元素的左孩子是否存在，超出了length也就是不存在了循环终止
        while(leftchild<length) {
            //判断有无右孩子，如果有并且左孩子的值小于右孩子就让左孩子索引指向右孩子。这里的左孩子索引其实就是当前值较大值得一个索引
            //也就是一个标记，不必在意其名称。理解了这一点就问题就简单了。这里的大小比较用于排序顺序处理。
            if((leftchild+1)<length&&list[leftchild]<list[leftchild+1]) {
                leftchild++;
            }
            //在子节点中找到了更大的值，下面当然就是和父元素做比较了，如果父元素大直接跳出循环因为不需要进行数据交换
            if(temp>=list[leftchild]) {
                break;
            }
            //否则进行数据交换，并继续往子树判断是否满足堆的条件。
            list[parent]=list[leftchild];
            parent=leftchild;
            leftchild=parent*2+1;
        }
        //这里的parent实际上已经变成了子节点。所以需要将原父节点的值赋值给它。
        list[parent]=temp;
    }

public static void main(String[] args) {
	int[] a=new int[40000];
        for(int i=0;i<a.length;i++) {
            a[i]=(int) (Math.random()*400000);
        }
        double start=System.currentTimeMillis();
        //直接插入440ms
		// System.out.println(Arrays.toString(insertSort(a)));
		//选择1038ms
		// System.out.println(Arrays.toString(selectSort(a)));
		//冒泡1050ms
		// mpSort(a);
		//快速排序14ms
        // System.out.println(Arrays.toString(quikSort(a,0,a.length-1)));
        //5ms
        // quikSort(a,0,a.length-1);
        //堆排序14ms
        // System.out.println(Arrays.toString(heapsort(a)));
        //5ms
        // heapsort(a);
        double end=System.currentTimeMillis();
        System.out.println(end-start+"ms");
	int[] strArr={1,8,7,6,5,4,3,2,10,654,8,3464,32};
	//直接插入0.7
	// System.out.println(Arrays.toString(insertSort(strArr)));
	//选择0.8s
	// System.out.println(Arrays.toString(selectSort(strArr)));
	//冒泡0.7s
	// mpSort(strArr);
	//快速排序0.6s	
}
}