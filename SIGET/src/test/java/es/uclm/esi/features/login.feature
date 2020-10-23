Feature: Login

	Background:
    Given baseUri is http://localhost:8080
    
  Scenario: Buen Login
    When Hago login con "admin" y "Admin123"
    Then el codigo de respuesta debe ser 200
    And el codigo de respuesta no debe ser 401
    

  Scenario: Mal Login
    When Hago login con "admin" y "Admin123"
    Then el codigo de respuesta debe ser 401
    And el codigo de respuesta no debe ser 200
