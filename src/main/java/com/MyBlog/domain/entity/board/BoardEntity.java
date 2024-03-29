package com.MyBlog.domain.entity.board;

import com.MyBlog.domain.dto.BoardDto;
import com.MyBlog.domain.entity.BaseEntity;
import com.MyBlog.domain.entity.member.MemberEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;
    private String btitle;
    private String bcontent;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "mno")
    @ToString.Exclude
    private MemberEntity memberEntity;

    @JsonManagedReference
    @OneToMany(mappedBy = "boardEntity")
    @Builder.Default
    @ToString.Exclude
    public List<CommentEntity> commentEntityList = new ArrayList<>();

    public BoardDto toDto() {
        return BoardDto.builder()
                .bno(this.bno)
                .btitle(this.btitle)
                .bcontent(this.bcontent)
                .mid(this.memberEntity.getMid())
                .bdate(
                        this.getCdate().toLocalDate().toString().equals(LocalDateTime.now().toLocalDate().toString()) ?
                        this.getCdate().toLocalTime().format(DateTimeFormatter.ofPattern("HH : mm : ss")) :
                        this.getCdate().toLocalDate().toString()
                )
                .build();
    }

}
