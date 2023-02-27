package com.how2java.tmall.service;

import com.how2java.tmall.mapper.ProductImageMapper;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductImageService   {

    public static final String type_single = "single";
    public static final String type_detail = "detail";

    @Autowired ProductImageMapper productImageMapper;
    @Autowired ProductService productService;

    public void add(ProductImage bean) {
        productImageMapper.save(bean);

    }
    public void delete(int id) {
        productImageMapper.delete(id);
    }

    public ProductImage get(int id) {
        return productImageMapper.get(id);
    }

    public List<ProductImage> listSingleProductImages(Product product) {
        return productImageMapper.findByProductAndTypeOrderByIdDesc(product, type_single);
    }
    public List<ProductImage> listDetailProductImages(Product product) {
        return productImageMapper.findByProductAndTypeOrderByIdDesc(product, type_detail);
    }

    public void setFirstProductImage(Product product) {
        List<ProductImage> singleImages = listSingleProductImages(product);
        if(!singleImages.isEmpty())
            product.setFirstProductImage(singleImages.get(0));
        else
            product.setFirstProductImage(new ProductImage()); //这样做是考虑到产品还没有来得及设置图片，但是在订单后台管理里查看订单项的对应产品图片。

    }

    public void setFirstProductImages(List<Product> products) {
        for (Product product : products)
            setFirstProductImage(product);
    }
    public int getBypid(Product product){
        int max=0;
        int p[]= productImageMapper.getBypid(product);
        for(int i=0;i<p.length;i++){
            if(p[i]>max){
                max=p[i];
            }

        }
        return max;
    }

}