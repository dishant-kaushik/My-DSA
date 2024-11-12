Problem:
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Solution:

struct ListNode* createnode(int val){
    struct ListNode*node = (struct ListNode*)malloc(sizeof(struct ListNode));
    node->val = val;
    node->next= NULL;
    return node;
}
void printList(struct ListNode* head){
    while(head!= NULL){
        printf("%d",head->val);
        head = head->next;
    }
    printf("\n");
}
void addNodeToEnd(struct ListNode**head,int val){
    struct ListNode* newnode = createnode(val);
    if (*head == NULL) {
        *head = newnode;
    } else {
        struct ListNode* temp = *head;
        while (temp->next != NULL) {
            temp = temp->next;
        }
        temp->next = newnode;
    }
}
struct ListNode* mergeKLists(struct ListNode** lists, int listsSize) {
    struct ListNode *allNodes = NULL;
    for(int i=0; i<listsSize; i++){
        struct ListNode* current = lists[i];
        while(current != NULL){
            addNodeToEnd(&allNodes, current->val);
            current = current->next;
        }
    }
    struct ListNode *sortedList = NULL;
    struct ListNode *current = allNodes;
    int numNodes = 0;
    while(current != NULL){
        numNodes++;
        current = current->next;
    }
    int* arr = (int*)malloc(numNodes * sizeof(int));
    current = allNodes;
    for (int i = 0; i < numNodes; i++) {
        arr[i] = current->val;
        current = current->next;
    }
     for (int i = 0; i < numNodes - 1; i++) {
        for (int j = 0; j < numNodes - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    for (int i = 0; i < numNodes; i++) {
        addNodeToEnd(&sortedList, arr[i]);
    }

    free(arr);
    return sortedList;
}
