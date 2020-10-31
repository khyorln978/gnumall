import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.DriverManager;

@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:/properties/database.properties")
@ContextConfiguration(locations = {"classpath:/root-context.xml"})
public class DBConnectionTest {

	@Value("${driver}")
	private String DRIVER;
	@Value("${url}")
	private String URL;
	@Value("${user}")
	private String USER;
	@Value("${password}")
	private String PW;

	@Test
	public void testConnection() throws Exception {

		System.out.println(DRIVER + URL + USER + PW);
		Class.forName(DRIVER);
		try (Connection conn = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println("***************** SUCCESS ************** "+conn);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}