package com.imguang.demo.service.impl;

import java.awt.Color;
import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.github.bingoohuang.patchca.color.ColorFactory;
import com.github.bingoohuang.patchca.custom.ConfigurableCaptchaService;
import com.github.bingoohuang.patchca.filter.predefined.CurvesRippleFilterFactory;
import com.github.bingoohuang.patchca.filter.predefined.DiffuseRippleFilterFactory;
import com.github.bingoohuang.patchca.filter.predefined.DoubleRippleFilterFactory;
import com.github.bingoohuang.patchca.filter.predefined.MarbleRippleFilterFactory;
import com.github.bingoohuang.patchca.filter.predefined.WobbleRippleFilterFactory;
import com.github.bingoohuang.patchca.font.RandomFontFactory;
import com.github.bingoohuang.patchca.utils.encoder.EncoderHelper;
import com.github.bingoohuang.patchca.word.RandomWordFactory;
import com.imguang.demo.service.IConfirmCodeService;

/*
 * 验证码service
 */
@Service
public class ConfirmCodeServiceImpl implements IConfirmCodeService {

	private static ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
	private static Random random = new Random();

	static {
		// cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
		cs.setColorFactory(new ColorFactory() {
			public Color getColor(int x) {
				int[] c = new int[3];
				int i = random.nextInt(c.length);
				for (int fi = 0; fi < c.length; fi++) {
					if (fi == i) {
						c[fi] = random.nextInt(71);
					} else {
						c[fi] = random.nextInt(256);
					}
				}
				return new Color(c[0], c[1], c[2]);
			}
		});

		cs.setHeight(35);
		cs.setWidth(80);
		RandomWordFactory wf = new RandomWordFactory();
		wf.setCharacters("123456789abcdefghigkmnpqrstuvwxyzABCDEFGHIGKLMNPQRSTUVWXYZ");
		wf.setMaxLength(4);
		wf.setMinLength(4);
		RandomFontFactory rf = new RandomFontFactory();
		rf.setMaxSize(25);
		rf.setMinSize(25);
		cs.setWordFactory(wf);
		cs.setFontFactory(rf);
	}

	/*
	 * 生成验证码
	 */
	@Override
	public void generate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		switch (random.nextInt(5)) {
		case 0:
			cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
			break;
		case 1:
			cs.setFilterFactory(new MarbleRippleFilterFactory());
			break;
		case 2:
			cs.setFilterFactory(new DoubleRippleFilterFactory());
			break;
		case 3:
			cs.setFilterFactory(new WobbleRippleFilterFactory());
			break;
		case 4:
			cs.setFilterFactory(new DiffuseRippleFilterFactory());
			break;
		}
		HttpSession session = request.getSession(false);
		if (session == null) {
			session = request.getSession();
		}
		setResponseHeaders(response);
		String token = EncoderHelper.getChallangeAndWriteImage(cs, "png", response.getOutputStream());
		token = token.toLowerCase();
		session.setAttribute("captchaToken", token);
		System.out.println("当前sessionid=" + session.getId() + "，验证码=" + token);
	}

	/*
	 * 验证码是否正确
	 */
	public boolean confirm(String code, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		code = code.toLowerCase();
		if (session == null || !code.equals(session.getAttribute("captchaToken"))) {
			return false;
		}
		return true;
	}

	protected void setResponseHeaders(HttpServletResponse response) {
		response.setContentType("image/png");
		response.setHeader("Cache-Control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		long time = System.currentTimeMillis();
		response.setDateHeader("Last-Modified", time);
		response.setDateHeader("Date", time);
		response.setDateHeader("Expires", time);
	}

}
