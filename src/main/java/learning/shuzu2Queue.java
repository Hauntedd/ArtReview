package main.java.learning;

/**
 * 使用数组实现长度队列结构
 * start：队首，拿取一个数，要存放的位置
 * end： 队尾，新加一个元素，应该放在哪个位置，只要end到了数组的长度-1，就回到开头
 * size： 队列中的元素的个数
 * 用来约束start和end，只要size没有到达数组的长度，就可以在end位置上放数，
 * 如果size不等于0，总是把start位置的数，给用户。
 */

public class shuzu2Queue {
    private int[] data;
    private int start;
    private int end;
    private int size;

    public shuzu2Queue(int init){
        if(init <0)
            throw new IllegalArgumentException("长度不得小于0");
        data = new int[init];
        start = 0;
        end = 0;
        size = init;
    }

    public boolean offer(int value){//添加元素
        if(size == data.length){
            return false;
        }
        data[end] = value;
        size++;
        end = (end == data.length - 1) ? 0:end + 1 ;
        return true;
    }

    public int pop(){//删除并取得队列首元素
        if(size == 0){
            throw new IllegalArgumentException("当前队列为空");
        }
        int result = data[start];
        size--;
        start = (start == data.length - 1) ? 0: start + 1;
        return result;
    }

    public int peek(){
        if(size == 0){
            throw new IllegalArgumentException("当前队列为空");
        }
        return data[start];

    }
}
