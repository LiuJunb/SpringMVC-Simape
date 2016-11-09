package com.xmg.touna.service.impl;

import org.springframework.stereotype.Service;

import com.xmg.touna.base.BaseDAO;
import com.xmg.touna.model.Product;
import com.xmg.touna.service.IProductService;

@Service("productService")
public class ProductService extends BaseDAO<Product> implements IProductService {
	
}
