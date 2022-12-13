package com.MyBlog.domain.dto;

import com.MyBlog.domain.entity.board.BoardEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardDto {

    int bno;
    String bname;
    String bcontent;

    private BoardEntity toEntity() {
        return BoardEntity.builder()
                .bno(this.bno)
                .bname(this.bname)
                .bcontent(this.bcontent)
                .build();
    }

}
