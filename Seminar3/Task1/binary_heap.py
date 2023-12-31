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


def deleteMin(heap):
    if not heap:
        return None

    # Swap the root (minimum element) with the last element
    last_index = len(heap) - 1
    swap(0, last_index, heap)

    # Pop the last element (original root)
    min_value = heap.pop()

    # Heapify to restore the heap property
    heapify(heap, 0, len(heap))

    return min_value


def read_lines_from_file(num_lines):
    try:
        with open("C:/Users/jwanl/OneDrive/Desktop/DS-ALG/Seminar3/Task1/FileWithRandomNumbers.txt", 'r') as file:
            lines = [next(file).strip() for _ in range(num_lines)]
        return lines
    except FileNotFoundError:
        print("Error: File not foundd")
        return []
    except Exception as e:
        print(f"An error occurred: {e}")
        return []


def write_to_file(input_size, time, algo, path):
    try:
        with open(path, 'a') as file:
            file.write(f"Input size: {input_size}, Time: {time}, Algorithm: {algo}\n")
    except FileNotFoundError:
        print("Error: File not found")
    except Exception as e:
        print(f"An error occurred: {e}")


def main():
    # with open("C:/Users/jwanl/OneDrive/Desktop/DS-ALG/Seminar3/Task1/Results.txt", 'w') as clear_file:
    #     pass

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
            print("6. Compare deleteMin")
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
                path = "C:/Users/jwanl/OneDrive/Desktop/DS-ALG/Seminar3/Task1/Results.txt"
                for i in inputs:
                    heap.clear()
                    heap_copy.clear()
                    lines = read_lines_from_file(i)
                    print(len(lines))
                    start = time.perf_counter()
                    for line in lines:
                        insert(int(line), heap)
                    end = time.perf_counter()
                    running_time = (end - start) * 1000000000
                    print(f"Time for {i} inputs: {running_time}")
                    write_to_file(i, running_time, "Insert Algorithm", path)

                    heap_copy = lines.copy()
                    start = time.perf_counter()
                    build_heap(heap_copy)
                    end = time.perf_counter()
                    print(f"Time for {i} inputs: {running_time}")
                    running_time = (end - start) * 1000000000
                    write_to_file(i, running_time, "Heapify Algorithm", path)

            elif choice == 5:
                exit()

            elif choice == 6:
                path = "C:/Users/jwanl/OneDrive/Desktop/DS-ALG/Seminar3/Task1/Results2.txt"
                for i in inputs:
                    heap.clear()
                    heap_copy.clear()
                    lines = read_lines_from_file(i)
                    print(len(lines))
                    for line in lines:
                        insert(int(line), heap)
                    start = time.perf_counter()
                    min_value = deleteMin(heap)
                    end = time.perf_counter()
                    running_time = (end - start) * 1000000000
                    print(f"Time for {i} inputs: {running_time}")
                    write_to_file(i, running_time, "Insert Algorithm " + str(min_value), path)

                    heap_copy = lines.copy()
                    build_heap(heap_copy)
                    start = time.perf_counter()
                    min_value = deleteMin(heap_copy)
                    end = time.perf_counter()
                    running_time = (end - start) * 1000000000
                    print(f"Time for {i} inputs: {running_time}")
                    write_to_file(i, running_time, "Heapify Algorithm " + str(min_value), path)

                write_to_file(0, 0, " ", path)
                for i in inputs:
                    value_to_insert = 29
                    heap.clear()
                    heap_copy.clear()
                    lines = read_lines_from_file(i)
                    print(len(lines))
                    for line in lines:
                        insert(int(line), heap)
                    start = time.perf_counter()
                    insert(value_to_insert, heap)
                    end = time.perf_counter()
                    running_time = (end - start) * 1000000000
                    print(f"Time for {i} inputs: {running_time}")
                    write_to_file(i, running_time, "Insert Algorithm", path)

                    heap_copy = lines.copy()
                    integer_array = [int(x) for x in heap_copy]
                    build_heap(integer_array)
                    start = time.perf_counter()
                    insert(value_to_insert, integer_array)
                    end = time.perf_counter()
                    running_time = (end - start) * 1000000000
                    print(f"Time for {i} inputs: {running_time}")
                    write_to_file(i, running_time, "Heapify Algorithm", path)
            else:
                print("Invalid choice!")
        except ValueError:
            print("Invalid choice!")


if __name__ == "__main__":
    main()
