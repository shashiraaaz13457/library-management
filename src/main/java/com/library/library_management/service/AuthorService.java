package com.library.library_management.service;

import com.library.library_management.dto.AuthorRequestDto;
import com.library.library_management.dto.AuthorResponseDto;


import java.util.List;


public interface AuthorService {
    AuthorResponseDto createAuthor(AuthorRequestDto dto);
    AuthorResponseDto getAuthorById(Long id);

    List<AuthorResponseDto> getAllAuthors();

    AuthorResponseDto updateAuthor(Long id,AuthorRequestDto dto);

    void deleteAuthor(Long id);
}
