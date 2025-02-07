package sprint1.be_java_hisp_w29_g9.controllersIntegration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import sprint1.be_java_hisp_w29_g9.repositories.IUserSellerRepo;
import sprint1.be_java_hisp_w29_g9.repositories.UserSellerRepoImp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UsersControllerTest {

  @Autowired
  private MockMvc mock_mvc;

	@Autowired
	private IUserSellerRepo user_seller_repo;

	@AfterEach
	void tearDown() {
		user_seller_repo.loadData();
	}

  @Test
  void testPostFollowUser() throws Exception {
    this.mock_mvc.perform(post(
      "/users/{userId}/follow/{userIdToFollow}",1, 2))
      .andDo(print())
      .andExpect(status().isOk());
  }

	@Test
	void testGetFollowedList() throws Exception {
		String url = "/users/{userId}/followed/list";
		mock_mvc.perform(get(
						url,1))
				.andDo(print())
				.andExpect(status().isOk());

		mock_mvc.perform(get(url, 10))
				.andExpect(status().isNotFound());

		mock_mvc.perform(get(url, 3))
				.andDo(print())
				.andExpect(status().isNotFound())
				.andExpect(jsonPath("$.message").value("El Usuario no sigue a ningun Vendedor."));

		mock_mvc.perform(get(url+"?order=adssada",1))
				.andDo(print())
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("El tipo de ordenamiento es incorrecto."));
	}

	@Test
	void testGetFollowersList() throws Exception {
		this.mock_mvc.perform(get("/users/{userId}/followers/list", 1))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.followers").isArray());
	}

	@Test
	void testGetFollowersCount() throws Exception {
		 this.mock_mvc
			.perform(get("/users/{userId}/followers/count",1))
			.andDo(print())
		 	.andExpect(status().isOk())
			.andExpect(jsonPath("$.followers_count").value(2));
	}

	@Test
	void testGetFollowersCountNotFound() throws Exception {
		this.mock_mvc
				.perform(get("/users/{userId}/followers/count",999))
				.andDo(print())
				.andExpect(status().isNotFound())
				.andExpect(jsonPath("$.message").value("El Vendedor no fue encontrado."));
	}

	@Test
	void testPostFollowUser2() {
		
	}

	@Test
	void testPostUnfollowUser() throws Exception {
		this.mock_mvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 1))
			.andDo(print())
			.andExpect(status().isOk());
	}
}
