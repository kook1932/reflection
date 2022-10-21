package com.jy.reflection.biz.repository.board;

import com.jy.reflection.biz.domain.board.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PostRepository {
	int save(Post post);
	List<Post> findAll();
	Post findById(Long id);
	int update(Post post);
}
