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
    public static void main(String[] args) {
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n = arr.length;
        init(n);
        buildST(arr, 0, n-1, 0);

        for(int i=0; i<tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }
}