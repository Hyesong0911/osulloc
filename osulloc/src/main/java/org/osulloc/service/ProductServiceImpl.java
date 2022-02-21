package org.osulloc.service;

import java.util.ArrayList;

import org.osulloc.domain.ProductDTO;
import org.osulloc.domain.ProductReviewDTO;
import org.osulloc.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductMapper pmapper;
	

		public ArrayList<ProductDTO> product(ProductDTO prod) {
			return pmapper.product(prod);
		}
		
		public ArrayList<ProductDTO> product2(ProductDTO prod) {
			return pmapper.product2(prod);
		}
		
		public ArrayList<ProductDTO> product3se(ProductDTO prod) {
			return pmapper.product3se(prod);
		}
		
		public void product3in(ProductDTO prod) {
			pmapper.product3in(prod);
		}
		
		//제품 상세페이지 select
		public ProductDTO productse(ProductDTO prod) {
			
			return pmapper.productse(prod);
			
		}
		
		
/*		public ArrayList<ProductDTO> productall(ProductDTO prod) {
			
			return pmapper.productall(prod);
			
		}*/
		
		
		
		public void addProduct(ProductDTO product) {
			System.out.println("service="+product);
			
			// MerchandiseDTO에 있는 prod변수를 가지고 와서 Product변수 타입의 prod에 저장
			//ProductDTO prod=product.getProd();
			
			pmapper.addProduct(product);

			
		}
		

		
}
