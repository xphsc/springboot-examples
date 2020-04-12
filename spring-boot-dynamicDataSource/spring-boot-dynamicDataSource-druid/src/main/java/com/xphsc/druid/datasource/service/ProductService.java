package com.xphsc.druid.datasource.service;



import com.xphsc.druid.datasource.mapper.ProductMapper;
import com.xphsc.druid.datasource.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@link }
 * @author <a href="xiongpeih@163.com">huipei.x</a>
 * @description:
 * @date:
 * @since 0.1.0
 */
@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public Product select(long productId) throws Exception {
        Product product = productMapper.select(productId);
        if (product == null) {
            throw new Exception("Product:" + productId + " not found");
        }
        return product;
    }

    /**
     * Update product by id
     * If update failed will throw Exception
     *
     * @param productId
     * @param newProduct
     * @return
     * @throws Exception
     */
    public Product update(long productId, Product newProduct) throws Exception {

        if (productMapper.update(newProduct) <= 0) {
            throw new Exception("Update product:" + productId + "failed");
        }
        return newProduct;
    }

    /**
     * Add product to DB
     *
     * @param newProduct
     * @return
     * @throws Exception
     */
    public boolean add(Product newProduct) throws Exception {
        Integer num = productMapper.insert(newProduct);
        if (num <= 0) {
            throw new Exception("Add product failed");
        }
        return true;
    }

    /**
     * Delete product from DB
     *
     * @param productId
     * @return
     * @throws Exception
     */
    public boolean delete(long productId) throws Exception {
        Integer num = productMapper.delete(productId);
        if (num <= 0) {
            throw new Exception("Delete product:" + productId + "failed");
        }
        return true;
    }

    /**
     * Query all product
     *
     * @return
     */
    public List<Product> selectAll() {
        return productMapper.selectAll();
    }
}
