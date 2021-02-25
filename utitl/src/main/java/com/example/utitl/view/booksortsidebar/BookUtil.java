package com.example.utitl.view.booksortsidebar;

import java.util.List;

public class BookUtil
{
    /**
     * 获取catalog首次出现位置
     */
    public int getPositionForSection(List<BooksortSidebar> lists,String catalog) {
        for (int i = 0; i < lists.size(); i++) {
            String sortStr = lists.get(i).getFirstLetter();
            if (catalog.equalsIgnoreCase(sortStr)) {
                return i;
            }
        }
        return -1;
    }
}
