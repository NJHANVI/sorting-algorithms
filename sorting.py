
def bubble(arr):
    for i in range (0,len(arr)-1):
        for j in range (0,len(arr)-1-i):
            if arr[j]>arr[j+1]:
                t=arr[j]
                arr[j]=arr[j+1]
                arr[j+1]=t
            
    return arr

    
def selection(arr):
    for i in range (0,len(arr)-1):
        smallest=i
        for j in range(i,len(arr)-1):
            if (arr[smallest]>arr[j]):
                smallest=j
        t=arr[i]
        arr[i]=arr[smallest]
        arr[smallest]=t
    return arr
def conquer(si,ei,mid,arr):
    
    n1=mid-si+1
    n2=ei-mid
    i=j=0
    k=si
    left=arr[:n1]
    right=arr[mid+1:]

    while(i<=n1 and j<=n2):
        if (left[i]<right[j]):
            arr[k]=left[i]
            i+=1
            k+=1
            
        else:
            arr[k]=right[j]
            j+=1
            k+=1
                   

    while(i<=n1):
        arr[k]=left[i]
        i+=1
        k+=1
        
    while(j<=n2):
        arr[k]=right[j]
        j+=1
        k+=1
     
        
    
def divide(si,ei,arr):
    if(si>=ei):
        return 
    mid=si+(ei-si)/2
    divide(si,mid,arr)
    divide(mid+1,ei,arr)
    conquer(si,ei,mid,arr)

def merge(arr):
    divide(0,5,arr)

array=[54,23,67,12,98,32]
b_array=bubble(array)
print(b_array)
s_array=selection(array)
print(s_array)

merge(array)
print(array)