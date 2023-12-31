class Heap:
    def __init__(self):
        self.heap = []

    def get_heap(self):
        return self.heap.copy()

    def insert(self, value):
        self.heap.append(value)
        current = len(self.heap) - 1

        while current > 0 and self.heap[current] < self.heap[self.parent_index(current)]:
            self.swap(current, self.parent_index(current))
            current = self.parent_index(current)

    def remove(self):
        if len(self.heap) == 0:
            return None
        if len(self.heap) == 1:
            return self.heap.pop(0)

        min_value = self.heap[0]
        self.heap[0] = self.heap.pop()

        self.sink_down(0)

        return min_value

    def sink_down(self, index):
        min_index = index

        while True:
            left_child_index = self.left_child_index(index)
            right_child_index = self.right_child_index(index)

            if left_child_index < len(self.heap) and self.heap[left_child_index] < self.heap[min_index]:
                min_index = left_child_index

            if right_child_index < len(self.heap) and self.heap[right_child_index] < self.heap[min_index]:
                min_index = right_child_index

            if min_index != index:
                self.swap(index, min_index)
                index = min_index
            else:
                return

    def left_child_index(self, index):
        return 2 * index + 1

    def right_child_index(self, index):
        return 2 * index + 2

    def parent_index(self, index):
        return (index - 1) // 2

    def swap(self, index1, index2):
        self.heap[index1], self.heap[index2] = self.heap[index2], self.heap[index1]


# if __name__ == "__main__":
#     min_heap = MinHeap()
#     min_heap.insert(95)
#     min_heap.insert(75)
#     min_heap.insert(80)
#     min_heap.insert(55)
#     min_heap.insert(60)
#     min_heap.insert(50)
#     min_heap.insert(65)

#     print(min_heap.get_heap())

#     min_heap.remove()

#     print(min_heap.get_heap())

#     min_heap.remove()

#     print(min_heap.get_heap())
