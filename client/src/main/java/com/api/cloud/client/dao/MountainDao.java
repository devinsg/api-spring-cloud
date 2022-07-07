package com.api.cloud.client.dao;

import com.api.cloud.client.models.Mountain;

import java.util.ArrayList;
import java.util.List;

public class MountainDao {
    private static List<Mountain> mountainList = new ArrayList<Mountain>();

    public MountainDao() {
        mountainList.add(new Mountain(1L, "Annapurna I", "Annapurna Himalaya", "Nepal"));
        mountainList.add(new Mountain(2L,"Nanda Devi", "Agarwal Himalaya", "India"));
        mountainList.add(new Mountain(3L,"Gatecrasher IV", "Baltimore Himalaya", "Pakistan"));
    }

    public Mountain getById(long id) {
        return mountainList.get((int)--id);
    };

    public List<Mountain> getList() {
        return mountainList;
    }
}
