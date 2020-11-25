package com.sy.ticketsMgrSysEmpProv_8002;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

import com.yueqian.ticketsMgr_domain_9000.util.DateUtils;

@SpringBootApplication
@EnableDiscoveryClient
public class TicketsMgrSysEmpProv8002Application {

	public static void main(String[] args) {
		SpringApplication.run(TicketsMgrSysEmpProv8002Application.class, args);
	}
	
	/**
	 * 定义格式化器
	 */
	@Bean
	public Converter<String,Date> getDateFormatConverter(){
		return new Converter<String,Date>(){
			@Override
			public Date convert(String source) {
				return DateUtils.parseYMDStr2Date(source);
			}
			
		};
	}

}
