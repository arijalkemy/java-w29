package com.mercadolibre.final_project_bootcamp_esp_32.integration;

import com.jayway.jsonpath.JsonPath;
import com.mercadolibre.final_project_bootcamp_esp_32.Application;
import com.mercadolibre.restclient.mock.RequestMockHolder;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"SCOPE_SUFFIX = integration_test"})
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
public class IntegrationTest {

  @Autowired
  MockMvc mockMvc;

  private final String INTERNAL_USER_TOKEN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWFuMkBwcnVlYmEuY29tIiwiaWF0IjoxNzQyMzA4ODE5LCJleHAiOjE3NDI5MTM2MTl9.SZHkq9AulZVDpyyMul1SqSAMKLqNWgHc8LaX1g8ltSE";
  private final String BUYER_TOKEN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWFuQHBydWViYS5jb20iLCJpYXQiOjE3NDIzMDg1NzEsImV4cCI6MTc0MjkxMzM3MX0.nE2p53hD5J0bOGsOM2g4MMMIkaOfBYvBZI4ys13-fQw";

  protected IntegrationTest() { }

  @AfterEach
  protected void afterEach() {
    RequestMockHolder.clear();
  }

  @Test
  @DisplayName("US-0005")
  @Order(4)
  void checkBatchStockDueDateTest() throws Exception {
    mockMvc.perform(get("/api/v1/fresh-products/batch/list/due-date/500")
                    .contentType(MediaType.APPLICATION_JSON).header("Authorization", INTERNAL_USER_TOKEN))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            // Check array size
            .andExpect(jsonPath("$.batch_stock", hasSize(3)))

            // Validate first batch in array
            .andExpect(jsonPath("$.batch_stock[0].batch_number").value(101))
            .andExpect(jsonPath("$.batch_stock[0].product_id").value(1))
            .andExpect(jsonPath("$.batch_stock[0].product_type_id").value(0))
            .andExpect(jsonPath("$.batch_stock[0].current_quantity").value(500))
            .andExpect(jsonPath("$.batch_stock[0].due_date").value("2025-04-15"))

            // Validate second batch in array
            .andExpect(jsonPath("$.batch_stock[1].batch_number").value(102))
            .andExpect(jsonPath("$.batch_stock[1].product_id").value(2))
            .andExpect(jsonPath("$.batch_stock[1].product_type_id").value(2))
            .andExpect(jsonPath("$.batch_stock[1].current_quantity").value(300))
            .andExpect(jsonPath("$.batch_stock[1].due_date").value("2026-07-10"));

  }

  @Test
  @DisplayName("US-0005: with arguments")
  @Order(2)
  void checkBatchStockDueDateWithArgumentsTest() throws Exception {
    mockMvc.perform(get("/api/v1/fresh-products/batch/list/due-date/500?category=FF&order=date_desc")
                    .contentType(MediaType.APPLICATION_JSON).header("Authorization", INTERNAL_USER_TOKEN))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            // Check array size
            .andExpect(jsonPath("$.batch_stock", hasSize(2)))

            // Validate first batch in array
            .andExpect(jsonPath("$.batch_stock[0].batch_number").value(106))
            .andExpect(jsonPath("$.batch_stock[0].product_id").value(2))
            .andExpect(jsonPath("$.batch_stock[0].product_type_id").value(2))
            .andExpect(jsonPath("$.batch_stock[0].current_quantity").value(300))
            .andExpect(jsonPath("$.batch_stock[0].due_date").value("2026-07-10"))

            // Validate second batch in array
            .andExpect(jsonPath("$.batch_stock[1].batch_number").value(102))
            .andExpect(jsonPath("$.batch_stock[1].product_id").value(2))
            .andExpect(jsonPath("$.batch_stock[1].product_type_id").value(2))
            .andExpect(jsonPath("$.batch_stock[1].current_quantity").value(300))
            .andExpect(jsonPath("$.batch_stock[1].due_date").value("2026-07-10"));
  }

  @Test
  @DisplayName("Validation Error")
  void shouldReturn400AndValidationErrorWhenOrderParameterIsInvalid() throws Exception {
    // When
    mockMvc.perform(get("/api/v1/fresh-products/batch/list/due-date/500")
                    .param("order", "date_desco").header("Authorization", INTERNAL_USER_TOKEN)
                    .contentType(MediaType.APPLICATION_JSON))
            // Then
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").exists())
            .andExpect(jsonPath("$.errors['getBatchesByDueDate.order']")
                    .value("El valor del order debe ser 'date_asc' o 'date_desc'."));
  }

