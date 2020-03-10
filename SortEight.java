import java.util.Arrays;

public class SortEight {
    // ֱ�Ӳ�������
    public static int[] insertSort(int[] strArr) {
        for (int i = 1; i < strArr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (strArr[j + 1] < strArr[j]) {
                    int temp = strArr[j + 1];
                    strArr[j + 1] = strArr[j];
                    strArr[j] = temp;
                }
            }
        }
        return strArr;
    }

    //ѡ������
    public static int[] selectSort(int[] intArr) {
        for (int i = 0; i < intArr.length - 1; i++) {
            for (int j = i + 1; j < intArr.length; j++) {
                if (intArr[i] < intArr[j]) {
                    int temp = intArr[j];
                    intArr[j] = intArr[i];
                    intArr[i] = temp;
                }
            }
        }
        return intArr;
    }

    //ð������
    public static void mpSort(int[] intArr) {
        for (int i = 0; i < intArr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < intArr.length - 1 - i; j++) {
                if (intArr[j] < intArr[j + 1]) {
                    int temp = intArr[j + 1];
                    intArr[j + 1] = intArr[j];
                    intArr[j] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(intArr));
    }

    //��������
    public static int[] quikSort(int[] list, int left, int right) {
        //left<right�������ж����ߵ������Ƿ����ߣ���������˵�����ܼ�������ͽ����ˡ�ͬʱҲ������λ�õ�һ����ǡ�
        if (left < right) {
            //��ȡ����λ��
            int point = divider(list, left, right);
            //�ݹ����������������ߵ�����
            quikSort(list, left, point - 1);
            quikSort(list, point + 1, right);
        }
        return list;
    }

    //���򲢷��ر��ֵ�����λ��
    public static int divider(int[] list, int left, int right) {
        int pair = list[left];
        //����ѭ��֪�����ߵ�����������Ҳ���ǲ��������������Ԫ�أ��ͽ��������ص�ǰ������λ�á�
        while (left < right) {
            //�ȴ��ұ߿�ʼ���ң��ҵ��Ȼ�׼Ԫ��pairС�ľ�ֹͣ����Ȼ��������Ǵ��ҿ�ʼ���ǿ��еġ�
            while (left < right && list[right] >= pair) {
                right--;
            }
            swap(list, left, right);
            //������ߣ��ҵ��Ȼ�׼Ԫ�ش�ľ�ֹͣ��Ȼ�󽻻����ݡ�
            while (left < right && list[left] <= pair) {
                left++;
            }
            swap(list, left, right);
        }
        return left;
    }

    //����λ��
    public static void swap(int[] list, int a, int b) {
        if (list != null && list.length > 0) {
            int mm = list[a];
            list[a] = list[b];
            list[b] = mm;
        }
    }

    public static int[] heapsort(int[] list) {
        //�����һ�����ڵ�λ��length/2-1,Ȼ��ǰ������нڵ㶼�Ǹ��ڵ㡣����˳����жѴ�������������С��
        for (int i = list.length / 2 - 1; i >= 0; i--) {
            heapAjust(list, i, list.length);
        }
        //����ĩβԪ�����һ��Ԫ�أ���������Ե�һ��Ԫ�ش���һ�Σ������ֱ����һ���ѣ�Ȼ�����ѭ��֪������
        for (int i = list.length - 1; i > 0; i--) {
            swap(list, i, 0);
            //����ĳ���Ϊi����Ϊ�Ѿ�����õ�Ԫ�ز��ڴ��������������������ͻ��ҵ�
            heapAjust(list, 0, i);
        }
        return list;
    }

    /**
     * @param parent ��Ԫ��λ��
     * @param length ���鳤��
     */
    private static void heapAjust(int[] list, int parent, int length) {
        //��ȡ��ǰ��Ԫ�ص�ֵ
        int temp = list[parent];
        //������ȫ��������Ԫ�ص�����λ���ǵ�ǰλ��*2+1
        int leftchild = parent * 2 + 1;
        //����leftchild<length���������жϵ�ǰ�ĸ�Ԫ�ص������Ƿ���ڣ�������lengthҲ���ǲ�������ѭ����ֹ
        while (leftchild < length) {
            //�ж������Һ��ӣ�����в������ӵ�ֵС���Һ��Ӿ�����������ָ���Һ��ӡ����������������ʵ���ǵ�ǰֵ�ϴ�ֵ��һ������
            //Ҳ����һ����ǣ��������������ơ��������һ�������ͼ��ˡ�����Ĵ�С�Ƚ���������˳����
            if ((leftchild + 1) < length && list[leftchild] < list[leftchild + 1]) {
                leftchild++;
            }
            //���ӽڵ����ҵ��˸����ֵ�����浱Ȼ���Ǻ͸�Ԫ�����Ƚ��ˣ������Ԫ�ش�ֱ������ѭ����Ϊ����Ҫ�������ݽ���
            if (temp >= list[leftchild]) {
                break;
            }
            //����������ݽ������������������ж��Ƿ�����ѵ�������
            list[parent] = list[leftchild];
            parent = leftchild;
            leftchild = parent * 2 + 1;
        }
        //�����parentʵ�����Ѿ�������ӽڵ㡣������Ҫ��ԭ���ڵ��ֵ��ֵ������
        list[parent] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[40000];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 400000);
        }
        double start = System.currentTimeMillis();
        //ֱ�Ӳ���440ms
        // System.out.println(Arrays.toString(insertSort(a)));
        //ѡ��1038ms
        // System.out.println(Arrays.toString(selectSort(a)));
        //ð��1050ms
        // mpSort(a);
        //��������14ms
        // System.out.println(Arrays.toString(quikSort(a,0,a.length-1)));
        //5ms
        // quikSort(a,0,a.length-1);
        //������14ms
        // System.out.println(Arrays.toString(heapsort(a)));
        //5ms
        // heapsort(a);
        double end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
        int[] strArr = {1, 8, 7, 6, 5, 4, 3, 2, 10, 654, 8, 3464, 32};
        //ֱ�Ӳ���0.7
        // System.out.println(Arrays.toString(insertSort(strArr)));
        //ѡ��0.8s
        // System.out.println(Arrays.toString(selectSort(strArr)));
        //ð��0.7s
        // mpSort(strArr);
        //��������0.6s
    }
}