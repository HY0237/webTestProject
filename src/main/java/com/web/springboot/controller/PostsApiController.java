package com.web.springboot.controller;

import com.web.springboot.dto.PostsResponseDto;
import com.web.springboot.dto.PostsSaveRequestDto;
import com.web.springboot.dto.PostsUpdateRequestDto;
import com.web.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findbyId (@PathVariable Long id){
        return postsService.findById(id);
    }
}
