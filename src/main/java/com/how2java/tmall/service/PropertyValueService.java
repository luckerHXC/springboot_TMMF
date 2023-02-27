package com.how2java.tmall.service;

import com.how2java.tmall.mapper.PropertyValueMappper;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.pojo.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyValueService  {

    @Autowired PropertyValueMappper propertyValueMappper;
    @Autowired PropertyService propertyService;

    public void update(PropertyValue bean) {
        propertyValueMappper.update(bean);
    }

    public void init(Product product) {
        List<Property> propertys= propertyService.listByCategory(product.getCategory());
        for (Property property: propertys) {
            PropertyValue propertyValue = getByPropertyAndProduct(product, property);
            if(null==propertyValue){
                propertyValue = new PropertyValue();
                propertyValue.setProduct(product);
                propertyValue.setProperty(property);
                propertyValueMappper.save(propertyValue);
            }
        }
    }

    public PropertyValue getByPropertyAndProduct(Product product, Property property) {
        return propertyValueMappper.getByPropertyAndProduct(product,property);
    }

    public List<PropertyValue> list(Product product) {
        return propertyValueMappper.findByProductOrderByIdDesc(product);
    }

}
