package gnumall.store.mapper;

import gnumall.common.util.CamelMap;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface StoreMapper {
	List<CamelMap> showProduct() throws SQLException;


}
