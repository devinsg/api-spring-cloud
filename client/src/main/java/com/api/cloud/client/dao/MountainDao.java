package com.api.cloud.client.dao;

import com.api.cloud.client.models.Mountain;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MountainDao {
    private static Map<Long, Mountain> summits = new HashMap<Long, Mountain>();
    {
        summits.put(1L, new Mountain(1L, "Annapurna I", "Annapurna Himalaya", "Nepal"));
        summits.put(2L, new Mountain(2L,"Nanda Devi", "Garhwal Himalaya", "India"));
        summits.put(3L, new Mountain(3L,"Gasherbrum IV", "Baltoro Himalaya", "Pakistan"));
    };

    public Mountain getById(Long key) {
        return summits.get(key);
    };
}
