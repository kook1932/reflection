package com.reflection.biz.domain;

import com.reflection.biz.domain.board.Post;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {

	@Test
	public void getVoInfoTest() {
		//given
		Post post = new Post();
		post.setTitle("tititle");
		post.setContent("concontent");
		post.setCount(5);

		//when
		Map<String, String> resultMap = Observer.getVoInfo(post);

		//then
		System.out.println("resultMap = " + resultMap);
	}

	@Test
	public void testChild() throws Exception {
	    //given
		Post post = new Post();
		post.setTitle("tititle");
		post.setContent("concontent");
		post.setCount(5);

		Post child = new Post();
		child.setTitle("child tititle");
		child.setContent("child concontent");
		child.setCount(3);
		post.setChild(child);

		List<Post> children = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Post CPost = new Post();
			CPost.setTitle("list Child");
			CPost.setContent("2");
			children.add(CPost);
		}
		post.setChildren(children);

		//when
		Map<String, String> voInfo = Observer.getVoInfo(post);

		//then
		System.out.println("voInfo = " + voInfo);
	}

	@Test
	public void getUpdateInfoTest() {
	    //given
		Post before = new Post();
		before.setTitle("tititle");
		before.setContent("concontent");

		Post after = new Post();
		after.setTitle("tititle");
		after.setContent("content");

		//when
		String updateInfo = Observer.getUpdateInfo(before, after);

		//then
		System.out.println(updateInfo);
	}

}