package com.ecommerce.productservicemay25.controlleradvice;

import com.ecommerce.productservicemay25.dtos.ExceptionDto;
import com.ecommerce.productservicemay25.dtos.ProductNotFoundExceptionDto;
import com.ecommerce.productservicemay25.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeException() {

        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went wrong");
        exceptionDto.setResolutionDetails("You need to pay more money to get it resolved. Thanks!");

        return new ResponseEntity<>(
                exceptionDto,
                HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException() {
        ProductNotFoundExceptionDto exceptionDto = new ProductNotFoundExceptionDto();

        //TODO
        // exceptionDto.setProductId(exceptionDto.getProductId());

        exceptionDto.setMessage("Product not found");
        exceptionDto.setResolution("Please try again with valid Product ID");

        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
