package com.fdr.qrcss.DataToPdf;

import com.fdr.qrcss.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by FERGANI DIA EL EDDINE on 05/10/2020 at 15.
 * FdR for development
 * Dia.fergani@univ-constantine2.dz
 */
@Service
@Transactional
public class ProductServices {
    @Autowired
    private ProductRepository repository ;
    public List<Product> listAll() {
        return repository.findAll(Sort.by("num").ascending());
    }
}
