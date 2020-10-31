package gnumall.store.service;

import gnumall.common.util.CamelMap;
import gnumall.store.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

	private final StoreMapper storeMapper;

	public StoreService(StoreMapper storeMapper) {
		this.storeMapper = storeMapper;
	}

	public List<CamelMap> showProduct() throws Exception {
		return storeMapper.showProduct();
	}

}
