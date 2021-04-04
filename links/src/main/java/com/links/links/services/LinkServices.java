package com.links.links.services;

import com.links.links.dto.LinkDTO;
import com.links.links.dto.ResponseLinkDTO;

public interface LinkServices {
    public ResponseLinkDTO createLink(LinkDTO linkDTO);
    public LinkDTO findLink(int id);
    public LinkDTO getLinkInfo(int id);
    public boolean invalidateLink(int id);
}
