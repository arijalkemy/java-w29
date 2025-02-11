package com.thiagoschreck.local.melisocial.repository;

import com.thiagoschreck.local.melisocial.entity.user.Client;
import com.thiagoschreck.local.melisocial.entity.user.Seller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsersRepositoryTests {
    public static final String ORDER_NAME_DESC = "name_desc";
    public static final String ORDER_NAME_ASC = "name_asc";
    private IUsersRepository repository;

    @BeforeEach
    void beforeEach() {
        repository = new UsersRepositoryImpl();
    }

    @Test
    @DisplayName("Given client id exists When I search client Then it is returned")
    void testSuccessfulFindClientById(){
        // ARRANGE
        int id = repository.save(new Client("Client")).getUserId();
        // ACT
        Optional<Client> client = repository.findClientById(id);
        // ASSERT
        assertTrue(client.isPresent());
        assertEquals(id, client.get().getUserId());
        assertEquals("Client", client.get().getUserName());
        assertEquals(List.of(), client.get().getFollowing());
    }

    @Test
    @DisplayName("Given client id doesnt exist When I search client Then empty Optional is returned")
    void testUnsuccessfulFindClientById(){
        // ARRANGE
        // ACT
        Optional<Client> client = repository.findClientById(0);
        // ASSERT
        assertTrue(client.isEmpty());
    }

    @Test
    @DisplayName("Given seller id exists When I search seller Then it is returned")
    void testSuccessfulFindSellerById(){
        // ARRANGE
        int id = repository.save(new Seller("Seller")).getUserId();
        // ACT
        Optional<Seller> seller = repository.findSellerById(id);
        // ASSERT
        assertTrue(seller.isPresent());
        assertEquals(id, seller.get().getUserId());
        assertEquals("Seller", seller.get().getUserName());
        assertEquals(List.of(), seller.get().getFollowers());
    }

    @Test
    @DisplayName("Given seller id doesnt exist When I search seller Then empty Optional is returned")
    void testUnsuccessfulFindSellerById(){
        // ARRANGE
        // ACT
        Optional<Seller> seller = repository.findSellerById(0);
        // ASSERT
        assertTrue(seller.isEmpty());
    }

    @Test
    void getSellerById() {
        //ARRANGE
        Seller seller = new Seller("Seller");
        int sellerId = repository.save(seller).getUserId();
        Optional<Seller> expected = Optional.of(seller);

        //ACT
        Optional<Seller> actual = repository.findSellerById(sellerId);

        //ASSERT
        assertEquals(expected, actual);
    }

    @Test
    void getSellerByIdWhenSellerNotFound() {
        //ARRANGE
        Optional<Seller> expected = Optional.empty();

        //ACT
        Optional<Seller> actual = repository.findSellerById(1);

        //ASSERT
        assertEquals(expected, actual);
    }

    @Test
    void getSellerByIdOrderAsc() {
        //ARRANGE
        Seller seller = new Seller("Seller");
        Client client1 = new Client("Client 1");
        Client client2 = new Client("Client 2");
        int sellerId = repository.save(seller).getUserId();
        repository.save(client1);
        repository.save(client2);
        seller.addFollower(client1);
        seller.addFollower(client2);

        Seller expectedSeller = new Seller(seller.getUserName());
        expectedSeller.addFollower(client1);
        expectedSeller.addFollower(client2);

        Optional<Seller> expected = Optional.of(expectedSeller);

        //ACT
        Optional<Seller> actual = repository.findSellerById(sellerId, ORDER_NAME_ASC);

        //ASSERT
        assertEquals(expected, actual);
        assertEquals(expected.get().getFollowers(), actual.get().getFollowers());
    }

    @Test
    void getSellerByIdOrderDesc() {
        //ARRANGE
        Seller seller = new Seller("Seller");
        Client client1 = new Client("Client 1");
        Client client2 = new Client("Client 2");
        int sellerId = repository.save(seller).getUserId();
        repository.save(client1);
        repository.save(client2);
        seller.addFollower(client1);
        seller.addFollower(client2);

        Seller expectedSeller = new Seller(seller.getUserName());
        expectedSeller.addFollower(client2);
        expectedSeller.addFollower(client1);

        Optional<Seller> expected = Optional.of(expectedSeller);

        //ACT
        Optional<Seller> actual = repository.findSellerById(sellerId, ORDER_NAME_DESC);

        //ASSERT
        assertEquals(expected, actual);
        assertEquals(expected.get().getFollowers(), actual.get().getFollowers());
    }

    @Test
    void getClientByIdOrderAsc() {
        //ARRANGE
        Client client = new Client("Client");
        Seller seller1 = new Seller("Seller 1");
        Seller seller2 = new Seller("Seller 2");
        int clientId = repository.save(client).getUserId();
        repository.save(seller1);
        repository.save(seller2);
        client.followSeller(seller1);
        client.followSeller(seller2);

        Client expectedClient = new Client(client.getUserName());
        expectedClient.followSeller(seller1);
        expectedClient.followSeller(seller2);

        Optional<Client> expected = Optional.of(expectedClient);

        //ACT
        Optional<Client> actual = repository.findClientById(clientId, ORDER_NAME_ASC);

        //ASSERT
        assertEquals(expected, actual);
        assertEquals(expected.get().getFollowing(), actual.get().getFollowing());
    }

    @Test
    void getClientByIdOrderDesc() {
        //ARRANGE
        Client client = new Client("Client");
        Seller seller1 = new Seller("Seller 1");
        Seller seller2 = new Seller("Seller 2");
        int clientId = repository.save(client).getUserId();
        repository.save(seller1);
        repository.save(seller2);
        client.followSeller(seller2);
        client.followSeller(seller1);

        Client expectedClient = new Client(client.getUserName());
        expectedClient.followSeller(seller2);
        expectedClient.followSeller(seller1);

        Optional<Client> expected = Optional.of(expectedClient);

        //ACT
        Optional<Client> actual = repository.findClientById(clientId, ORDER_NAME_DESC);

        //ASSERT
        assertEquals(expected, actual);
        assertEquals(expected.get().getFollowing(), actual.get().getFollowing());
    }
}
