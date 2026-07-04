package com.library.library_management.service.impl;

import com.library.library_management.dto.AuthorRequestDto;
import com.library.library_management.dto.AuthorResponseDto;
import com.library.library_management.entity.Author;
import com.library.library_management.exception.ResourceNotFoundException;
import com.library.library_management.repository.AuthorRepository;
import com.library.library_management.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl (AuthorRepository authorRepository) {
        this.authorRepository= authorRepository;
    }

    @Override
     public AuthorResponseDto createAuthor(AuthorRequestDto dto){
        Author author = new Author();
        author.setName(dto.getName());
        author.setEmail(dto.getEmail());
        Author savedAuthor = authorRepository.save(author); // We created new savedAuthor because if we fetch id from the original author it will be null after saving it to db it will generate the value.

//        AuthorResponseDto res = new AuthorResponseDto();
//        res.setId(savedAuthor.getId());
//        res.setName(savedAuthor.getName());
//        res.setEmail(savedAuthor.getEmail());
//        res.setBookTitles(new ArrayList<>());
        return mapToResponseDto(savedAuthor);
    }

    @Override
    public AuthorResponseDto getAuthorById(Long id) {
        Author author= authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not found with id : " + id));

//        AuthorResponseDto res = new AuthorResponseDto();
//        res.setId(author.getId());
//        res.setName(author.getName());
//        res.setEmail(author.getEmail());
//        res.setBookTitles(new ArrayList<>());

        return mapToResponseDto(author);
    }

    public List<AuthorResponseDto> getAllAuthors(){
        List<Author> authors = authorRepository.findAll();
            return authors.stream().map(this::mapToResponseDto).toList();
    }

    //Helper method for one shared Object.
    private AuthorResponseDto mapToResponseDto(Author author){
        AuthorResponseDto dto = new AuthorResponseDto();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setEmail(author.getEmail());
        dto.setBookTitles(new ArrayList<>());
        return dto;
    }
}
