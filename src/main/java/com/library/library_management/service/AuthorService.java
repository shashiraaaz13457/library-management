package com.library.library_management.service;

import com.library.library_management.dto.AuthorRequestDto;
import com.library.library_management.dto.AuthorResponseDto;


public interface AuthorService {
    AuthorResponseDto createAuthor(AuthorRequestDto dto);
    AuthorResponseDto getAuthorById(Long id);
}
