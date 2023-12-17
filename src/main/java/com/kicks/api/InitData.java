package com.kicks.api;

import com.kicks.api.domain.product.*;
import com.kicks.api.repository.product.BrandRepository;
import com.kicks.api.repository.product.CategoryRepository;
import com.kicks.api.repository.product.ShoeRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
public class InitData {

    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final ShoeRepository shoeRepository;
    private final EntityManager em;

    @PostConstruct
    public void init() {
        Brand brand = Brand.builder()
                .name("VANS(반스)")
                .info("폴 반 도런은 미국 동부에서 반스(VANS) 스니커즈를 만들며 자신이 만든 신발이 사람들에게 어떤 반응을 얻는지 직접 살피고 탐구했습니다. " +
                        "폴의 오랜 노력 덕분에 성공을 얻은 반스는 스포츠는 물론 라이프스타일까지 제품 라인을 확대하고, 특유의 반항적 이미지와 강렬한 개성을 더해 " +
                        "세계적인 브랜드로 성장했습니다.")
                .logoUrl("https://image.msscdn.net/mfile_s01/_brand/free_medium/vans.png?202312040947")
                .build();
        Category category = Category.builder()
                .name("스니커즈")
                .build();

        brandRepository.save(brand);
        categoryRepository.save(category);

        ShoeFamily family = ShoeFamily.builder()
                .brand(brand)
                .category(category)
                .nameKo("어센틱 VR3 SF - (체커보드)")
                .nameEn("UA Authentic VR3 SF - CHECKERBOARD")
                .info("반스에 새롭게 추가된 VR3는 지속 가능한 신발의 생산이라는 더 큰 목표를 향한 작은 한 걸음입니다. " +
                        "모든 부분을 재고려, 재설계, 재구축해 보다 지속 가능한 제품이 되도록 하였습니다.\n" +
                        "갑피에는 최소한 50% 이상의 재활용/오가닉 혹은 재사용 소재가 사용되었으며, " +
                        "풋베드는 25%의 친환경 소재의 EVA폼으로 만들어져 하루종일 편안한 착용감을 제공합니다.\n" +
                        "아웃솔은 자연고무로부터 생산되는 등 VR3는 지속가능성에 초점을 두었습니다.")
                .gender(Gender.ALL)
                .productList(new ArrayList<>())
                .build();
        ShoeProduct product = ShoeProduct.builder()
                .productId("VN0A4BX5BPS1")
                .family(family)
                .colorKo("블랙:마쉬멜로우")
                .colorEn("BLACK/MARSHMALLOW")
                .stockList(new ArrayList<>())
                .imageList(new ArrayList<>())
                .build();
        ShoeStock stock = ShoeStock.builder()
                .product(product)
                .size(225)
                .price(54900)
                .quantity(10)
                .build();
        ProductImage image1 = ProductImage.builder()
                .product(product)
                .url("https://image.msscdn.net/images/goods_img/20231016/3630145/3630145_16989987496741_500.jpg")
                .build();

        family.getProductList().add(product);
        product.getImageList().add(image1);
        product.getStockList().add(stock);

        shoeRepository.save(family);

//        imageSet.setMainImage("https://image.msscdn.net/images/goods_img/20231016/3630145/3630145_16989987496741_500.jpg");
//        imageSet.setDetailImage(1, "https://image.msscdn.net/images/goods_img/20231016/3630145/3630145_16989987496741_500.jpg");
//        imageSet.setDetailImage(2, "https://image.msscdn.net/images/prd_img/20231016/3630145/detail_3630145_16989987585918_500.jpg");
//        imageSet.setDetailImage(3, "https://image.msscdn.net/images/prd_img/20231016/3630145/detail_3630145_16989987539697_500.jpg");
//        imageSet.setDetailImage(4, "https://image.msscdn.net/images/prd_img/20231016/3630145/detail_3630145_16989987554496_500.jpg");

        log.info("[InitData] database initialized.");
    }
}