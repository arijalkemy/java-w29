package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.EntradaBlogDTO;
import com.bootcamp.blog.entity.EntradaBlog;
import com.bootcamp.blog.exception.EntryAlreadyExistsException;
import com.bootcamp.blog.exception.EntryNotFoundException;
import com.bootcamp.blog.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryService {
    @Autowired
    EntryRepository entryRepository;
    public Integer createEntry(Integer id, EntradaBlogDTO entryDTO){
        Optional<EntradaBlog> existingEntry = entryRepository.findByID(id);
        if (existingEntry.isPresent()){
            throw new EntryAlreadyExistsException("There is already an entry with the same id");
        }
        EntradaBlog savedEntry = entryRepository.save(transformDtoToEntity(id, entryDTO));
        return savedEntry.getId();
    }
    public List<EntradaBlog> getAllEntries(){
        return entryRepository.findAll();
    }
    public EntradaBlogDTO getEntryById(Integer id){
        Optional<EntradaBlog> entry = entryRepository.findByID(id);
        if (entry.isEmpty()){
            throw new EntryNotFoundException(String.format("Entry with id %s was not found", id));
        }
        return transformEntityToDto(entry.get());
    }
    private EntradaBlog transformDtoToEntity(Integer id, EntradaBlogDTO entryDTO){
        return new EntradaBlog(id, entryDTO.getTitulo(),entryDTO.getAutor(),entryDTO.getFecha());
    }
    private EntradaBlogDTO transformEntityToDto(EntradaBlog entry){
        return new EntradaBlogDTO(entry.getTitulo(),entry.getAutor(), entry.getFechaPublicacion());
    }
}
