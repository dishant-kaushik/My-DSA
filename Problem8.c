Problem:
REMOVE NTH NODE FROM THE END OF LIST

Solution:

struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    struct ListNode* newnode = (struct ListNode*)malloc(sizeof(struct ListNode));
    newnode->next = head;
    struct ListNode *p = newnode, *loc = newnode;

    for (int i = 0; i <= n; i++) {
        if (p == NULL) {
            return head;
        }
        p = p->next;
    }
    while (p != NULL) {
        p = p->next;
        loc = loc->next;
    }
    struct ListNode* toDelete = loc->next;

    loc->next = loc->next->next;
    free(toDelete);

    struct ListNode* newHead = newnode->next;
    free(newnode);
    return newHead;
}

