package org.hiraeth.govern.common.domain;

import lombok.Getter;

/**
 * @author: lynch
 * @description:
 * @date: 2023/11/30 22:32
 */
@Getter
public enum RequestType {
    FetchSlot(1);

    private int value;

    RequestType(int val) {
        this.value = val;
    }

    public static RequestType of(int value) {
        for (RequestType item : RequestType.values()) {
            if (item.value == value) {
                return item;
            }
        }
        return null;
    }

}
