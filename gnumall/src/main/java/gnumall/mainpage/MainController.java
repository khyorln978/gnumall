package gnumall.mainpage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
	public String getMainPage(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Hello index page");
		logger.info("request : "+ request + "response : "+ response);


		return "/content/index";
	}

}
