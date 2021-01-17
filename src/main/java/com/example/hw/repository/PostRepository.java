package com.example.hw.repository;

import com.example.hw.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/* 앞서 정의한 Post Entity 를 위한 Repository를 생성한다.
* Repository 의 정의는 간단히 JpaRepository 인터페이스를 상속만 하면 끝이다.
*  이중에 Creteria 를 위한 인터페이스, QueryDSL 을 위한 인터페이스등을 추가로 상속받아
*  확장 시킬 수 있으며 이때 EntityManager 가 알아서 해당 기능의 구현체를 정의해준다.
*  다른 인터페이스에 대해선 나중에 더 살펴 보도록 한다.
* JpaRepository 는 기본적인 CRUD 를 처리할 수 있는 getOne, findById, findAll, save, delete 등의
* 함수가 정의 되어 있어 간단한 내용을 DB로 부터 처리 할 수 있게 해준다.*/

public interface  PostRepository extends JpaRepository<Post, Long> {
}
