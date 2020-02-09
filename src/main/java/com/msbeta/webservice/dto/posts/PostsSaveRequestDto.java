package com.msbeta.webservice.dto.posts;

import com.msbeta.webservice.domain.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.text.rtf.RTFEditorKit;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private  String title;
    private  String content;
    private  String author;

    public Posts toEntity(){
        return  Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
