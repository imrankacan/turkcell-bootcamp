package com.turkcell.spring.starter.entities;

//Tablo isimleri çoğul olsada class isimlerini tekil kullanıyoruz.
// Çoğulluk durumlarını liste durumlarında kullanıyoruz

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//@Data => Getter and Setter
@Table(name = "categories") //tablonun adı
@Entity //database entitysi olarak kullanılacağını belirtmek için

public class Category {
    @Id //primary key olduğu için
    @Column(name="category_id")
    private int categoryId;

    @Column(name="category_name")
    private String categoryName;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "category") // İlişki sağlanılan classta karşılığı olan isim yazılır mappedBy a.
    //One Category Has Many Products. İlk taraf her zaman içerisinde bulunduğumuz anatasyonu temsil eder.
    private List <Product> products;
}



//One to One
//One to Many
//Many to One
