package com.MyBlog.domain.entity.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 황인상
 */
@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

    // where 조건도 반드시 select로 가져올 것!! ( 내 몇 시간 돌려내 ㅠㅠ )
    @Query( value = "select c.cno, c.cdate, c.udate, c.ccontent, c.bno, c.mno, m.mno, m.mid from comment c, member m " +
            "where c.bno = :bno and c.mno = m.mno order by c.cno desc", nativeQuery = true )
    List<CommentEntity> Test(int bno);

}
