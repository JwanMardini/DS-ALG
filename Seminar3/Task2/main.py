from separate_chaining import seperate_chaining as sc
from linear_and_quadratic_probing import linear_and_quadratic_probing as ht

values = [4371, 1323, 6173, 4199, 4344, 9679, 1989]


def main():
    print("seperate_chaining")
    hashTable = sc()
    for i in values:
        hashTable.insert(i)
    hashTable.print_table()
    print()

    print("linear probing")
    hashTable1 = ht()
    for i in values:
        hashTable1.insert_linear(i)
    hashTable1.print_table()
    print()

    print("quadratic probing")
    hashTable2 = ht()
    for i in values:
        hashTable2.insert_quadratic(i)
    hashTable2.print_table()


if __name__ == "__main__":
    main()
