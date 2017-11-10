sample-routing
==============

The web application provide a ReST api to get a list of Countries with them local currencies
and returned a JSON response. The Application has no client side.

# Server side stack
- Java 1.7.
- Maven for building, testing and running the application.
- Spring Security
- Spring MVC with hateoas
- Spring Integration 
- Hazelcast for caching

# IDE
- Eclipse Neon.2 Release (4.6.2)
	
# End Point:
- http://127.0.0.1:8080/sample-routing/countries

# Pagination:
- http://127.0.0.1:8080/sample-routing/countries?page=1
- http://127.0.0.1:8080/sample-routing/countries?page=2

# Authentication:
- user: SPRING
- password: spring

# Example Response:

{
  "countries": [
    {
      "name": "Argentina",
      "currencies": [
        {
          "code": "ARS",
          "name": "Argentine peso",
          "symbol": "$"
        }
      ]
    },
    {
      "name": "Armenia",
      "currencies": [
        {
          "code": "AMD",
          "name": "Armenian dram",
          "symbol": null
        }
      ]
    },
    {
      "name": "Aruba",
      "currencies": [
        {
          "code": "AWG",
          "name": "Aruban florin",
          "symbol": "\u0192"
        }
      ]
    },
    {
      "name": "Australia",
      "currencies": [
        {
          "code": "AUD",
          "name": "Australian dollar",
          "symbol": "$"
        }
      ]
    },
    {
      "name": "Austria",
      "currencies": [
        {
          "code": "EUR",
          "name": "Euro",
          "symbol": "\u20ac"
        }
      ]
    }
  ],
  "totalNum": 250,
  "currentPage": 2,
  "links": [
    {
      "rel": "self",
      "href": "http:\/\/127.0.0.1:8080\/sample-routing\/countries?page=2"
    },
    {
      "rel": "previous",
      "href": "http:\/\/127.0.0.1:8080\/sample-routing\/countries?page=1"
    },
    {
      "rel": "next",
      "href": "http:\/\/127.0.0.1:8080\/sample-routing\/countries?page=3"
    }
  ]
}  	

