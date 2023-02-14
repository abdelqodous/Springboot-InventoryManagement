package qodous.erp.inventory.store.services;

import java.util.List;

import qodous.erp.inventory.store.domain.Brand;

public interface IBrandService {
	
	public List<Brand> findAll();
	
	public Brand findBrandById(Integer brandId);
}
