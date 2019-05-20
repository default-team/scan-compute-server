package xyz.loverbaby;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("xyz.loverbaby.impl.dao.mapper")
public class ScanComputeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScanComputeApplication.class,args);
    }


}
