package com.fdr.qrcss.Controllers;
import com.fdr.qrcss.DataBase.ProductData;
import com.fdr.qrcss.DataToPdf.ProductPDFExporter;
import com.fdr.qrcss.DataToPdf.ProductServices;
import com.fdr.qrcss.Models.Product;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by FERGANI DIA EL EDDINE on 05/10/2020 at 14.
 * FdR for development
 * Dia.fergani@univ-constantine2.dz
 */

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductData productData ;

    @Autowired
    private ProductServices service;

    @PostMapping("/setproduct")
    public void SetProduct(@RequestBody Product product){
        try {
            productData.insert(product);
        }catch (Exception e){

            System.out.println("no insart");
        }

    }

    @GetMapping("/getproduct")
    public List<Product> getProduct(){
        return   productData.GetAllProduct();
    }

    @GetMapping("/deleteproduct/{id}")
    public int DeleteUser(@PathVariable int id ){

        return   productData.delete(id);
    }

    @PostMapping("/updateproduct")
    public void updateProduct(@RequestBody Product product ){
        try {
         productData.UpdataProduct(product);
        }catch (Exception e){
            System.out.println("no Update");
        }
    }



    @GetMapping("/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Order_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        List<Product> productList = service.listAll();
        ProductPDFExporter exporter = new ProductPDFExporter(productList);
        exporter.export(response);

    }

}
