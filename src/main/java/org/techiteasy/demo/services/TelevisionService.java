package org.techiteasy.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techiteasy.demo.dtos.TelevisionDto;
import org.techiteasy.demo.models.Television;
import org.techiteasy.demo.repositories.TelevisionRepository;

import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }


//    public List<Television> getAllTelevisions() {
//        TelevisionService ListOfTelevisions;
//        return ListOfTelevisions.getTelevisions();
//    }
//
//    public Television getTelevision(int id) {
//        Television televisionFound = ListOfTelevisions.getTelevision(id);
//        return televisionFound;
//    }

    public Long addTelevision(TelevisionDto televisionDto) {
        Television television = new Television();
        television.setName(televisionDto.name);
        television.setBrand(televisionDto.brand);
        television.setHdr(televisionDto.hdr);

        repos.save(television);

        return television.getId();
    }

//    public void removeTelevision(int id) {
//        Television televisionFound = ListOfTelevisions.getTelevision(id);
//        ListOfTelevisions.removeTelevision(id);
//    }
//
//    public void updateTelevision(int id, Television television) {
//        Television televisionFound = ListOfTelevisions.getTelevision(id);
//        ListOfTelevisions.updateTelevision(id, television);
//    }

}
