package com.MyBlog.domain.dto;

import com.MyBlog.domain.entity.member.MemberEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDto {

    int mno;
    String mid;
    String mpw;

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .mno(this.mno)
                .mid(this.mid)
                .mpw(this.mpw)
                .build();
    }

}
