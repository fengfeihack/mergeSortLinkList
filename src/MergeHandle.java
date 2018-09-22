/**
 * 将单项链表进行合并
 *
 * @author zhangqinghao
 * @createDate 2018-09-21
 */
public class MergeHandle {
/**
 * 合并两个有序单项链表
 *
 * @param l1 第一条有序单链表头节点
 * @param l2 第二条有序单链表头节点
 * @return headNode 合并所得链表的头节点
 */
public Node mergeSortList(Node l1, Node l2) {
    //合并之后链表头节点
    Node headNode;
    //合并之后链表尾节点，用于连接下一节点
    Node tailNode;
    //空处理
    if (null == l1 && null == l2) {
        return null;
    }
    if (null == l1) {
        return l2;
    }
    if (null == l2) {
        return l1;
    }
    //获取合并之后新链表的头节点
    if (l1.data < l2.data) {
        headNode = l1;
        l1 = l1.nextNode;
    } else {
        headNode = l2;
        l2 = l2.nextNode;
    }
    tailNode = headNode;
    //采用循环式遍历并合并，如果采用递归式数据量过大会导致栈溢出
    while (null != l1 && null != l2) {
        if (l1.data < l2.data) {
            tailNode.nextNode = l1;
            l1 = l1.nextNode;
        } else {
            tailNode.nextNode = l2;
            l2 = l2.nextNode;
        }
        tailNode = tailNode.nextNode;
    }
    
    if (null == l1) {
        tailNode.nextNode = l2;
    } else if (null == l2) {
        tailNode.nextNode = l1;
    }
    return headNode;
}

public void printList(Node list) {
    while (list != null) {
        System.out.print(list.data + " ");
        list = list.nextNode;
    }
    System.out.println();
}
}