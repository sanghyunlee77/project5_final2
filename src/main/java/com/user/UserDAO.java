package com.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

    private final SqlSessionTemplate sqlSession;

    // 생성자에 @Autowired 주석을 추가하여 의존성 주입을 나타냅니다.
    @Autowired
    public UserDAO(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    // UserVO 객체를 받아 해당 사용자 정보를 조회하는 메서드
    public UserVO getUser(UserVO vo){
        return sqlSession.selectOne("User.getUser", vo);
    }
}
