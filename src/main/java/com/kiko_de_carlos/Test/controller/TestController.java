package com.kiko_de_carlos.Test.controller;

import java.util.ArrayList;
import java.util.List;

import com.kiko_de_carlos.Test.dto.Product;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/product")
public class TestController {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping(value = "/{productId}/similar", produces = { "application/json", "application/xml" })
    @Operation(
        operationId = "get-product-similar",
        summary = "Similar products",
    )
    @ApiResponses(value = { 
        @ApiResponse(
            responseCode = "200", 
            description = "Ok", 
            content = { 
                @Content(mediaType = "application/json", 
                schema = @Schema(

                    implementation = String.class)) 
            }
        )
    })
	public ResponseEntity<JSONObject> listSimilarids(@PathVariable("productId") String productId) {  
        
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity <JSONObject> request = new HttpEntity<>(headers)

            ResponseEntity respon = restTemplate.exchange(
                "UrlMockup:3001//product/{productId}/similarids",
                HttpMethod.GET,
                request,
                JSONObject.class
            );
            return respon;
        } catch (Exception e) {
            logger.error("error");
            return responseErrorEntity(HttpStatus.INTERNAL_SERVER_ERROR, "error");
        }
    } 

    private ResponseEntity<JSONObject> responseErrorEntity(final HttpStatus code, final String message) {
        JSONObject error = new JSONObject();
        error.put("errorMessage",message);
        return new ResponseEntity<>(error,code);
    }

}
