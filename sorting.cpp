#include<iostream>
using namespace std;

    void bubble(int arr[],int size){
        for(int i=0;i<size-1;i++){
            for(int j=0;j<size-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int t= arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }
            }
        }
    }

    void selection(int arr[], int size){
        for (int i=0;i<size-1;i++){
            int smallest=i;
            for(int j=0;j<size;j++){
                if(arr[i]>arr[j]){
                    smallest=j;
                }
            }
            int t=arr[smallest];
            arr[smallest]=arr[i];
            arr[i]=t;
        }
    }
    void conquer(int si,int mid,int ei,int arr[]){
        int n1=ei-si+1;
        int n2=ei-mid;
        int left[n1],right[n2];
        for(int i=0;i<n1;i++){
            left[i]=arr[si+i];
        }
        for(int j=0;j<n2;j++){
            right[j]=arr[mid+1+j];
        }
        int i=0,j=0,k=si;
        while(i<n1 &&j<n2){
            if(left[i]>right[j]){
                arr[k]=left[i];
                i++;k++;
            }
            else{
                arr[k]=right[j];
                j++;k++;
            }
        }
        while(i<n1){
            arr[k]=left[i];
            i++;
        }
        while(j<n2){
            arr[k]=right[j];
            j++;
        }
        

    }
    void divide(int si,int ei,int arr[]){
        if(si>=ei){
            return;
        }
        int mid=si+(ei-si)/2;
        divide(si,mid,arr);
        divide(mid+1,ei,arr);
        conquer(si,mid,ei,arr);
    }

    void merge(int arr[],int size){
        divide(0,size-1,arr);
    }



int main(){
    int arr1[]={34,56,43,12,49};
    int n1 = sizeof(arr1)/sizeof(arr1[0]);
    bubble(arr1,n1);
    for (int i=0;i<n1;i++){
        cout<<arr1[i]<<" ";
    }
    cout<<"\n"<<endl;
    int arr2[]={54,34,24,64,87,9};
    int n2 = sizeof(arr2)/sizeof(arr2[0]);
    selection(arr2,n2);
    for (int i=0;i<n2;i++){
        cout<<arr2[i]<<" ";
    }

    cout<<"\n"<<endl;
    int arr3[]={45,65,32,12,23,56};
    int n3 = sizeof(arr3)/sizeof(arr3[0]);
    merge(arr3,n3);
    for (int i=0;i<n3;i++){
        cout<<arr3[i]<<" ";
    }
    return 0;
}