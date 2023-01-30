package qodous.erp.inventory.services;

import java.util.List;

import qodous.erp.inventory.domain.Brand;

public interface IBrandService {
	
	public List<Brand> findAll();
	
	public Brand findBrandById(Integer brandId);
}
