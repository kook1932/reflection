package com.reflection.biz.repository.board;

import com.reflection.biz.domain.Observer;
import com.reflection.biz.domain.board.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
	public void findByIdTest() {
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
		Post post = new Post();
		post.setTitle("title");
		post.setContent("content");
		post.setCreateDateTime(LocalDateTime.now());
		post.setCreatorIp("127.0.0.1");

		//when
		int saveResult = postRepository.save(post);

		if (saveResult == 1) {
			//given
			Post savedPost = postRepository.findById(post.getId());
			System.out.println("before post = " + savedPost);
			savedPost.setContent("content content??");
			savedPost.setUpdateDateTime(LocalDateTime.now());
			savedPost.setUpdaterIp("127.0.0.1");

			//when
			int result = postRepository.update(savedPost);

			//then
			if (result == 1) {
				System.out.println("after post = " + savedPost);
			} else Assertions.fail("update fail");
		}

	}

}