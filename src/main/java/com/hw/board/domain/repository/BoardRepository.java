package com.hw.board.domain.repository;

import com.hw.board.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Post, Long> {
}
