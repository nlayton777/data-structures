package com.nlayton.structs;

import java.util.List;

/**
 * @author nick.layton
 * @since Nov-2019
 */
public interface NickLists {

    static <E> List<E> linkedList() {
        return new NickLinkedList<>();
    }

}
