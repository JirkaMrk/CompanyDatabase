package cz.uun.companydatabase;

import cz.uun.companydatabase.dtoin.CompanyCreateDtoIn;
import cz.uun.companydatabase.entity.Company;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CompanyDatabaseApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	//TODO order

	@Test
	@Order(1)
	public void testCreateCompany() {
		CompanyCreateDtoIn dtoIn = new CompanyCreateDtoIn();
		dtoIn.setAddress("ulr");
		dtoIn.setIco("9999");
		dtoIn.setName("dd");

		Company body = this.restTemplate.postForObject("/company", dtoIn, Company.class);
		assertThat(body.getId()).isNotZero();
		assertThat(body.getAddress()).isEqualTo("ulr");
		assertThat(body.getIco()).isEqualTo("9999");
		assertThat(body.getName()).isEqualTo("dd");
	}

	@Test
	@Order(2)
	public void testGetCompanyById() {
		Company body = this.restTemplate.getForObject("/company/9999", Company.class);
		assertThat(body.getIco()).isEqualTo("9999");
	}

	@Test
	@Order(3)
	public void testUpdateCompanyByID() {
		CompanyCreateDtoIn dtoIn = new CompanyCreateDtoIn();
		dtoIn.setName("xx");

		this.restTemplate.put("/company/9999", dtoIn);

		Company updatedCompany = this.restTemplate.getForObject("/company/9999", Company.class);
		assertThat(updatedCompany.getName()).isEqualTo("xx");
	}

	@Test
	@Order(4)
	public void testDeleteCompanyById() {
		this.restTemplate.delete("/company/9999");
	//TODO	assertThat(get()).isEqualTo(HttpStatus.NOT_FOUND);
	}

}
