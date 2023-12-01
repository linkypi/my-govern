package org.hiraeth.govern.server.node.entity;

import lombok.Getter;

/**
 * @author: lynch
 * @description:
 * @date: 2023/11/28 17:39
 */
@Getter
public enum MessageType {

    /**
     * 发送当前节点信息，包括 node.id, isControllerCandidate等信息
     */
    NodeInfo(1),
    /**
     * 发起投票
     */
    Vote(2),

    // leader已选举完成, 待确认
    ElectionComplete(3),
    // 对方已确认选举结果
    ElectionCompleteAck(4),
    // 选举结果已得到多数人确认, 新领导开始上任
    Leading(5),
    // 槽位分配
    AllocateSlots(6),
    // 通知leader, 当前 follower 已收到槽位分配结果
    AllocateSlotsAck(7),
    // 向所有leader通知: 大多数 follower 已确认当前槽位分配
    AllocateSlotsConfirm(8)
    ;
    MessageType(int value){
        this.value = value;
    }
    private int value;

    public static MessageType of(int value){
        for(MessageType item: MessageType.values()){
            if(value == item.value){
                return item;
            }
        }
        return null;
    }
}
