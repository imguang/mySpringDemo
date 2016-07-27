package com.imguang.demo.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IConfirmCode {
	public void generate(HttpServletRequest request,
			HttpServletResponse response) throws IOException;

	public boolean confirm(String code, HttpServletRequest request);
}
