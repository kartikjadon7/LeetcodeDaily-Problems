/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map <Node, Node> m = new HashMap<>();
        Node t = head;
        while(t!=null) {
            m.put(t, new Node(t.val));
            t = t.next;
        }
        Node curr = head;

        while(curr != null) {
            Node copy = m.get(curr);
            copy.next = m.get(curr.next);
            copy.random = m.get(curr.random);
            curr = curr.next;
        }
        return m.get(head);
    }
}