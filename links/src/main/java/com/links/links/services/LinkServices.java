package com.links.links.services;

import com.links.links.dto.LinkDTO;
import com.links.links.dto.ResponseLinkDTO;
import com.links.links.exceptions.LinkNotFoundException;

public interface LinkServices {
    public ResponseLinkDTO createLink(LinkDTO linkDTO);
    public LinkDTO findLink(int id) throws LinkNotFoundException;
    public LinkDTO getLinkInfo(int id) throws LinkNotFoundException;
    public boolean invalidateLink(int id);
}
