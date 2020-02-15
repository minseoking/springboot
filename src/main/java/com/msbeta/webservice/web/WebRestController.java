package com.msbeta.webservice.web;

import com.msbeta.webservice.domain.Posts;
import com.msbeta.webservice.domain.PostsRepository;
import com.msbeta.webservice.dto.posts.PostsSaveRequestDto;
import com.msbeta.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;

    @GetMapping("/hello")
    public String hello() {

        return "hello";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        //postsService.save(dto);
        return postsService.save(dto);
    }
}
