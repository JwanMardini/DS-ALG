from bst import BST
from avl import AVL_Tree
from red_black import RBTree
from heap import Heap
import time


def main():
    result_path = "C:/Users/jwanl/OneDrive/Desktop/DS-ALG/Seminar3/Task4/Results.txt"
    bst = BST()
    avl = AVL_Tree()
    rb = RBTree()
    hp = Heap()

    # insert
    lines = read_lines_from_file(75)
    root = None
    for line in lines:
        bst.insert(int(line))
        root = avl.insert(root, int(line))
        rb.insert(int(line))

    element_to_insert = 55
    start_time = time.perf_counter()
    bst.insert(element_to_insert)
    end_time = time.perf_counter()
    running_time = (end_time - start_time) * 1000000000
    print(f"Time for BST to insert {element_to_insert}: {running_time}")
    write_to_file(10000, running_time, "BST Insert", result_path)

    start_time = time.perf_counter()
    avl.insert(root, element_to_insert)
    end_time = time.perf_counter()
    running_time = (end_time - start_time) * 1000000000
    print(f"Time for AVL to insert {element_to_insert}: {running_time}")
    write_to_file(10000, running_time, "AVL Insert", result_path)

    start_time = time.perf_counter()
    rb.insert(element_to_insert)
    end_time = time.perf_counter()
    running_time = (end_time - start_time) * 1000000000
    print(f"Time for RB to insert {element_to_insert}: {running_time}")
    write_to_file(10000, running_time, "RB Insert", result_path)

    start_time = time.perf_counter()
    hp.insert(element_to_insert)
    end_time = time.perf_counter()
    running_time = (end_time - start_time) * 1000000000
    print(f"Time for Heap to insert {element_to_insert}: {running_time}")
    write_to_file(10000, running_time, "Heap Insert", result_path)

    # delete
    element_to_delete = 55
    start_time = time.perf_counter()
    bst.delete(element_to_delete)
    end_time = time.perf_counter()
    running_time = (end_time - start_time) * 1000000000
    print(f"Time for BST to delete {element_to_delete}: {running_time}")
    write_to_file(10000, running_time, "BST Delete", result_path)

    start_time = time.perf_counter()
    avl.delete(root, element_to_delete)
    end_time = time.perf_counter()
    running_time = (end_time - start_time) * 1000000000
    print(f"Time for AVL to delete {element_to_delete}: {running_time}")
    write_to_file(10000, running_time, "AVL Delete", result_path)

    start_time = time.perf_counter()
    rb.deleteByVal(element_to_delete)
    end_time = time.perf_counter()
    running_time = (end_time - start_time) * 1000000000
    print(f"Time for RB to delete {element_to_delete}: {running_time}")
    write_to_file(10000, running_time, "RB Delete", result_path)

    start_time = time.perf_counter()
    hp.remove()
    end_time = time.perf_counter()
    running_time = (end_time - start_time) * 1000000000
    print(f"Time for Heap to delete {element_to_delete}: {running_time}")
    write_to_file(10000, running_time, "Heap Delete", result_path)


def read_lines_from_file(num_lines):
    try:
        with open("C:/Users/jwanl/OneDrive/Desktop/DS-ALG/Seminar3/Task4/FileWithRandomNumbers.txt", 'r') as file:
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


if __name__ == "__main__":
    main()
