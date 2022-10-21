package com.jy.reflection.biz.repository.board;

import com.jy.reflection.biz.domain.board.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
@SpringBootTest
class PostRepositoryTest {

	@Autowired PostRepository postRepository;

	@Test
	public void saveTest() {
	    //given
		Post post = new Post();
		post.setTitle("title");
		post.setContent("content");
		post.setCreateDateTime(LocalDateTime.now());
		post.setCreatorIp("127.0.0.1");

		//when
		int result = postRepository.save(post);

		//then
		Assertions.assertThat(result).isEqualTo(1);
		System.out.println("post.getId() = " + post.getId());
	}

	@Test
	public void findAllTest() {
		List<Post> posts = postRepository.findAll();
		Assertions.assertThat(posts.size()).isGreaterThanOrEqualTo(0);
		System.out.println("posts.size() = " + posts.size());
	}

	@Test
	public void findByIdTest() throws Exception {
		//given
		Post post = new Post();
		post.setTitle("title");
		post.setContent("content");
		post.setCreateDateTime(LocalDateTime.now());
		post.setCreatorIp("127.0.0.1");

		//when
		int result = postRepository.save(post);

	    //then
		if (result == 1) {
			Long id = post.getId();
			Post findPost = postRepository.findById(id);
			Assertions.assertThat(findPost.getTitle()).isEqualTo(post.getTitle());
			System.out.println("findPost = " + findPost);
		}
	}

	@Test
	public void updateTest() {
	    //given
		Post post = postRepository.findById(7L);
		System.out.println("before post = " + post);
		post.setContent("content content??");
		post.setUpdateDateTime(LocalDateTime.now());
		post.setUpdaterIp("127.0.0.1");

		//when
		int result = postRepository.update(post);

		//then
		if (result == 1) {
			System.out.println("after post = " + post);
		} else Assertions.fail("update fail");
	}

}