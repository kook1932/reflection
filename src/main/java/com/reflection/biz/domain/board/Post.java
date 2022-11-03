package com.reflection.biz.domain.board;

import com.reflection.annotation.NameValue;
import com.reflection.biz.domain.BaseVO;
import com.reflection.biz.domain.Observer;
import lombok.Data;

import java.util.List;

@Data
public class Post extends BaseVO {
	private Long id;
	
	@NameValue(name = "타이틀")
	private String title;

	@NameValue(name = "내용")
	private String content;

	@NameValue(name = "개수")
	private int count;

	@NameValue(name = "자식")
	private Post child;

	@NameValue(name = "자식들")
	private List<Post> children;
}