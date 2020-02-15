package com.msbeta.webservice.service;

import com.msbeta.webservice.domain.Posts;
import com.msbeta.webservice.domain.PostsRepository;
import com.msbeta.webservice.dto.posts.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public  void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void Save_dtoData_PostsTable(){
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("lms")
                .content("테스트")
                .title("테스트 타이틀")
                .build();

        //when
        postsService.save((dto));

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }

}