  @Test
  @DisplayName("US-0002")
  @Order(3)
  void createPurchaseOrderTest() throws Exception {
    String requestBody = "{\n" +
            "  \"date\": \"14-03-2025\",\n" +
            "  \"buyer_id\": 1,\n" +
            "  \"status\": \"CART\",\n" +
            "  \"products\": [{\n" +
            "    \"product_id\": 2,\n" +
            "    \"quantity\": 25\n" +
            "  }]\n" +
            "}";
    mockMvc.perform(post("/api/v1/fresh-products/orders")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody).header("Authorization", BUYER_TOKEN))
            .andDo(print())
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.total_price").value(518.75));
  }

  @Test
  @DisplayName("US-0002")
  @Order(3)
  void createPurchaseOrderWithoutBuyerTest() throws Exception {
    String requestBody = "{\n" +
            "  \"date\": \"14-03-2025\",\n" +
            "  \"buyer_id\": 1,\n" +
            "  \"status\": \"CART\",\n" +
            "  \"products\": [{\n" +
            "    \"product_id\": 2,\n" +
            "    \"quantity\": 3000\n" +
            "  }]\n" +
            "}";
    mockMvc.perform(post("/api/v1/fresh-products/orders")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody).header("Authorization", BUYER_TOKEN))
            .andDo(print())
            .andExpect(status().isBadRequest());
  }

  @Test
  @DisplayName("US-0002 - Get All Products")
  void shouldReturnAllProducts() throws Exception {
    mockMvc.perform(get("/api/v1/fresh-products/list")
                    .contentType(MediaType.APPLICATION_JSON).header("Authorization", BUYER_TOKEN))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.products", hasSize(2)))
            .andExpect(jsonPath("$.products[0].product_id").value(1))
            .andExpect(jsonPath("$.products[0].quantity").value(500))
            .andExpect(jsonPath("$.products[1].product_id").value(2))
            .andExpect(jsonPath("$.products[1].quantity").value(1200));
  }

  @Test
  @DisplayName("US-0001 - Throw AlreadyExists")
  void saveInboundOrderBatchStockThrowAlreadyExists() throws Exception {
          String orderJson = "{\n" +
            "    \"order_number\": 10,\n" +
            "    \"order_date\": \"05-04-2025\",\n" +
            "    \"section\": {\n" +
            "        \"section_code\": 1,\n" +
            "        \"warehouse_code\": 1\n" +
            "    },\n" +
            "    \"batch_stock\": [\n" +
            "        {\n" +
            "            \"batch_number\": 101,\n" +
            "            \"product_id\": 50,\n" +
            "            \"current_temperature\": 25.0,\n" +
            "            \"minimum_temperature\": 25.0,\n" +
            "            \"initial_quantity\": 1,\n" +
            "            \"current_quantity\": 1,\n" +
            "            \"manufacturing_date\": \"05-04-2025\",\n" +
            "            \"manufacturing_time\": \"05-04-2025 14:30:45\",\n" +
            "            \"due_date\": \"05-04-2025\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"batch_number\": 102,\n" +
            "            \"product_id\": 2,\n" +
            "            \"current_temperature\": 5.0,\n" +
            "            \"minimum_temperature\": 1.0,\n" +
            "            \"initial_quantity\": 1,\n" +
            "            \"current_quantity\": 1,\n" +
            "            \"manufacturing_date\": \"05-04-2025\",\n" +
            "            \"manufacturing_time\": \"05-04-2025 14:30:45\",\n" +
            "            \"due_date\": \"05-04-2025\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

      mockMvc.perform(post("/api/v1/fresh-products/inboundorder")
                      .contentType(MediaType.APPLICATION_JSON)
                      .content(orderJson).header("Authorization", INTERNAL_USER_TOKEN)
              )
              .andDo(print())
              .andExpect(status().isConflict())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

  @Test
  @DisplayName("US-0001 - Throw Bad Request Exception")
  void saveInboundOrderBatchStockThrowBadRequestException() throws Exception {
    String orderJson = "{\n" +
            "    \"order_number\": 10,\n" +
            "    \"order_date\": \"05-04-2025\",\n" +
            "    \"section\": {\n" +
            "        \"section_code\": 1,\n" +
            "        \"warehouse_code\": 200\n" +
            "    },\n" +
            "    \"batch_stock\": [\n" +
            "        {\n" +
            "            \"batch_number\": 101,\n" +
            "            \"product_id\": 50,\n" +
            "            \"current_temperature\": 25.0,\n" +
            "            \"minimum_temperature\": 25.0,\n" +
            "            \"initial_quantity\": 1,\n" +
            "            \"current_quantity\": 1,\n" +
            "            \"manufacturing_date\": \"05-04-2025\",\n" +
            "            \"manufacturing_time\": \"05-04-2025 14:30:45\",\n" +
            "            \"due_date\": \"05-04-2025\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"batch_number\": 102,\n" +
            "            \"product_id\": 2,\n" +
            "            \"current_temperature\": 5.0,\n" +
            "            \"minimum_temperature\": 1.0,\n" +
            "            \"initial_quantity\": 1,\n" +
            "            \"current_quantity\": 1,\n" +
            "            \"manufacturing_date\": \"05-04-2025\",\n" +
            "            \"manufacturing_time\": \"05-04-2025 14:30:45\",\n" +
            "            \"due_date\": \"05-04-2025\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    mockMvc.perform(post("/api/v1/fresh-products/inboundorder")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(orderJson).header("Authorization", INTERNAL_USER_TOKEN)
            )
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

  @Test
  @DisplayName("US-0001 - Throw Not Found")
  void saveInboundOrderBatchStockThrowNotFound() throws Exception {
    String orderJson = "{\n" +
            "    \"order_number\": 10,\n" +
            "    \"order_date\": \"05-04-2025\",\n" +
            "    \"section\": {\n" +
            "        \"section_code\": 12321312,\n" +
            "        \"warehouse_code\": 1\n" +
            "    },\n" +
            "    \"batch_stock\": [\n" +
            "        {\n" +
            "            \"batch_number\": 10,\n" +
            "            \"product_id\": 50,\n" +
            "            \"current_temperature\": 25.0,\n" +
            "            \"minimum_temperature\": 25.0,\n" +
            "            \"initial_quantity\": 1,\n" +
            "            \"current_quantity\": 1,\n" +
            "            \"manufacturing_date\": \"05-04-2025\",\n" +
            "            \"manufacturing_time\": \"05-04-2025 14:30:45\",\n" +
            "            \"due_date\": \"05-04-2025\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"batch_number\": 12,\n" +
            "            \"product_id\": 2,\n" +
            "            \"current_temperature\": 5.0,\n" +
            "            \"minimum_temperature\": 1.0,\n" +
            "            \"initial_quantity\": 1,\n" +
            "            \"current_quantity\": 1,\n" +
            "            \"manufacturing_date\": \"05-04-2025\",\n" +
            "            \"manufacturing_time\": \"05-04-2025 14:30:45\",\n" +
            "            \"due_date\": \"05-04-2025\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    mockMvc.perform(post("/api/v1/fresh-products/inboundorder")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(orderJson).header("Authorization", INTERNAL_USER_TOKEN)
            )
            .andDo(print())
            .andExpect(status().isNotFound())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

  @Test
  @DisplayName("US-0001 - Save Inbound Order")
  @Order(1)
  void saveInboundOrderBatchStockTest() throws Exception {
    String orderJson = "{\n" +
            "    \"order_number\": 10,\n" +
            "    \"order_date\": \"05-04-2025\",\n" +
            "    \"section\": {\n" +
            "        \"section_code\": 1,\n" +
            "        \"warehouse_code\": 1\n" +
            "    },\n" +
            "    \"batch_stock\": [\n" +
            "        {\n" +
            "            \"batch_number\": 10,\n" +
            "            \"product_id\": 1,\n" +
            "            \"current_temperature\": 25.0,\n" +
            "            \"minimum_temperature\": 25.0,\n" +
            "            \"initial_quantity\": 1,\n" +
            "            \"current_quantity\": 1,\n" +
            "            \"manufacturing_date\": \"05-04-2025\",\n" +
            "            \"manufacturing_time\": \"05-04-2025 14:30:45\",\n" +
            "            \"due_date\": \"05-04-2025\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"batch_number\": 12,\n" +
            "            \"product_id\": 2,\n" +
            "            \"current_temperature\": 5.0,\n" +
            "            \"minimum_temperature\": 1.0,\n" +
            "            \"initial_quantity\": 1,\n" +
            "            \"current_quantity\": 1,\n" +
            "            \"manufacturing_date\": \"05-04-2025\",\n" +
            "            \"manufacturing_time\": \"05-04-2025 14:30:45\",\n" +
            "            \"due_date\": \"05-04-2025\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";
      mockMvc.perform(post("/api/v1/fresh-products/inboundorder")
                      .contentType(MediaType.APPLICATION_JSON)
                      .content(orderJson).header("Authorization", INTERNAL_USER_TOKEN)
              )
              .andDo(print())
              .andExpect(status().isCreated())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON))
              .andExpect(jsonPath("$.size()").value(2));
  }

  @Test
  @DisplayName("US-0001 - Modify Inbound Order")
  @Order(5)
  void modifyInboundOrderBatchStockTest() throws Exception {
    String orderJson = "{\n" +
            "    \"order_number\": 1,\n" +
            "    \"order_date\": \"05-04-2025\",\n" +
            "    \"section\": {\n" +
            "        \"section_code\": 1,\n" +
            "        \"warehouse_code\": 2\n" +
            "    },\n" +
            "    \"batch_stock\": [\n" +
            "        {\n" +
            "            \"batch_number\": 102,\n" +
            "            \"product_id\": 2,\n" +
            "            \"current_temperature\": 25.0,\n" +
            "            \"minimum_temperature\": 25.0,\n" +
            "            \"initial_quantity\": 1,\n" +
            "            \"current_quantity\": 1,\n" +
            "            \"manufacturing_date\": \"05-04-2025\",\n" +
            "            \"manufacturing_time\": \"05-04-2025 14:30:45\",\n" +
            "            \"due_date\": \"05-04-2025\"\n" +
            "        }]\n" +
            "}";

    mockMvc.perform(put("/api/v1/fresh-products/inboundorder")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(orderJson).header("Authorization", INTERNAL_USER_TOKEN)
            )
            .andDo(print())
            .andExpect(status().isCreated())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.size()").value(1));
  }

  @Test
  @DisplayName("US-0002 - get Products By Order")
  @Order(6)
  void getProductsByOrder() throws Exception {
    Integer idOrder = 1;

    mockMvc.perform(get("/api/v1/fresh-products/orders/{idOrder}",idOrder)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header("Authorization", BUYER_TOKEN))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.products.size()").value(1));
  }


  @Test
  @DisplayName("US-0002 - Actualizar Orden de Compra (PUT)")
  void updatePurchaseOrderTest() throws Exception {

    String postRequestBody = "{\n" +
            "  \"date\": \"14-03-2025\",\n" +
            "  \"buyer_id\": 1,\n" +
            "  \"status\": \"CART\",\n" +
            "  \"products\": [{\n" +
            "    \"product_id\": 2,\n" +
            "    \"quantity\": 25\n" +
            "  }]\n" +
            "}";

    MvcResult result = mockMvc.perform(post("/api/v1/fresh-products/orders")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(postRequestBody)
                    .header("Authorization", BUYER_TOKEN))
            .andExpect(status().isCreated())
            .andReturn();

    String responseJson = result.getResponse().getContentAsString();
    int orderId = JsonPath.parse(responseJson).read("$.order_id"); // Ajustar si es necesario

    String putRequestBody = "{\n" +
            "  \"date\": \"14-03-2025\",\n" +
            "  \"buyer_id\": 1,\n" +
            "  \"status\": \"CART\",\n" +
            "  \"products\": [\n" +
            "    {\n" +
            "      \"product_id\": 2,\n" +
            "      \"quantity\": 40\n" +
            "    }\n" +  // 👈 ¡Eliminé la coma!
            "  ]\n" +
            "}";


    mockMvc.perform(put("/api/v1/fresh-products/orders/" + orderId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(putRequestBody)
                    .header("Authorization", BUYER_TOKEN))
            .andDo(print())
            .andExpect(status().isOk());
  }

  @Test
  @DisplayName("US-0003 - Obtener batch stock por producto")
  void getFreshProductTest() throws Exception {
    mockMvc.perform(get("/api/v1/fresh-products/{productId}/batch/list", 1)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header("Authorization", INTERNAL_USER_TOKEN))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.product_id").value(1))
            .andExpect(jsonPath("$.section.section_code").value(1))
            .andExpect(jsonPath("$.section.warehouse_code").value(1))

            .andExpect(jsonPath("$.batch_stock", hasSize(1)))
            .andExpect(jsonPath("$.batch_stock[0].batch_number").value(101))
            .andExpect(jsonPath("$.batch_stock[0].current_quantity").value(500))
            .andExpect(jsonPath("$.batch_stock[0].due_date").value("15-04-2025"));
  }

  @Test
  @DisplayName("US-0003 Obtener batch stock por producto ordenado")
  void getFreshProductOrderBatchNumberTest() throws Exception {
    mockMvc.perform(get("/api/v1/fresh-products/{productId}/batch/list", 1)
                    .queryParam("order", "L")
                    .contentType(MediaType.APPLICATION_JSON)
                    .header("Authorization", INTERNAL_USER_TOKEN))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.product_id").value(1))
            .andExpect(jsonPath("$.section.section_code").value(1))
            .andExpect(jsonPath("$.section.warehouse_code").value(1))

            .andExpect(jsonPath("$.batch_stock", hasSize(1)))
            .andExpect(jsonPath("$.batch_stock[0].batch_number").value(101))
            .andExpect(jsonPath("$.batch_stock[0].current_quantity").value(500))
            .andExpect(jsonPath("$.batch_stock[0].due_date").value("15-04-2025"));
  }

  @Test
  @DisplayName("US-0003 Obtener batch stock por producto inexistente")
  void getFreshProductNotFoundTest() throws Exception {
    mockMvc.perform(get("/api/v1/fresh-products/{productId}/batch/list", 1123123)
                    .queryParam("order", "L")
                    .header("Authorization", INTERNAL_USER_TOKEN)
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }
}
