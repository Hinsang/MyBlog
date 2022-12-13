package com.MyBlog.domain.entity.member;

import com.MyBlog.domain.dto.BoardDto;
import com.MyBlog.domain.dto.MemberDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int mno;
    String mid;
    String mpw;

    @OneToMany(mappedBy = "memberEntity")
    @Builder.Default
    @ToString.Exclude
    private List<BoardDto> boardEntityList = new ArrayList<>();

    public MemberDto toDto() {
        return MemberDto.builder()
                .mno(this.mno)
                .mid(this.mid)
                .mpw(this.mpw)
                .build();
    }

}
