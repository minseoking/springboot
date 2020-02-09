package com.msbeta.webservice.web;

import com.msbeta.webservice.domain.Posts;
import com.msbeta.webservice.domain.PostsRepository;
import com.msbeta.webservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello(){

        return "hello";
    }

    @PostMapping("/posts")
    public  void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }
}
