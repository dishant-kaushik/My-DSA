Problem:

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.

Solution:

struct ListNode* createNode(int val){
    struct ListNode* newNode = (struct ListNode*)malloc(sizeof(struct ListNode));
    newNode->val = val;
    newNode->next = NULL;
    return newNode;
}
void printList(struct ListNode*head){
    while(head!=NULL){
        printf("%d", head->val);
        head = head->next;
    }
    printf("\n");
}
struct ListNode* reverseKGroup(struct ListNode* head, int k) {
    struct ListNode* current = head, *prev = NULL, *next = NULL;
    int count = 0;

    struct ListNode* temp = head;
    for(int i=0; i<k; ++i){
        if(!temp)return head;
        temp = temp->next;
    }
    count =0; 
    while(current!=NULL && count<k){
        next = current->next;
        current->next=prev;
        prev = current;
        current = next;
        count++;
    }
    if(next!=NULL){
        head->next = reverseKGroup(next,k);
    }
    return prev;
}

