package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.entities.Product;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //Controller olduğunu tanıtmak için
@RequestMapping("home")// http://localhost:8080/home dizinin de çalışacak komutlar

//METHOD ==> GET, POST, PUT, DELETE
// GET = Cevap olarak bir kaynak dönüleceği durumlarda (ürünleri listeleme fonk)
// POST = Bir kaynak oluşturulması isteği (ürün ekleme fonk.)
// PUT = Bir kaynağın değiştirilmesi (ürün güncellemesi)
// DELETE = Bir kaynağın silinmesi isteği durumlarında


public class HomeController {
    List<Product>productList = new ArrayList<>();

    // http://localhost:8080/home/index
    @GetMapping("index")
    public String get(){
        return "Merhaba Turkcell";
    }


    @PostMapping("index")
    public String getPost(){
        return "Merhaba Turkcell Post";
    }

    // her bir entitiesin kendi contrelleri olması best practice



    //Url de bazı kısımları gizlemek istediğimiz durumlarda kullanırız

    @GetMapping("products")
    public List<Product> getProducts(){

      /*  Product product1 = new Product();
        product1.setId(1);
        product1.setName("Laptop");

        productList.add(product1); */
        return productList;
    }
    // Query String => localhost:8080/home/getById?id=1 ****
    // Route => localhost:8080/home/getById/1
    @GetMapping("getById")
    public Product getById(@RequestParam("id") int id){ //id alanı verilen değer olarak güncellenir.
        Product product = Product.builder().build(); //Build eklediğimiz için product a bu şekilde newledik.
        product.setProductId(id);
        product.setProductName("Laptop");
        return product;
    }
    @PostMapping("product")
    // Body = localhost:8080/product => gönderilen bilgiler url de gözükmeyecek.
    public ResponseEntity addProduct(@RequestBody Product product){ // @RequestBody kullanmamızın sebebi product kompleks bir alan. İçerisinde id, name gibi parametler bulunduruyor.
        //Valitadion
        if (product.getProductId() <= 0){
            return new ResponseEntity<>("Eklenecek Ürünün Id si Sıfırdan Büyük olmalıdır",HttpStatus.BAD_REQUEST);
        }
        //
        productList.add(product);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Product - Name", product.getProductName());
        return new ResponseEntity(product.getProductName()+"Ürünü Eklendi",httpHeaders,HttpStatus.CREATED);

       /*Postman de istek atarken ;

       {
            "id":1,
            "name":"Bisiklet"
        }*/
    }
}


