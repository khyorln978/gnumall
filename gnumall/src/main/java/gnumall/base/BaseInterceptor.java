package gnumall.base;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**************************************************
 * @FileName   : BaseInterceptor.java
 * @Description: 알 수 없음
 * @Author     : Seungjun Kim
 * @Version    : 2020. 8. 14.
 * @Copyright  : ⓒADUP. All Right Reserved
 **************************************************/

public class BaseInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(BaseInterceptor.class);

	/**************************************************
	 * @MethodName : preHandle
	 * @Description: 권한 관리 목록 명세
	 * @param request
	 * @param response
	 * @param hadler
	 * @return boolean
	 * @throws Exception
	 * @Author     : Seungjun Kim
	 * @Version    : 2020. 8. 14.
	 **************************************************/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object hadler) throws Exception {
		String base = request.getContextPath();
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		int lastIdx = uri.lastIndexOf("/");
		String menu = lastIdx > 0 ? uri.substring(1, lastIdx) : "";
		String page = uri.substring(lastIdx + 1);
		String osName = System.getProperty("os.name");

		String langPram  = request.getParameter("lang");

		Cookie[] cookies = request.getCookies();
		String lang = "";
		if (StringUtils.isNotEmpty(langPram)){
			lang = langPram;
		} else {
			if (cookies != null) {
				for (Cookie cookie : cookies) {
//		    		logger.info("{} = {}", cookie.getName(), cookie.getValue());
					if ("selectLocale".equals(cookie.getName())) lang = cookie.getValue();
				}
				if ("".equals(lang)) lang = "ko";
			} else {
				lang = "ko";
			}
		}

		request.setAttribute("lang", lang);
		request.setAttribute("base", base); //struts는 기본 제공..
		request.setAttribute("menu", menu);
		request.setAttribute("page", page);
		if(osName.startsWith("Window")){
			request.setAttribute("OS", "Windows");
		}else{
			request.setAttribute("OS", "Linux");
		}

		logger.info("lang : {}", lang);
		logger.info("url : {}", url);
		logger.info("uri : {}", uri);
		logger.info("page : {}", page);
		logger.info("osName : {}", osName);
		logger.info("base is {}, menu is {}, page is {}"+
				base,
				menu,
				page);

		return true;
	}

}
