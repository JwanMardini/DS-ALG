from separate_chaining import seperate_chaining as sc
from linear_and_quadratic_probing import linear_and_quadratic_probing as ht
import time

values = [4371, 1323, 6173, 4199, 4344, 9679, 1989]


def write_to_file(input_size, time, algo, path):
    try:
        with open(path, 'a') as file:
            file.write(f"Input size: {input_size}, Time: {time}, Algorithm: {algo}\n")
    except FileNotFoundError:
        print("Error: File not found")
    except Exception as e:
        print(f"An error occurred: {e}")


def main():
    path = "C:/Users/jwanl/OneDrive/Desktop/DS-ALG/Seminar3/Task2/Results.txt"
    print("seperate_chaining")
    avg = 0
    for i in range(10):
        hashTable = sc()
        start = time.perf_counter()
        for i in values:
            hashTable.insert(i)
        end = time.perf_counter()
        running_time = (end - start) * 1000000000
        avg += running_time
        print("Time for seperate_chaining: ", running_time)
    hashTable.print_table()
    print()
    write_to_file(0, avg/10, "seperate_chaining", path)

    print("linear probing")
    avg1 = 0
    for i in range(10):
        hashTable1 = ht()
        start1 = time.perf_counter()
        for i in values:
            hashTable1.insert_linear(i)
        end1 = time.perf_counter()
        running_time1 = (end1 - start1) * 1000000000
        avg1 += running_time1
        print("Time for linear probing: ", running_time1)
    hashTable1.print_table()
    print()
    write_to_file(0, avg1/10, "linear probing", path)

    print("quadratic probing")
    avg2 = 0
    for i in range(10):
        hashTable2 = ht()
        start2 = time.perf_counter()
        for i in values:
            hashTable2.insert_quadratic(i)
        end2 = time.perf_counter()
        running_time2 = (end2 - start2) * 1000000000
        avg2 += running_time2
        print("Time for quadratic probing: ", running_time2)
    hashTable2.print_table()
    print()
    write_to_file(0, avg2/10, "quadratic probing", path)


if __name__ == "__main__":
    main()
