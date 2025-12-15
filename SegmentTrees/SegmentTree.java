class SegmentTree {
    static int tree[];

    public static void init(int n) {
        tree = new int[n*4];
    }

    public static int buildST(int arr[], int i, int start, int end) {
        if(start == end) {
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = (start + end)/2;
        buildST(arr, 2*i+1, start, mid);
        buildST(arr, 2*i+2, mid+1, end);
        tree[i] = tree[2*i+1] + tree[2*i+2];
        return tree[i];
    }

    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
        if(qj <= si || qi >= sj) {
            return 0;
        }else if(si >= qi && sj <= qj) {
            return tree[i];
        } else {
            int mid = (si + sj)/2;
            int left = getSumUtil(2*i+1, si, mid, qi, qj);
            int right = getSumUtil(2*i+2, mid+1, sj, qi, qj);
            return left + right;
        }
    }

    public static int getSum(int arr[], int qi, int qj) {
        int n = arr.length-1;
        return getSumUtil(0, 0, n-1, qi, qj);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;
        init(n);
        System.out.println(buildST(arr, 0, 0, n-1));
        System.out.println(getSum(arr, 2, 5));
    }
}
