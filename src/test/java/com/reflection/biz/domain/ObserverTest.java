package com.reflection.biz.domain;

import com.reflection.biz.domain.board.Post;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {

	@Test
	public void getVoInfoTest() {
		//given
		Post post = new Post();
		post.setTitle("tititle");
		post.setContent("concontent");

		//when
		Map<String, String> resultMap = Observer.getVoInfo(post);

		//then
		System.out.println("resultMap = " + resultMap);
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