class BST:
    def __init__(self):
        self.root = None

    class Node:
        def __init__(self, value):
            self.value = value
            self.left = None
            self.right = None

    def insert(self, value):
        newNode = BST.Node(value)
        if self.root is None:
            self.root = newNode
            return True
        temp = self.root
        while True:
            if newNode.value == temp.value:
                return False
            if newNode.value < temp.value:
                if temp.left is None:
                    temp.left = newNode
                    return True
                temp = temp.left
            else:
                if temp.right is None:
                    temp.right = newNode
                    return True
                temp = temp.right

    def print_tree(self, tree):
        result = []

        def traverse(node):
            if node is None:
                return
            result.append(node.value)
            traverse(node.left)
            traverse(node.right)

        traverse(tree.root)

        return result
    
    def delete(self, value):
        def delete_node(node, value):
            if node is None:
                return node
            if value < node.value:
                node.left = delete_node(node.left, value)
            elif value > node.value:
                node.right = delete_node(node.right, value)
            else:
                if node.left is None:
                    temp = node.right
                    node = None
                    return temp
                elif node.right is None:
                    temp = node.left
                    node = None
                    return temp
                temp = self.getMinValueNode(node.right)
                node.value = temp.value
                node.right = delete_node(node.right, temp.value)
            return node

        self.root = delete_node(self.root, value)


# def main():
#     bst = BST()
#     bst.insert(5)
#     bst.insert(3)
#     bst.insert(7)
#     bst.insert(2)
#     bst.insert(4)

#     print(bst.print_tree(bst))  # Output: [5, 3, 2, 4, 7]


# if __name__ == '__main__':
#     main()
