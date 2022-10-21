package com.jy.reflection.biz.domain.board;

import com.jy.reflection.biz.domain.BaseVO;
import lombok.Data;

@Data
public class Post extends BaseVO {
	private Long id;
	private String title;
	private String content;
}