package com.jxiao.year20;

class MaxQueue {
    int[] Queue;
    int QueueHead = 0;
    int QueueTail = 0;
    int[] MAXQueue;
    int MAXQueueHead = 0;
    int MAXQueueTail = 0;

    public MaxQueue() {
        Queue = new int[10000];
        MAXQueue = new int[10000];
    }

    public int max_value() {
        if (MAXQueueHead == MAXQueueTail) {
            // 头尾相等的时候，表示此时队列为空，没有最大值
            return -1;
        }
        return MAXQueue[MAXQueueHead];
    }

    public void push_back(int value) {
        Queue[QueueTail++] = value;
        while (MAXQueueHead != MAXQueueTail && MAXQueue[MAXQueueTail - 1] < value) { //
            // MAXQueueTail-1 因为MAXQueueTail处的值是0，还没有被初始化
            // 比value小的值，一定会在value出栈前，先出栈， //
            // 队列中的最大值最少都是value，就没有保存比value小的值的必要了
            MAXQueueTail--;
        }
        MAXQueue[MAXQueueTail++] = value;
    }

    public int pop_front() {
        if (QueueHead == QueueTail) {
            // 队列为空
            return -1;
        } int res = Queue[QueueHead];
        if (res == MAXQueue[MAXQueueHead]) {
            MAXQueueHead++;
        }
        QueueHead++;
        return res;
    }
}


