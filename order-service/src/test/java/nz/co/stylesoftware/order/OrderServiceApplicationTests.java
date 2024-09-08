package nz.co.stylesoftware.order;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;
import static org.hamcrest.MatcherAssert.assertThat;
import io.restassured.RestAssured;
import nz.co.stylesoftware.order.stubs.InventoryClientStub;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
class OrderServiceApplicationTests {

	@ServiceConnection
	static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");
	
	@LocalServerPort
	private Integer port;
	
	static {
		mySQLContainer.start();
	}
	
	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}
	
	@Test
	void shouldPlaceOrder() {
    
		String orderBody = """
				{
				    "skuCode": "iphone_15",
				    "price": 1000,
				    "quantity": 1
				}
				""";
		InventoryClientStub.stubInventoryCall("iphone_15", 1);
		
		var responseBodyString = RestAssured.given()
				.contentType("application/json")
				.body(orderBody)
				.when()
				.post("/api/order")
				.then()
				.statusCode(201)
				.extract()
				.body().asString();
		
		assertThat(responseBodyString, Matchers.is("Order placed successfully"));
	}

}
