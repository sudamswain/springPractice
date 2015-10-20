package com.pvn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.UrlFilenameViewController;

@Controller
public class PageProviders extends UrlFilenameViewController
{
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Handling Request Url File Name view controller");
		System.out.println("view extracted from url by UrlFilenameViewController"+this.getViewNameForRequest(request));
		return new ModelAndView(this.getViewNameForRequest(request));
	}
}
