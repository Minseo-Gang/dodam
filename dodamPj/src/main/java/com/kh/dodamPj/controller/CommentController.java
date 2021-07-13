package com.kh.dodamPj.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.dodamPj.service.CommentService;

@Controller
@RequestMapping(value="/comment")
public class CommentController {

	@Inject
	private CommentService commentService;
}
