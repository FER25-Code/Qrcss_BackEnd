package com.fdr.qrcss.DataToPdf;

import com.fdr.qrcss.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by FERGANI DIA EL EDDINE on 05/10/2020 at 15.
 * FdR for development
 * Dia.fergani@univ-constantine2.dz
 */
public interface ProductRepository  extends JpaRepository<Product, Integer> {

}
