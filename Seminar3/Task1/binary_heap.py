import travers as tr
import time



def insert(value, heap):
    heap.append(value)
    current = len(heap) - 1
    while current > 0 and heap[int(current)] < heap[parent_index(int(current))]:
        swap(current, parent_index(current), heap)
        current = parent_index(current)

def heapify(arr, i, n):
    # Source: https://www.geeksforgeeks.org/introduction-to-min-heap-data-structure/
    smallest = i
    left = 2 * i + 1
    right = 2 * i + 2
 
    if left < n and arr[left] < arr[smallest]:
        smallest = left
 
    if right < n and arr[right] < arr[smallest]:
        smallest = right
 
    if smallest != i:
        arr[i], arr[smallest] = arr[smallest], arr[i]
        heapify(arr, smallest, n)


def build_heap(arr):
    for i in range(len(arr) // 2 - 1, -1, -1):
        heapify(arr, i, len(arr))
    

def left_child_index(index):
    return 2 * index + 1


def right_child_index(index):
    return 2 * index + 2


def parent_index(index):
    return (index - 1) // 2


def swap(index1, index2, heap):
    heap[index1], heap[index2] = heap[index2], heap[index1]


def read_lines_from_file(num_lines):
    try:
        with open("Seminar3/Task1/FileWithRandomNumbers.txt", 'r') as file:
            lines = [next(file).strip() for _ in range(num_lines)]
        return lines
    except FileNotFoundError:
        print(f"Error: File not found")
        return []
    except Exception as e:
        print(f"An error occurred: {e}")
        return []

def write_to_file(input_size, time, algo):
    try:
        with open("Seminar3/Task1/Results.txt", 'a') as file:
            file.write(f"Input size: {input_size}, Time: {time}, Algorithm: {algo}\n")
    except FileNotFoundError:
        print(f"Error: File not found")
    except Exception as e:
        print(f"An error occurred: {e}")


def main():
    with open("Seminar3/Task1/Results.txt", 'w') as clear_file:
        pass

    heap = []
    heap_2 = [10, 12, 1, 14, 6, 5, 8, 15, 3, 9, 7, 4, 11, 13, 2]
    heap_copy = heap_2.copy()
    inputs = [100, 1000, 10000, 100000, 1000000]
    while True:
        try:
            heap.clear()
            print()
            print("1. Insert Algorithm")
            print("2. Heapify Algorithm")
            print("3. Trevers Algorithms")
            print("4. Compare Algorithms")
            print("5. Exit")
            choice = int(input("Enter your choice: "))
            if choice == 1:
                print("Insert Algorithm")
                for i in heap_2:
                    insert(i, heap)
                print("Heap: ", heap)

            elif choice == 2:
                print("Heapify Algorithm")
                build_heap(heap_copy)
                print("Heap: ", heap_copy)
            
            elif choice == 3:
                while True:
                    print("Trevers Algorithms")
                    print("1. Algorithm 1")
                    print("2. Algorithm 2")
                    print("3. Exit")
                    print("4. Go Back")
                    choice1 = int(input("Enter your choice: "))
                    if choice1 == 1:
                        for i in heap_2:
                            insert(i)
                        print("Algorithm 1")
                        print("Preorder: ", tr.pre_order(heap))
                        print("Inorder: ", tr.in_order(heap))
                        print("Postorder: ", tr.post_order(heap))
                        print("Level order: ", tr.level_order(heap))
                    elif choice1 == 2:
                        print("Algorithm 2")
                        print("Preorder: ", tr.pre_order(heap_2))
                        print("Inorder: ", tr.in_order(heap_2))
                        print("Postorder: ", tr.post_order(heap_2))
                        print("Level order: ", tr.level_order(heap_2))

                    elif choice1 == 3:
                        exit()

                    elif choice1 == 4:
                        break

                    else:
                        print("Invalid choice!")
            elif choice == 4:
                for i in inputs:
                    heap.clear()
                    heap_copy.clear()
                    lines = read_lines_from_file(i)
                    print(len(lines))
                    start = time.time()
                    for line in lines:
                        insert(int(line), heap)
                    end = time.time()
                    running_time = end - start
                    print(f"Time for {i} inputs: {running_time}")
                    write_to_file(i, running_time, "Insert Algorithm")

                    heap_copy = lines.copy()
                    start = time.time()
                    build_heap(heap_copy)
                    end = time.time()
                    print(f"Time for {i} inputs: {running_time}")
                    running_time = end - start
                    write_to_file(i, running_time, "Heapify Algorithm")
        
            elif choice == 5:
                exit()        
            
            else:
                print("Invalid choice!")
        except ValueError as e:
            print("Invalid choice!")
            


if __name__ == "__main__":
    main()
