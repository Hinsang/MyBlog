package com.MyBlog.domain.entity.board;

import com.MyBlog.domain.dto.BoardDto;
import com.MyBlog.domain.entity.member.MemberEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "board")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bno;
    String bname;
    String bcontent;

    @ManyToOne
    @JoinColumn(name = "mno")
    @ToString.Exclude
    private MemberEntity memberEntity;

    public BoardDto toDto() {
        return BoardDto.builder()
                .bno(this.bno)
                .bname(this.bname)
                .bcontent(this.bcontent)
                .build();
    }

}
