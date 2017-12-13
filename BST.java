/*
 * Deze klasse is een API van het boek: Algorithhms 4th Edition by Robert Sedgewick, Kevin Wayne.
 * Er zijn kleine aanpassingen toegevoegd om ervoor te zorgen dat we duplicaten kunnen afhandelen.
 * We hebben in de Node klasse een ArrayList gemaakt waar alle values in komen met de zelfde key.
 * In ons geval werken we met studenten die allemaal een uniek student nummer hebben en een cijfer als key.
 */
package com.mycompany.snsp1;

import java.util.ArrayList;

/**
 *
 * @author Miguel & Jordi
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {

        private final Key key;
        private final ArrayList val = new ArrayList();
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            if (val != null) {
                this.val.add(val);
            }
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    public ArrayList get(Key key) {
        return get(root, key);
    }

    private ArrayList get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        ArrayList res = new ArrayList();
        int cmp = key.compareTo(x.key);

        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {

            for (int i = 0; i < x.val.size(); i++) {
                res.add(x.val.get(i));
            }
            
            return res;
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val.add(val);
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public int getDubbel(Key key) {

        return getDubble(root);
    }

    private int getDubble(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.val.size();
        }
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);

        if (cmp < 0) {
            return rank(key, x.left);
        } else if (cmp > 0) {
            return size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }
}
