package gnumall.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class StoreController {
	private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

	@RequestMapping(value = "/store", method = RequestMethod.GET)
	public String getProduct(HttpServletRequest Request, HttpServletResponse Response) {
		logger.info("Hello Store");
		//
		return "/content/store";
	}
}
