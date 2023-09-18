from abc import abstractmethod
from typing import Generic, Optional, TypeVar

# Created for BADS 2018
# See README.md for details
# Python 3

# Typing ---

Key = TypeVar("Key")
Val = TypeVar("Val")

# ---
class Node(Generic[Key, Val]):
    """RedBlackBST helper node data type."""

    def __init__(self, key: Key, val: Val, color: bool, size: int):
        """Initializes a new node.
        :param key: the key of the node
        :param val: the value of the node
        :param size: the subtree count
        """
        self.key: Key = key
        self.val: Val = val
        self.left: Optional[Node[Key, Val]] = None
        self.right: Optional[Node[Key, Val]] = None
        self.size: int = size
        self.color: bool = color


class RedBlackBST(Generic[Key, Val]):
    """The RedBlackBST class represents an ordered symbol table of generic key-
    value pairs.
    It supports the usual put, get, contains, delete, size, and is-empty
    methods. It also provides ordered methods for finding the minimum,
    maximum, floor, and ceiling. It also provides a keys method for
    iterating over all the keys. A symbol table implements the
    associative array abstraction: when associating a value with a key
    that is already in the symbol table, the convention is to replace
    the old value with the new value. This class uses the convention
    that values cannot be None-setting the value associated with a key
    to None is equivalent to deleting the key from the symbol table.
    This implementation uses a left-leaning red-black BST. It requires
    that the keys are all of the same type and that they can be
    compared. The put, contains, remove, minimum, maximum, ceiling, and
    floor operations each take logarithmic time in the worst case, if
    the tree becomes unbalanced. The size, and is-empty operations take
    constant time. Construction takes constant time.
    """

    RED = True
    BLACK = False

    def __init__(self) -> None:
        """Initializes an empty symbol table."""
        self._root: Optional[Node[Key, Val]] = None

    def put(self, key: Key, val: Val) -> None:
        """Inserts the specified key-value pair into the symbol table,
        overwriting the old value with the new value if the symbol table
        already contains the specified key. Deletes the specified key (and its
        associated value) from this symbol table if the specified value is
        None.
        :param key: the key
        :param val: the value
        """
        # Can never happen if type checked:
        if key is None:
            return
        if val is None:
            self.delete(key)
            return

        self._root = self._put(self._root, key, val)
        self._root.color = RedBlackBST.BLACK

    def _put(self, h: Optional[Node[Key, Val]], key: Key, val: Val) -> Node[Key, Val]:
        """Inserts the key-value pair in the subtree rooted at h.
        :param h: root of currently inspected subtree
        :param key: the key
        :param val: the value
        """
        if h is None:
            return Node(key, val, self.RED, 1)
        if key < h.key:
            h.left = self._put(h.left, key, val)
        elif key > h.key:
            h.right = self._put(h.right, key, val)
        else:
            h.val = val

        assert h is not None
        if self._is_red(h.right) and not self._is_red(h.left):
            h = self._rotate_left(h)
        assert h is not None
        if self._is_red(h.left):
            assert h.left is not None  # bc h.left is red
            if self._is_red(h.left.left):
                h = self._rotate_right(h)
        assert h is not None
        if self._is_red(h.left) and self._is_red(h.right):
            self._flip_colors(h)

        h.size = self._size(h.left) + self._size(h.right) + 1

        return h

    def get(self, key: Key) -> Optional[Val]:
        """Returns the value associated with the given key.
        :param key: the key
        :return: the value associated with the given key if the key is in the symbol table
        and None if the key is not in the symbol table
        """
        # This can never happen if type checked:
        if key is None:
            return None

        return self._get(self._root, key)

    def _get(self, x: Optional[Node[Key, Val]], key: Key) -> Optional[Val]:
        """Returns value with the given key in subtree rooted at x. None if no
        such key.
        :param x: root of currently inspected subtree.
        :param key: the key
        :return: value associated with given key. None if no such key
        """
        while x is not None:
            if key < x.key:
                x = x.left
            elif key > x.key:
                x = x.right
            else:
                return x.val
        return None

    def contains(self, key: Key) -> bool:
        """Does this symbol table contain the given key?
        :param key: the key
        :return: True if this symbol table contains key and False otherwise
        """
        return self.get(key) is not None

    def is_empty(self) -> bool:
        """Is this symbol table empty?
        :return: True if this symbol table is empty and False otherwise
        """
        return self._root is None

    @classmethod
    def _is_red(self, x: Optional[Node[Key, Val]]) -> bool:
        """Is node x red?
        :param x: the node to check
        :return: True if node is red False otherwise
        """
        if x is None:
            return False
        return x.color == RedBlackBST.RED

    def _rotate_left(self, h: Node[Key, Val]) -> Node[Key, Val]:
        """Make a right-leaning link lean to the left.
        :param h:
        :return: The node that has taken h's position
        """
        x = h.right
        assert x is not None  # bc h has a right-leaning (red) link
        h.right = x.left
        x.left = h
        x.color = h.color
        h.color = self.RED
        x.size = h.size
        h.size = self._size(h.left) + self._size(h.right) + 1
        return x

    def _rotate_right(self, h: Node[Key, Val]) -> Node[Key, Val]:
        """Make a left-leaning link lean to the right.
        :param h:
        :return: The node that has taken h's position
        """
        x = h.left
        assert x is not None  # bc h has a left-leaning (red) link
        h.left = x.right
        x.right = h
        x.color = h.color
        h.color = self.RED
        x.size = h.size
        h.size = self._size(h.left) + self._size(h.right) + 1
        return x

    def _flip_colors(self, h: Node[Key, Val]) -> None:
        """Flip the colors of a node and its two children.
        :param h: the node
        """
        assert h.left is not None
        assert h.right is not None
        h.color = not h.color
        h.left.color = not h.left.color
        h.right.color = not h.right.color

    def _move_red_left(self, h: Node[Key, Val]) -> Node[Key, Val]:
        """Assuming that h is red and both h.left and h.left.left are black,
        make h.left or one of its children red.
        Assumes h.right exists
        """
        assert h.right is not None
        self._flip_colors(h)
        if self._is_red(h.right.left):
            h.right = self._rotate_right(h.right)
            h = self._rotate_left(h)
            self._flip_colors(h)
        return h

    def _move_red_right(self, h: Node[Key, Val]) -> Node[Key, Val]:
        """Assuming that h is red and both h.right and h.right.left are black,
        make h.right or one of its children red."""
        assert h.left is not None  # more is true: h.right.left exists and is not red
        self._flip_colors(h)
        if self._is_red(h.left.left):
            h = self._rotate_right(h)
            self._flip_colors(h)
        return h

    def _balance(self, h: Node[Key, Val]) -> Node[Key, Val]:
        """Restore red-black tree invariant."""
        if self._is_red(h.right) and not self._is_red(h.left):
            h = self._rotate_left(h)
        if self._is_red(h.left):
            assert h.left is not None
            if self._is_red(h.left.left):
                h = self._rotate_right(h)
        if self._is_red(h.left) and self._is_red(h.right):
            self._flip_colors(h)
        h.size = self._size(h.left) + self._size(h.right) + 1
        return h
    
    def _size(self, x: Optional[Node[Key, Val]]) -> int:
        """Number of nodes in subtree rooted at x. 0 if x is None.
        :param x: root node of subtree
        :return: number of nodes in subtree
        """
        if x is None:
            return 0
        return x.size

    def floor(self, key: Key) -> Key:
        """Returns the largest key in the symbol table less than or equal to
        key.
        :param key: the key
        :return: the largest key in the symbol table less than er equal to key
        """
        if key is None:
            return None
        if self.is_empty():
            return None
        x = self._floor(self._root, key)
        if x is None:
            return None
        return x.key

    def _floor(self, x: Optional[Node[Key, Val]], key: Key) -> Optional[Node[Key, Val]]:
        """Returns the largest key in the subtree rooted at x less than or
        equal to the given key."""
        if x is None:
            return None
        if key == x.key:
            return x
        if key < x.key:
            return self._floor(x.left, key)
        t = self._floor(x.right, key)
        if t is not None:
            return t
        return x

    def ceiling(self, key: Key) -> Key:
        """Returns the smallest key in the symbol table greater than or equal
        to key.
        :param key: the key
        :return: the smallest key in the symbol table greater than or equal to key
        """
        if key is None:
            return None
        if self.is_empty():
            return None
        x = self._ceiling(self._root, key)
        if x is None:
            return None
        return x.key

    def _ceiling(
        self, x: Optional[Node[Key, Val]], key: Key
    ) -> Optional[Node[Key, Val]]:
        """Returns the node with the smallest key in the subtree rooted at x
        greater than or equal to the given key."""
        if x is None:
            return None
        assert x is not None
        if key == x.key:
            return x
        if key > x.key:
            return self._ceiling(x.right, key)
        t = self._ceiling(x.left, key)
        if t is not None:
            return t
        return x


# ------------------------------------------------

n = int(input())
ftree = [0]*(100001)
n_list = list(map(int, input().split()))
n_list.sort()

bst = RedBlackBST()
distinct = 0

for i in n_list:
    if not bst.contains(i):
        bst.put(i, distinct)
        distinct += 1

out = []

def fenwicksum(pos):
    pos += 1
    sum = 0
    while pos > 0:
        sum += ftree[pos]
        pos -= (pos & -pos)
    return sum

def fenwickadd(pos, val):
    i = pos + 1
    while i < len(ftree):
        ftree[i] += val
        i += (i & -i)

for i in n_list:
    fenwickadd(bst.get(i), 1)

q = int(input())
for i in range(q):
    l,r = list(map(int, input().split()))
    L = bst.get(bst.ceiling(l))
    R = bst.get(bst.floor(r))
    if L == None or R == None:
        out.append(0)
    else: 
        out.append(fenwicksum(R)-fenwicksum(L-1))

print("\n".join(str(x) for x in out))