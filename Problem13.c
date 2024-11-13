Problem:
Given a linked list, swap every two adjacent nodes and return its head. 
You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

  
Solution:

struct ListNode* createNode(int val){
    struct ListNode* newNode = (struct ListNode*)malloc(sizeof(struct ListNode));
    newNode->val  = val;
    newNode->next = NULL;
    return newNode;
}
void printValue(struct ListNode* head){
    while(head){
        printf("%d", head->val);
        if(head->next){
            printf("->");
        }
        head = head->next;
    }
    printf("\n");
}
struct ListNode* swapPairs(struct ListNode* head) {
    struct ListNode* store = (struct ListNode*)malloc(sizeof(struct ListNode));
    store->next = head;
    struct ListNode* prev = store;

    while(head && head->next){
        struct ListNode* first = head;
        struct ListNode* second = head->next;

        prev->next = second;
        first->next = second->next;
        second->next = first;

        prev = first;
        head = first->next;
    }
    struct ListNode* newHead = store->next;
    free(store);
    return newHead;
}


