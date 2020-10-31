package gnumall.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@RequestMapping(value = "/login", method = {RequestMethod.GET})
	public String getLoginPage(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Hello index page");
		logger.info("request : "+ request + "response : "+ response);


		return "/content/login";
	}
}
