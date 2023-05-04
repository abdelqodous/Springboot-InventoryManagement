package qodous.erp.inventory.store.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import qodous.erp.inventory.store.domain.Brand;
import qodous.erp.inventory.store.services.impl.BrandServiceImpl;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/v1/api/inventory")
public class BrandController {
	private static final Logger logger = LoggerFactory.getLogger(BrandController.class);
	
	@Autowired
	BrandServiceImpl brandService;

	@GetMapping("/brands")
	public ResponseEntity<List<Brand>> allBrands(){
		return ResponseEntity.ok().body(brandService.findAll());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/failure")
	public Brand brandFailure(){
		throw new RuntimeException("$$.. An error has been occurred!! contact administrator @ **-***-***");
	}
	
	@GetMapping("brands/{brandId}")
	public ResponseEntity<Brand> findBrandById(@PathVariable Integer brandId){
		Brand brand =  brandService.findBrandById(brandId);
		return new ResponseEntity<Brand>(brand, HttpStatus.OK);
	}
	
	@PostMapping("brands")
	public ResponseEntity<Brand> createBrand(@RequestBody Brand theBrand){
		Brand createdBrand = brandService.createBrand(theBrand);
		System.out.println("Created Brand: " +createdBrand.getTitle());
		URI uri = ServletUriComponentsBuilder.fromHttpUrl("http://localhost:9090/api/inventory/v1/brands").
				path("/{id}").buildAndExpand(createdBrand.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("brands/{brandId}")
	public ResponseEntity<Brand> updateBrand(@RequestBody Brand theBrand){
		Brand updatedBrand = brandService.updateBrand(theBrand);
		System.out.println("Created Brand: " +updatedBrand.getContent());
		return new ResponseEntity<Brand>(updatedBrand, HttpStatus.OK);
	}
	
	@DeleteMapping("brands/{brandId}")
	public ResponseEntity<Void> deleteBrand(@PathVariable Integer brandId){
		Boolean brandDeleted =brandService.deleteBrand(brandId); 
		if(!brandDeleted) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build(); 
	}
}
