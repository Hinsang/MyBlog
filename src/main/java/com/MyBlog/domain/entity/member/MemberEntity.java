package com.MyBlog.domain.entity.member;

import com.MyBlog.domain.dto.MemberDto;
import lombok.*;

import javax.persistence.*;

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

    public MemberDto toDto() {
        return MemberDto.builder()
                .mno(this.mno)
                .mid(this.mid)
                .mpw(this.mpw)
                .build();
    }

}
