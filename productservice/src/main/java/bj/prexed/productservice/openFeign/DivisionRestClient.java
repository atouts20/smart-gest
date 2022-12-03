package bj.prexed.productservice.openFeign;

import bj.prexed.productservice.entities.Division;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PRODUCT-SERVICE", url = "localhost:9899")
public interface DivisionRestClient {
    @GetMapping(path = "/api/v1/division/{id}")
    Division getDivision(@PathVariable String id);

    @GetMapping(path = "/api/v1/division/all")
    List<Division> allDivision( );
}
