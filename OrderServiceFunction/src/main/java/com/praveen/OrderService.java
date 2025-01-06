package com.praveen;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Handler for requests to Lambda function.
 */
public class OrderService {

    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent request) throws JsonMappingException, JsonProcessingException {
    	ObjectMapper mapper = new ObjectMapper();
    	Order order = mapper.readValue(request.getBody(), Order.class);
    	
    	return new APIGatewayProxyResponseEvent().withStatusCode(200).withBody("order id "+order.id);
       
    }
}
