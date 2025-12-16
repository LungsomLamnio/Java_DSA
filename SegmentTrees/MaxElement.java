class MaxElement {
    static int tree[];

    public static void init(int n) {
        tree = new int[4*n];
    }

    public static void buildST(int arr[], int si, int sj, int i) {
        if(si == sj) {
            tree[i] = arr[si];
            return;
        }

        int mid = (si + sj)/2;
        buildST(arr, si, mid, 2*i+1);
        buildST(arr, mid+1, sj, 2*i+2);

        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
    }

    public static int getMaxUtil(int i, int si, int sj, int qi, int qj) {
        if(qi > sj || si > qj) {
            return Integer.MAX_VALUE;
        }

        if(si >= qi && qj <= sj) {
            return tree[i];
        } else {
            int mid = (si+sj)/2;
            int left = getMaxUtil(2*i+1, si, mid, qi, qj);
            int right = getMaxUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.max(left, right);
        }
    }

    public static int getMax(int arr[], int qi, int qj) {
        int n = arr.length;
        return getMaxUtil(0, 0, n-1, qi, qj);
    }

    public static void updateUtil(int i, int si, int sj, int newValue, int indx) {
        if(indx < si || indx > sj) {
            return;
        }

        tree[i] = Math.max(newValue, tree[i]);

        if(si != sj) {
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, newValue, indx);
            updateUtil(2*i+2, si, mid, newValue, indx);
        }

    }

    public static void update(int arr[], int indx, int newValue) {
        int n = arr.length;
        updateUtil(0, 0, n-1, newValue, indx);
    }
    public static void main(String[] args) {
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n = arr.length;
        init(n);
        buildST(arr, 0, n-1, 0);

        for(int i=0; i<tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        System.out.println(getMax(arr, 0, n-1));
        update(arr, 2, 20);
        System.out.println(getMax(arr, 0, n-1));
    }
}