import binary_heap as bh


def level_order(heap):
    queue = []
    result = []

    root = 0
    queue.insert(0, root)

    while len(queue) > 0:
        current = queue.pop(0)
        
        result.append(heap[current])
        if bh.left_child_index(current) < len(heap):
            queue.append(bh.left_child_index(current))
        
        if bh.right_child_index(current) < len(heap):
            queue.append(bh.right_child_index(current))

    return result


def pre_order(heap):
    result = []
    current = 0

    def traverse(current):
        if current >= len(heap):
            return

        result.append(heap[current])
        if bh.left_child_index(current) != -1:
            traverse(bh.left_child_index(current))
        
        if bh.right_child_index(current) != -1:
            traverse(bh.right_child_index(current))
    
    traverse(current)

    return result


def post_order(heap):
    result = []
    current = 0

    def traverse(current):
        if current >= len(heap):
            return

        if bh.left_child_index(current) != -1:
            traverse(bh.left_child_index(current))
        
        if bh.right_child_index(current) != -1:
            traverse(bh.right_child_index(current))
        
        result.append(heap[current])
    
    traverse(current)

    return result


def in_order(heap):
    result = []
    current = 0

    def traverse(current):
        if current >= len(heap):
            return

        if bh.left_child_index(current) != -1:
            traverse(bh.left_child_index(current))
        
        result.append(heap[current])

        if bh.right_child_index(current) != -1:
            traverse(bh.right_child_index(current))
    
    traverse(current)

    return result