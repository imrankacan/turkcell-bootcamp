package com.turkcell.spring.starter.repositories;

import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.dtos.CategoryForListingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// İlgili column un veriye erişimini sağlayacak interface
public interface CategoryRepositories extends JpaRepository<Category,Integer > { //Hangi model için veriye erişim sağlamak istiyoruz, id veri türü

    // Spring Derived Query Method
    /////
    //List<Category> findByCategoryName(String CategoryName); //JPA isteğe uygun işlemi gerçekleştirir. (name ile arama yapma)
    List<Category> findByCategoryIdLessThan(int id); // Kategori id si verilen id den küçük olanlar


    Category findByCategoryName(String categoryName);


    //Native SQL
    //JPQL = JPA'nın SQL'e neredeyse birebir versiyonu
    //JPQL = Tablo ismi yerine entity yazmak

    @Query(value = "select c from Category c where c.categoryName like %:name%" ,nativeQuery = false)
    List<Category>search(@Param("name") String categoryName); //Controllerde RequestParam


    @Query(value = "select * from Category  where categoryName like %:categoryName%" ,nativeQuery = true)
    List<Category>searchNative(String categoryName);

    @Query(value="SELECT new " +
            "com.turkcell.spring.starter.entities.dtos.CategoryForListingDto(c.categoryId, c.categoryName) From Category c")
    List<CategoryForListingDto> getForListing();
}



