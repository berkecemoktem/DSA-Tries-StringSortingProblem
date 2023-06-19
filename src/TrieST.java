public class TrieST<Value> {
    private static final int R = 256; // Assuming extended ASCII

    private Node root;

    private class Node {
        private Value val;
        private Node[] next;

        @SuppressWarnings("unchecked")
        public Node() {
            this.next = new TrieST.Node[R];
            for (int i = 0; i < R; i++) {
                this.next[i] = null;
            }
        }
    }


    public TrieST() {
        root = new Node();
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if (x == null) {
            x = new Node();
        }
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        if (d == key.length()) {
            return x;
        }
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }
    
    public char getLetterAtIndex(String[] array, int index) {
        String word = array[index];
        Node node = get(root, word, 0);
        if (node != null) {
            for (char c : word.toCharArray()) {
                if (node.next[c - 'a'] != null) {
                    return c;
                }
            }
        }
        return '\0'; // Return null character if not found
    }

    public String[] getHighestPriorityChars(String[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Invalid array");
        }

        String[] highestPriorityChars = new String[array.length];

        for (int i = 0; i < array.length; i++) {
            String str = array[i];
            Node currentNode = root;

            // Traverse the trie for the current string
            for (char c : str.toCharArray()) {
                if (currentNode.next[c] == null) {
                    break;
                }
                currentNode = currentNode.next[c];
            }

            // Get the starting character of the current string
            highestPriorityChars[i] = String.valueOf(str.charAt(0));
        }

        return highestPriorityChars;
    }
    public String[] getLeastPriorityChars(String[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Invalid array");
        }

        String[] leastPriorityChars = new String[array.length];

        for (int i = 0; i < array.length; i++) {
            String str = array[i];
            Node currentNode = root;

            // Traverse the trie for the current string
            for (char c : str.toCharArray()) {
                if (currentNode.next[c] == null) {
                    break;
                }
                currentNode = currentNode.next[c];
            }

            // Get the least priority character in the current string
            leastPriorityChars[i] = String.valueOf(str.charAt(str.length() - 1));
        }

        return leastPriorityChars;
    }


}
