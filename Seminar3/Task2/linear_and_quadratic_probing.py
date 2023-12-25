class linear_and_quadratic_probing:
    def __init__(self):
        self.size = 10
        self.keys = [None] * self.size

    def hash(self, key):
        return key % self.size

    def insert_linear(self, key):
        index = self.hash(key)
        if None not in self.keys:
            print("Hash Table is full")
            return
        while self.keys[index] is not None:
            index = (index + 1) % self.size
        self.keys[index] = key

    def insert_quadratic(self, key):
        index = self.hash(key)
        i = 1
        if None not in self.keys:
            print("Hash Table is full")
            return
        while self.keys[index] is not None:
            index = (index + i**2) % self.size
            i += 1
        self.keys[index] = key

    def print_table(self):
        for i in range(0, len(self.keys)):
            print(f"{i}, {self.keys[i]}")
