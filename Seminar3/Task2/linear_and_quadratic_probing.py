class linear_and_quadratic_probing:
    def __init__(self):
        self.size = 10
        self.keys = [None] * self.size

    def hash(self, key):
        return key % self.size

    def insert_linear(self, key):
        if None not in self.keys:
            self.__rehash_linear()
        index = self.hash(key)
        while self.keys[index] is not None:
            index = (index + 1) % self.size
        self.keys[index] = key

    def insert_quadratic(self, key):
        if None not in self.keys:
            self.__rehash_quadratic()
        index = self.hash(key)
        i = 1
        while self.keys[index] is not None:
            index = (index + i**2) % self.size
            i += 1
        self.keys[index] = key

    def print_table(self):
        for i in range(0, len(self.keys)):
            print(f"{i}, {self.keys[i]}")

    def __rehash_linear(self):
        copy_of_keys = self.keys.copy()
        self.keys = [None] * len(self.keys) * 2
        self.size = self.size * 2
        for i in copy_of_keys:
            self.insert_linear(i)

    def __rehash_quadratic(self):
        copy_of_keys = self.keys.copy()
        self.keys = [None] * len(self.keys) * 2
        self.size = self.size * 2
        for i in copy_of_keys:
            self.insert_quadratic(i)
