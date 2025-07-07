package com.sara.ecommerce.clients;

import com.sara.ecommerce.dto.FakeStoreProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreApiClient {

    @Autowired
    private RestTemplate restTemplate;

    public List<FakeStoreProductDto> getAllFakeStoreProducts() {
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity("https://fakestoreapi.com/products/",
                        FakeStoreProductDto[].class);
        if (validateResponses(responseEntity)) {
            return Arrays.asList(responseEntity.getBody());
        }
        return null;
    }

    public FakeStoreProductDto getFakeStoreProductById(Long id) {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity =
                restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
                        FakeStoreProductDto.class, id);

        if (validateResponse(fakeStoreProductDtoResponseEntity)) {
            return fakeStoreProductDtoResponseEntity.getBody();
        }
        return null;
    }

    public FakeStoreProductDto createProduct(FakeStoreProductDto fakeStoreProductDto) {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity =
                restTemplate.postForEntity("https://fakestoreapi.com/products",
                        fakeStoreProductDto, FakeStoreProductDto.class);

        if (validateResponse(fakeStoreProductDtoResponseEntity)) {
            return fakeStoreProductDto;
        }
        return null;
    }

    public FakeStoreProductDto replaceFakeStoreProduct(FakeStoreProductDto fakeStoreProductDtoInput, Long id) {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity =
                requestForEntity(HttpMethod.PUT, "https://fakestoreapi.com/products/{id}", fakeStoreProductDtoInput,
                        FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDtoOutput = fakeStoreProductDtoResponseEntity.getBody();

        if (validateResponse(fakeStoreProductDtoResponseEntity)) {
            return fakeStoreProductDtoOutput;
        }

        return null;
    }

    public FakeStoreProductDto deleteFakeStoreProduct(Long id) {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity =
                requestForEntity(HttpMethod.DELETE, "https://fakestoreapi.com/products/{id}", null,
                        FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDtoOutput = fakeStoreProductDtoResponseEntity.getBody();

        if (validateResponse(fakeStoreProductDtoResponseEntity)) {
            return fakeStoreProductDtoOutput;
        }

        return null;
    }

    private Boolean validateResponses(ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDtoResponseEntity) {
        if (fakeStoreProductDtoResponseEntity.getBody() != null &&
                fakeStoreProductDtoResponseEntity.getStatusCode() ==
                        HttpStatus.valueOf(200)) {
            return true;
        }
        return false;
    }

    private Boolean validateResponse(ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity) {
        if (fakeStoreProductDtoResponseEntity.getBody() != null &&
                fakeStoreProductDtoResponseEntity.getStatusCode() ==
                        HttpStatus.valueOf(200)) {
            return true;
        }
        return false;
    }

    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
}
