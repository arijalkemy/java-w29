package com.app.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.app.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private IUserRepository repository;

    @Test
    @DisplayName("T-0004 (US-0008) - Verificar orden ascendente de los followers por nombre")
    void shouldReturnFollowersListOrderedAsc() {
        List<User> actualFollowersAsc = repository.findFollowersUsersList(12001, "NAME_ASC");

        List<String> expectedNamesAsc = List.of("David Nalbandian", "Rafael Nadal");

        List<String> actualNamesAsc = actualFollowersAsc.stream().map(User::getName).toList();

        assertThat(actualNamesAsc).containsExactlyElementsOf(expectedNamesAsc);
    }

    @Test
    @DisplayName("T-0004 (US-0008) - Verificar orden descendente de los followers por nombre")
    void shouldReturnFollowersListOrderedDesc() {
        List<User> actualFollowersDesc = repository.findFollowersUsersList(12001, "NAME_DESC");

        List<String> expectedNamesDesc = List.of("Rafael Nadal", "David Nalbandian");

        List<String> actualNamesDesc = actualFollowersDesc.stream().map(User::getName).toList();

        assertThat(actualNamesDesc).containsExactlyElementsOf(expectedNamesDesc);
    }

    @Test
    @DisplayName("US-0008 - Verificar orden ascendente de los followed por nombre")
    void shouldReturnFollowedListOrderedAsc() {
        List<User> actualFollowedAsc = repository.findFollowingUsersList(8001, "NAME_ASC");

        List<String> expectedNamesAsc = List.of("Jorge Perez", "Paula Pérez");

        List<String> actualNamesAsc = actualFollowedAsc.stream().map(User::getName).toList();

        assertThat(actualNamesAsc).containsExactlyElementsOf(expectedNamesAsc);
    }

    @Test
    @DisplayName("US-0008 - Verificar orden descendente de los followed por nombre")
    void shouldReturnFollowedListOrderedDesc() {
        List<User> actualFollowedDesc = repository.findFollowingUsersList(8001, "NAME_DESC");

        List<String> expectedNamesDesc = List.of("Paula Pérez", "Jorge Perez");

        List<String> actualNamesDesc = actualFollowedDesc.stream().map(User::getName).toList();

        assertThat(actualNamesDesc).containsExactlyElementsOf(expectedNamesDesc);
    }




}
