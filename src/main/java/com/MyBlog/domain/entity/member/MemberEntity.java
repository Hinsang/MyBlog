package com.MyBlog.domain.entity.member;

import com.MyBlog.domain.dto.BoardDto;
import com.MyBlog.domain.dto.MemberDto;
import com.MyBlog.domain.entity.BaseEntity;
import com.MyBlog.domain.entity.board.BoardEntity;
import com.MyBlog.domain.entity.board.CommentEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class MemberEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int mno;
    String mid;
    String mpw;

    @JsonManagedReference
    @OneToMany(mappedBy = "memberEntity")
    @Builder.Default
    @ToString.Exclude
    private List<BoardEntity> boardEntityList = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "memberEntity")
    @Builder.Default
    @ToString.Exclude
    private List<CommentEntity> commentEntityList = new ArrayList<>();

    public MemberDto toDto() {
        return MemberDto.builder()
                .mno(this.mno)
                .mid(this.mid)
                .mpw(this.mpw)
                .build();
    }

}
