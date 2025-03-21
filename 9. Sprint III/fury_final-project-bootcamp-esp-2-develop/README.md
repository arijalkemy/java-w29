# final-project-bootcamp-esp-2

# Service logic

## Requirement 1

### Batch service
- `BatchStockResponseDTO createInboundOrder(BatchRequestDto batchRequestDto)`: 
If the supervisor is authenticated and the warehouse, the section and the product exist, it stores the
received batch list into the supervisor's warehouse sector.
- `BatchStockResponseDTO updateInboundOrder(BatchRequestDto batchRequestDto)`:
If the supervisor is authenticated and the warehouse, the section and the product exist, it stores the
received batch list into the supervisor's warehouse sector.

## Requirement 2

### Product service
- `List<ProductDTO> getProductsByType(String category)`: If the category is null, it returns all 
existent products. If the category is a valid product category, it returns the category's products.
If the category is invalid, an IllegalArgumentException is thrown.

### Order service
- `PurchaseOrderRequestDTO updateOrderById(Long orderId, PurchaseOrderRequestDTO dto)`: If the order exists
it is modified with the values in the received purchase order dto. If the order or a product in the received
dto do not exist, a NotFoundException is thrown.
- `List<ProductDTO> searchProductsInOrder(Long idOrder)`: Returns all the products an order has. If the 
no order exists with the received id, an ApiException is thrown.
- `AddToCartResponseDTO saveOrder(PurchaseOrderRequestDTO purchaseOrderRequestDTO)`: Saves a new order. 
If the received order already exists, a BadRequestException is thrown. If the received order's buyer does
not exist, a NotFoundException is thrown.

## Requirement 3

### Product service
- `ProductBatchListResponse findProductBatchList(Long productId, BatchSortType sortType)`: Searches the 
section and batches of a given product in the warehouse supervised by the authenticated user.

### Warehouse service
- `ProductBatchListResponse getProductBatchesByProductIdSortedBy(Long supervisorId, Long productId, BatchSortType sortType)`:
  Searches the section and batches of a given product in the warehouse supervised by the authenticated 
user. Throws a ResourceNotFoundException if the corresponding supervisor, warehouse, section, batch 
or product do not exist.

## Requirement 4
### Product service
- `ProductWarehouseDTO searchProductStockInWarehouses(Long idProduct)`: Searches the received product's
stock in all warehouses.

## Requirement 5

### Batch service
- `BatchStockListDTO searchBatchStockByDueDate(Integer cantDays, String category, String dateOrder)`: 
Provides all batches that are about to expire between today and the specified number of days 
ahead. If specified, batches are ordered by due date, belonging to a specific product category.

## Requirement 6
- `ProductStockAndSectionDTO getProductStockAndEachSectionByWarehouse(Long warehouseId, Long productId)`:
It returns the product's stock and location in the sectors of a specific warehouse.
If no product stock is found, an ApiException exception is thrown.

# Full 6th requirement

It is [here](./docs/Req%206.pdf).

# Model

## DER

![DER](./docs/DER.png)

## UML

# Postman collection

It is [here](./docs/)

# Spring Boot App model for Java 17

We provide a basic model for JDK 17 / Spring based web applications.

Please address any questions and comments to [Fury Issue Tracker](https://github.com/mercadolibre/fury/issues).

## Usage

### SCOPE

The suffix of each Fury **SCOPE** is used to know which properties file to use, it is identified from the last '-' of the name of the scope.

If you want to run the application from your development IDE, you need to configure the environment variable **SCOPE=local** in the app luncher.

The properties of **application.yml** are always loaded and at the same time they are complemented with **application-<SCOPE_SUFFIX>.yml** properties. If a property is in both files, the one that is configured in **application-<SCOPE_SUFFIX>.yml** has preference over the property of **application.yml**.

For example, for the **SCOPE** 'items-loader-test' the **SCOPE_SUFFIX** would be 'test' and the loaded property files will be **application.yml** and **application-test.yml**

### Web Server

Each Spring Boot web application includes an embedded web server. For servlet stack applications, Its supports three web Servers:
  * Tomcat (maven dependency: `spring-boot-starter-tomcat`)
  * Jetty (maven dependency: `spring-boot-starter-jetty`)
  * Undertow (maven dependency: `spring-boot-starter-undertow`)

This project is configured with Jetty, but to exchange WebServer, it is enough to configure the dependencies mentioned above in the pom.xml file.

### Main

The main class for this app is Application, where Spring context is initialized and SCOPE_SUFFIX is generated.

### Error Handling

We also provide basic handling for exceptions in ControllerExceptionHandler class.

## API Documentation

This project uses OpenAPI to automate the generation of machine and human readable specifications for JSON APIs written using Spring. OpenAPI works by examining an application, once, at runtime to infer API semantics based on spring configurations, class structure and various compile time java Annotations.

You can change this configuration in SpringDocConfig class.

### Fury Specs Hub

To simplify the management and maintainability of your API specs, we present [Fury Specs Hub](https://furydocs.io/specs-hub/latest/guide/#/). Fury Specs Hub is a new service from Fury that aims to be a one-stop solution for API definition. With Specs Hub, you will be able to:
- Define your APIs using OpenAPI or AsyncAPI.
- Automate the configuration and generation of your API specs with the help of new commands from the Fury CLI.
- Have all your specs in one place for visualization and management.
- Share them with other teams.
- Find available APIs based on the information you need.
- Usage documentation [Fury Specs Hub - Getting started](https://furydocs.io/specs-hub/latest/guide/#/tutorial/).

#### Usage guide fast reference

1. [Installing the Specs Hub plugin for Fury CLI.](https://furydocs.io/specs-hub/latest/guide/#/tutorial/install-specs-hub-furycli)
2. [Installing the OpenAPI plugin and initializing a basic configuration.](https://furydocs.io/specs-hub/latest/guide/#/tutorial/install-open-api)
3. [Generating your first API specification.](https://furydocs.io/specs-hub/latest/guide/#/tutorial/generate-open-api-spec)
4. [Validating your API specification.](https://furydocs.io/specs-hub/latest/guide/#/tutorial/validate-specs)
5. [Uploading your first specification.](https://furydocs.io/specs-hub/latest/guide/#/tutorial/upload-spec)
6. [Viewing your specification in Fury web.](https://furydocs.io/specs-hub/latest/guide/#/tutorial/view-spec)
7. [Managing your specification in Fury web.](https://furydocs.io/specs-hub/latest/guide/#/tutorial/manage-spec)

## [Release Process](https://release-process.furycloud.io/#/)

### Usage

1. Specify the correct tag for your app in your `Dockerfile` and `Dockerfile.runtime`, according to the desired Java runtime version.

```
# Dockerfile
FROM hub.furycloud.io/mercadolibre/java:17-mini
```

You can find all available tags for your `Dockerfile` [here](https://github.com/mercadolibre/fury_java-mini#supported-tags)

```
# Dockerfile.runtime
FROM hub.furycloud.io/mercadolibre/java:17-runtime-mini
```

You can find all available tags for your `Dockerfile.runtime` [here](https://github.com/mercadolibre/fury_java-mini-runtime#supported-tags)

2. Start coding!

### Questions

[Release Process Issue Tracker](https://github.com/mercadolibre/fury_release-process/issues)
