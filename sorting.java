class bubble_sort{//time complexity O(n^2)
    public static int[] bubble(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int t=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }
            }
        }
        return arr;
    }
}

class selection_sort{//time complexity O(n^2)
    public static int[] selection(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int smallest=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[smallest]>arr[j]){
                    smallest=j;
                }
            }
            int t=arr[smallest];
            arr[smallest]=arr[i];
            arr[i]=t;

        }
        return arr;
    }
}

class merge_sort{//time complexityo(nlogn)
    public static void conquer(int si,int mid,int ei,int arr[]){
        int m_array[]= new int[ei-si+1];
        int l=si;
        int r=mid+1;
        int k=0;
        while(l<=mid && r<=ei){
            if (arr[l]<arr[r]){
                m_array[k]=arr[l];
                l++;
                k++;
            }
            else{
                m_array[k]=arr[r];
                r++;
                k++;
            }
        }

        while(l<=mid){
            m_array[k]=arr[l];
            l++;
            k++;
        }
        while(r<=ei){
            m_array[k]=arr[r];
            r++;
            k++;
        }
        for(int i=0,j=si;i<m_array.length-1;j++,i++){
            arr[j]=m_array[i];
        }
    }
    public static void divide(int si,int ei,int arr[]){
        if(si>=ei){
            return;
        }
        int mid=(si+(ei-si)/2);
        divide(si,mid,arr);
        divide(mid+1,ei,arr);
        conquer(si, mid, ei, arr);
    }
    public static int[] merge(int arr[]){
        int n=arr.length;
        merge_sort.divide(0,n-1,arr);
        return arr;
    }

}
class sorting{
    public static void printarray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] array={85,22,64,32,78,50};
        int[] b_array=bubble_sort.bubble(array);
        System.out.println("Bubble Sorted");
        printarray(b_array);
        int[] s_array=selection_sort.selection(array);
        System.out.println("selection Sorted");
        printarray(s_array);
        int[] m_array=merge_sort.merge(array);
        System.out.println("Merge Sorted");
        printarray(m_array);
    }
}

