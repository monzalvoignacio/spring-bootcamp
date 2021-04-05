package com.links.links.services;

import com.links.links.dto.LinkDTO;
import com.links.links.dto.ResponseLinkDTO;
import com.links.links.exceptions.LinkNotFoundException;
import com.links.links.repositories.LinksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServicesImpl implements LinkServices{
    @Autowired
    private LinksRepository linksRepository;

    @Override
    public ResponseLinkDTO createLink(LinkDTO linkDTO) {
        return new ResponseLinkDTO(linksRepository.newLink(linkDTO));
    }

    @Override
    public LinkDTO findLink(int id) throws LinkNotFoundException {
        LinkDTO link = linksRepository.findById(id);
        if(link != null)
            link.incrementCount();
        return link;
    }

    @Override
    public LinkDTO getLinkInfo(int id) throws LinkNotFoundException {
        return linksRepository.findById(id);
    }

    @Override
    public boolean invalidateLink(int id) {
        return linksRepository.removeById(id);

    }
}
