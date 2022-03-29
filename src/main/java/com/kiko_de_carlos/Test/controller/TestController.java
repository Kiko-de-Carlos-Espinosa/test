package com.kiko_de_carlos.Test.controller;

import java.util.ArrayList;

import com.kiko_de_carlos.Test.dto.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/product")
public class TestController {
    
    //private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/{productId}/similarids")
    @Operation(
        operationId = "get-product-similarids",
        summary = "Gets the ids of the similar products",
        description = "Returns the similar products to a given one ordered by similarity"
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
	public ArrayList<String> listSimilarids(@PathVariable("productId") String productId) {  
        return null;
    } 

    @GetMapping("/{productId}")
	@Operation(
        operationId = "get-product-productId",
        summary = "Gets a product detail",
        description = "Returns the product detail for a given productId"
    )
    @ApiResponses(value = { 
        @ApiResponse(
            responseCode = "200", 
            description = "Ok", 
            content = { 
                @Content(mediaType = "application/json", 
                schema = @Schema(
                    implementation = Product.class)) 
            }
        ),
        @ApiResponse(
            responseCode = "400", 
            description = "Product Not found"
        )
    })
    public Product getProduct(@PathVariable("productId") String productId) {  
        return null;
    }

}
