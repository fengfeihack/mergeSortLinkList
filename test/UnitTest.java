import org.junit.Test;


public class UnitTest {
/**
 * 测试一：两条链表同时为null
 */
@Test
public void mergeSostTest1() {
    Node l1 = null;
    Node l2 = null;
    Node l = new MergeHandle().mergeSortList(l1, l2);
    assert (null == l);
}

/**
 * 测试二：第二条链表为null，第一条有数据
 */
@Test
public void mergeSostTest2() {
    Node l1 = new Node(0);
    l1.nextNode = new Node(1);
    Node l2 = null;
    Node l = new MergeHandle().mergeSortList(l1, l2);
    assert (l.equals(l1));
}

/**
 * 测试三：第一条链表为null，第二条有数据
 */
@Test
public void mergeSostTest3() {
    Node l1 = null;
    Node l2 = new Node(0);
    l2.nextNode = new Node(1);
    Node l = new MergeHandle().mergeSortList(l1, l2);
    assert (l.equals(l2));
}

/**
 * 测试四：正常情况下，两条链表数据量不对称测试
 */
@Test
public void mergeSostTest4() {
    MergeHandle mergeHandle = new MergeHandle();
    Node l1 = new Node(0);
    l1.nextNode = new Node(4);
    l1.nextNode.nextNode = new Node(5);
    System.out.print("第一条链表 l1: ");
    mergeHandle.printList(l1);
    Node l2 = new Node(1);
    System.out.print("第一条链表 l2: ");
    mergeHandle.printList(l2);
    Node l = mergeHandle.mergeSortList(l1, l2);
    System.out.println("合并结果 : ");
    mergeHandle.printList(l);
}

/**
 * 测试五：500数据量下的结果测试
 */
@Test
public void mergeSostTest5() {
    MergeHandle mergeHandle = new MergeHandle();
    //合并结果
    Node l = null;
    Node l1 = new Node(0);
    Node l2 = new Node(1);
    Node head1 = l1;
    Node head2 = l2;
    //生成指定长度的两条单链表
    for (int i = 2; i < 500; i += 2) {
        Node node1 = new Node(i);
        Node node2 = new Node(i + 1);
        l1.nextNode = node1;
        l1 = node1;
        l2.nextNode = node2;
        l2 = node2;
    }
    System.out.print("第一条链表 l1: ");
    mergeHandle.printList(head1);
    System.out.print("第一条链表 l2: ");
    mergeHandle.printList(head2);
    l = mergeHandle.mergeSortList(head1, head2);
    System.out.println("合并结果 l: ");
    mergeHandle.printList(l);
}

/**
 * 测试六：大数据量情况下的所耗时间测试
 * 结果：在数据量达37000000左右时合并耗时在220ms左右
 *
 * @throws OutOfMemoryError GC overhead limit exceeded
 *                          数据量再大的情况下会导致堆内存不足，在生成链表的过程中无法创建新节点导致报错。
 */
@Test
public void mergeSostTest6() {
    MergeHandle mergeHandle = new MergeHandle();
    //合并结果
    Node l = null;
    Node l1 = new Node(0);
    Node l2 = new Node(1);
    Node head1 = l1;
    Node head2 = l2;
    //生成指定长度的两条单链表
    for (int i = 2; i < 37000000; i += 2) {
        Node node1 = new Node(i);
        Node node2 = new Node(i + 1);
        l1.nextNode = node1;
        l1 = node1;
        l2.nextNode = node2;
        l2 = node2;
    }
    Long startTime = System.currentTimeMillis();
    mergeHandle.mergeSortList(head1, head2);
    Long endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime + "ms");
}
}



