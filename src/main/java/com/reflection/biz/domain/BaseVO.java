package com.reflection.biz.domain;

import com.reflection.annotation.NameValue;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseVO {
	@NameValue(name = "생성일시")
	private LocalDateTime createDateTime;

	@NameValue(name = "생성 IP")
	private String creatorIp;

	@NameValue(name = "수정일시")
	private LocalDateTime updateDateTime;

	@NameValue(name = "수정 IP")
	private String updaterIp;
}
