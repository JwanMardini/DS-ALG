class WordPuzzleSolver:
    def __init__(self, puzzle):
        self.puzzle = puzzle
        self.rows = len(puzzle)
        self.cols = len(puzzle[0])
        self.word_dict = {}

    def build_word_dict(self, words):
        # Build a dictionary of words and their prefixes
        for word in words:
            for i in range(len(word)):
                prefix = word[:i + 1]
                if prefix not in self.word_dict:
                    self.word_dict[prefix] = set()
                self.word_dict[prefix].add(word)

    def search_word(self, word, start_row, start_col, direction):
        # Search for a word in a given direction starting from (start_row, start_col)
        current_row, current_col = start_row, start_col
        for letter in word:
            if (
                current_row < 0
                or current_row >= self.rows
                or current_col < 0
                or current_col >= self.cols
                or self.puzzle[current_row][current_col] != letter
            ):
                return False  # Word not found

            current_row += direction[0]
            current_col += direction[1]

        return True  # Word found

    def solve_puzzle(self, words):
        self.build_word_dict(words)

        # Define the eight possible directions (horizontal, vertical, and diagonal)
        directions = [
            (0, 1),  # right
            (1, 0),  # down
            (1, 1),  # diagonal down-right
            (1, -1),  # diagonal down-left
            (0, -1),  # left
            (-1, 0),  # up
            (-1, -1),  # diagonal up-left
            (-1, 1),  # diagonal up-right
        ]

        found_words = set()

        # Iterate over each cell in the puzzle
        for row in range(self.rows):
            for col in range(self.cols):
                # Check in each direction
                for direction in directions:
                    for word_length in range(1, max(self.rows, self.cols)):
                        end_row = row + (word_length - 1) * direction[0]
                        end_col = col + (word_length - 1) * direction[1]

                        if (
                            0 <= end_row < self.rows
                            and 0 <= end_col < self.cols
                        ):
                            # Form a word using the current position, direction, and length
                            word = "".join(
                                self.puzzle[row + i * direction[0]][col + i * direction[1]]
                                for i in range(word_length)
                            )

                            # Check if the word or its prefixes are in the dictionary
                            if word in self.word_dict:
                                found_words.update(self.word_dict[word])

        return found_words


# Example usage:
puzzle = [
    ['t', 'h', 'i', 's'],
    ['w', 'a', 't', 's'],
    ['o', 'a', 'h', 'g'],
    ['f', 'g', 'd', 't']
]

word_list = ['this', 'two', 'fat', 'that', 'what']

solver = WordPuzzleSolver(puzzle)
found_words = solver.solve_puzzle(word_list)

print("Found words:", found_words)
