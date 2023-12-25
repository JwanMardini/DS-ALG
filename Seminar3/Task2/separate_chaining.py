class seperate_chaining:
    def __init__(self):
        self.size = 10
        self.nodes = [None] * self.size

    class Node:
        key = ""
        value = 0
        next = None

        def __init__(self, key, value):
            self.key = key
            self.value = value

    # def hash(self, key):
    #     hash = 0
    #     key_char = [char for char in key]
    #     for i in key_char:
    #         ascii_code = ord(i)
    #         hash = (hash + ascii_code * 23) % len(self.nodes)
    #     return hash

    def hash(self, key):
        return key % self.size

    def insert(self, key):
        index = self.hash(key)
        new_node = seperate_chaining.Node(key, None)
        if self.nodes[index] is None:
            self.nodes[index] = new_node
        else:
            temp = self.nodes[index]
            while temp.next is not None:
                temp = temp.next
            temp.next = new_node

    def print_table(self):
        for i in range(0, len(self.nodes)):
            print(f"{i}:")
            temp = self.nodes[i]
            while temp is not None:
                print(f"{temp.key}, {temp.value}")
                temp = temp.next
