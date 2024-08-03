# Time:
# Best: O(n log n)
# Average: O(n log n)
# Worst: O(n log n)

# Space: O(1)

def delete_node(arr, last):
    swap(arr, 1, last)
    
    index = 1
    swap_idx = index
    
    while index * 2 < last:
        if arr[index * 2] > arr[index]:
            swap_idx = index * 2
        if index * 2 + 1 < last and arr[index * 2 + 1] > arr[swap_idx]:
            swap_idx = index * 2 + 1
        
        if index == swap_idx:
            break
        
        swap(arr, swap_idx, index)
        index = swap_idx

def swap(arr, i, j):
    arr[i], arr[j] = arr[j], arr[i]

def top_down_heap():
    size = int(input("\nEnter the size of the array for top down approach: "))
    last = size + 1
    
    arr = [0] * (size + 1)
    print(f"\nEnter {size} elements:")
    
    for i in range(1, last):
        arr[i] = int(input())
        child = i
        parent = child // 2
        
        while parent > 0 and arr[parent] < arr[child]:
            swap(arr, parent, child)
            child = parent
            parent = child // 2
    
    while last - 2 > 0:
        delete_node(arr, last - 1)
        last -= 1
    
    print("\nTop Down Sorted array: ")
    print(" ".join(map(str, arr[1:size + 1])))
    print("\n---------------------------------")

def bottom_up_heap():
    size = int(input("\nEnter the size of the array for bottom up approach: "))
    last = size + 1
    
    arr = [0] * (size + 1)
    print(f"\nEnter {size} elements:")
    
    for i in range(1, size + 1):
        arr[i] = int(input())
    
    swapped = True
    
    while swapped:
        swapped = False
        for child in range(last - 1, 1, -1):
            parent = child // 2
            if arr[child] > arr[parent]:
                swap(arr, parent, child)
                swapped = True
    
    while last - 2 > 0:
        delete_node(arr, last - 1)
        last -= 1
    
    print("\nBottom up Sorted array: ")
    print(" ".join(map(str, arr[1:size + 1])))
