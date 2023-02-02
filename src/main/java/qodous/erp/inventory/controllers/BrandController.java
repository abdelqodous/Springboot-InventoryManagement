package qodous.erp.inventory.controllers;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import qodous.erp.inventory.domain.Brand;
import qodous.erp.inventory.services.impl.BrandServiceImpl;

@CrossOrigin(origins = {
		"http://localhost:4200",
		"http://127.0.0.1:4200",
		"http://192.168.57.198:4200"
})
@RestController
@RequestMapping("/api/inventory/v1")
public class BrandController {
	private static final Logger logger = LoggerFactory.getLogger(BrandController.class);
	
	@Autowired
	BrandServiceImpl brandService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/brands")
	public List<Brand> allBrands(){
		return brandService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/failure")
	public Brand brandFailure(){
		throw new RuntimeException("$$.. An error has been occurred!! contact administrator @ **-***-***");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/brands/{brandId}")
	public Brand findBrandById(@PathVariable Integer brandId){
		return brandService.findBrandById(brandId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/brands")
	public ResponseEntity<Brand> createBrand(@RequestBody Brand theBrand){
		Brand createdBrand = brandService.createBrand(theBrand);
		URI uri = ServletUriComponentsBuilder.fromHttpUrl("http://localhost:9090/api/inventory/v1/brands").
				path("/{id}").buildAndExpand(createdBrand.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/brands/{brandId}")
	public ResponseEntity<Brand> updateBrand(@RequestBody Brand theBrand){
		Brand updatedBrand = brandService.updateBrand(theBrand);
		return new ResponseEntity<Brand>(updatedBrand, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/brands/{brandId}")
	public ResponseEntity<Void> deleteBrand(@PathVariable Integer brandId){
		Boolean brandDeleted =brandService.deleteBrand(brandId); 
		if(!brandDeleted) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build(); 
	}
}
