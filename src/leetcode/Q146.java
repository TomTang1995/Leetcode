package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q146
{
    static class LRUCacheNode
    {
        int key;
        int value;
        LRUCacheNode prev;
        LRUCacheNode back;

        public LRUCacheNode()
        {

        }

        public LRUCacheNode(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }

    LRUCacheNode first;
    LRUCacheNode last;
    Map<Integer, LRUCacheNode> map;
    int size;
    int capacity;

    public Q146(int capacity)
    {
        first = null;
        last = null;
        map = new HashMap<>();
        size = 0;
        this.capacity = capacity;
    }

    public int get(int key)
    {
        if(!map.containsKey(key))
            return -1;

        // 一定存在该key对应的节点
        LRUCacheNode actualNode = map.get(key);
        if(size == 1)
            return actualNode.value;

        // size > 1
        if(first == actualNode) // 是第一个节点
        {
            first = actualNode.back;
            first.prev = null;
            actualNode.prev = last;
            actualNode.back = null;
            last.back = actualNode;
            last = actualNode;
        }
        else if(last == actualNode) // 是最后一个节点
        {
            // do nothing
        }
        else    // 是中间节点
        {
            LRUCacheNode leftNode = actualNode.prev;
            LRUCacheNode rightNode= actualNode.back;
            leftNode.back = rightNode;
            rightNode.prev = leftNode;
            actualNode.prev = last;
            actualNode.back = null;
            last.back = actualNode;
            last = actualNode;
        }

        return actualNode.value;
    }

    public void put(int key, int value)
    {
        if(size == 0)
        {
            LRUCacheNode node = new LRUCacheNode(key, value);
            node.prev = null;
            node.back = null;
            first = node;
            last = node;
            map.put(key, node);
            size++;
        }
        else
        {
            if(map.containsKey(key))    // 需要更新值并移动节点到链表最后
            {
                LRUCacheNode actualNode = map.get(key);
                actualNode.value = value;
                get(key);
            }
            else    //需要添加新节点并判断是否需要删除节点
            {
                LRUCacheNode node = new LRUCacheNode(key, value);
                if(capacity == 1)   // 移除已有节点
                {
                    map.clear();
                    node.prev = null;
                    node.back = null;
                    first = node;
                    last = node;
                    size--;
                }
                else if(size < capacity)    // 直接添加新节点
                {
                    node.prev = last;
                    node.back = null;
                    last.back = node;
                    last = node;
                }
                else    // 移除头节点
                {
                    int removeKey = first.key;
                    node.prev = last;
                    last.back = node;
                    last = node;
                    first = first.back;
                    size--;
                    map.remove(removeKey);
                }
                map.put(key, node);
                size++;
            }
        }
    }
}