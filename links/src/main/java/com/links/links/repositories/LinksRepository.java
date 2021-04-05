package com.links.links.repositories;

import com.links.links.dto.LinkDTO;
import com.links.links.exceptions.LinkNotFoundException;

import java.util.concurrent.atomic.AtomicInteger;

public interface LinksRepository {
    public int newLink(LinkDTO linkDTO);
    public LinkDTO findById(int id) throws LinkNotFoundException;
    public boolean removeById(int id);
}
