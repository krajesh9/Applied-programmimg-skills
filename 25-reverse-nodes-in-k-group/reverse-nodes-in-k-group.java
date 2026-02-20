class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<ListNode> tails = new ArrayList<>();
        ListNode temp = head;
        int size=0;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        ListNode ans = new ListNode();
        ans.next = head;
        ListNode nextNode = ans.next;
        tails.add(null); //tail for first list
        tails.add(nextNode); //tail for the next list
        int repeat = size/k;
        int counter = 0;
        int countRepeats = 0;
        ListNode current = null;
        while(countRepeats<repeat){
            if(counter == k){
                countRepeats++;
                counter = 0;
                //get tail to connect
                ListNode h = tails.remove(0);
                //add current processed tail for future connection
                tails.add(nextNode);
                if(h==null){//if tails is null, it's the first reversed list.
                    ans.next = current; //current is the new head for complete list
                    current = null;
                    continue;
                }
                h.next = current; //connect reversed lists, tail of last and head of next.
                current = null;
                continue;
            }
            temp = nextNode;
            nextNode = nextNode.next;
            temp.next = current;
            current = temp;
            counter++;
        }
        if(nextNode!=null){ //if nodes are left unprocessed, connect them with the processed list.
            ListNode h = tails.remove(0);
            h.next = nextNode;
        }
        return ans.next;
    }
}