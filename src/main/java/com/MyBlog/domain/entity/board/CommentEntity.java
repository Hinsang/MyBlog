package com.MyBlog.domain.entity.board;

import com.MyBlog.domain.dto.CommentDto;
import com.MyBlog.domain.entity.BaseEntity;
import com.MyBlog.domain.entity.member.MemberEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 황인상
 */

@Entity
@Table(name="comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CommentEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cno;
    String ccontent;
    String mid;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "bno")
    @ToString.Exclude
    public BoardEntity boardEntity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "mno")
    @ToString.Exclude
    public MemberEntity memberEntity;

    public CommentDto toDto() {
        return CommentDto.builder()
                .cno(this.cno)
                .mid(this.mid)
                .ccontent(this.ccontent)
                .cdate(
                        this.getCdate().toLocalDate().toString().equals(LocalDateTime.now().toLocalDate().toString()) ?
                        this.getCdate().toLocalTime().format(DateTimeFormatter.ofPattern("HH : mm : ss")) :
                        this.getCdate().toLocalDate().toString()
                )
                .build();
    }

}
