package gnumall.shop.service;

import gnumall.shop.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StoreService {

	@Autowired
	private StoreMapper storeMapper;

	public String showProduct() throws Exception {
		return storeMapper.showProduct();
	}

}
