package com.jy.reflection.biz.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseVO {
	private LocalDateTime createDateTime;
	private String creatorIp;

	private LocalDateTime updateDateTime;
	private String updaterIp;
}
