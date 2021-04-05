package com.links.links.repositories;

import com.links.links.dto.LinkDTO;
import com.links.links.dto.ResponseLinkDTO;
import com.links.links.exceptions.LinkNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class LinksRepositoriesImpl implements LinksRepository {

    private AtomicInteger count = new AtomicInteger(0);
    private HashMap<Integer, LinkDTO> linksDB = new HashMap<Integer, LinkDTO>();
    @Override
    public int newLink(LinkDTO linkDTO) {
        linksDB.put(count.get(), linkDTO);
        return count.getAndAdd(1);
    }

    public LinkDTO findById(int id) throws LinkNotFoundException {
        LinkDTO link = linksDB.get(id);
        if (link == null)
                throw new LinkNotFoundException();
        return link;
    }

    @Override
    public boolean removeById(int id) {
        LinkDTO link = linksDB.remove(id);
        return link != null;

    }
}
