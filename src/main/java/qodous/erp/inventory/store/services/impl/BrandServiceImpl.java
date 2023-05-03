package qodous.erp.inventory.store.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qodous.erp.inventory.store.domain.Brand;
import qodous.erp.inventory.store.repositories.IBrandRepository;
import qodous.erp.inventory.store.services.IBrandService;

@Service

public class BrandServiceImpl implements IBrandService {
	private static final Logger logger = LoggerFactory.getLogger(BrandServiceImpl.class);
	
	@Autowired
	IBrandRepository iBrandRepository;

	@Override
	public List<Brand> findAll() {
//		logger.warn("$$.. BrandServiceImpl: findAll()...");
		return iBrandRepository.findAll();
	}

	public Brand findBrandById(Integer brandId) {
		return iBrandRepository.findById(brandId).orElse(null); //new Brand()
	}

	public Boolean deleteBrand(Integer brandId) {
		Brand theBrand = findBrandById(brandId);
		if(theBrand != null) {
			iBrandRepository.delete(theBrand);
			return true;
		}
		return false;
	}

	public Brand createBrand(Brand theBrand) {
		return iBrandRepository.save(theBrand);
	}

	public Brand updateBrand(Brand theBrand) {
		return iBrandRepository.save(theBrand);
	}
	
}
