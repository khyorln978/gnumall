package gnumall.shop;

import gnumall.shop.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.Map;
import java.util.Set;


@Controller
public class StoreController {
	private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

	@Autowired
	private StoreService storeService;

	@RequestMapping(value = "/store", method = RequestMethod.GET)
	public String getProduct(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Hello Store");

		logger.info("session ID : " + request.getRequestedSessionId());

		logger.info(storeService.showProduct());

		Map<Integer, String> h = new Map<Integer, String>() {
			@Override
			public int size() {
				return 0;
			}

			@Override
			public boolean isEmpty() {
				return false;
			}

			@Override
			public boolean containsKey(Object key) {
				return false;
			}

			@Override
			public boolean containsValue(Object value) {
				return false;
			}

			@Override
			public String get(Object key) {
				return null;
			}

			@Override
			public String put(Integer key, String value) {
				return null;
			}

			@Override
			public String remove(Object key) {
				return null;
			}

			@Override
			public void putAll(Map<? extends Integer, ? extends String> m) {

			}

			@Override
			public void clear() {

			}

			@Override
			public Set<Integer> keySet() {
				return null;
			}

			@Override
			public Collection<String> values() {
				return null;
			}

			@Override
			public Set<Entry<Integer, String>> entrySet() {
				return null;
			}
		}



		model.addAttribute(h);


		return "/content/store";
	}
}
