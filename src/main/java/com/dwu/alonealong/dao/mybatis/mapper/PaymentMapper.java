package com.dwu.alonealong.dao.mybatis.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.dwu.alonealong.domain.Payment;

@Mapper
public interface PaymentMapper {
	Payment getCard(String userId);

	void createCard(Payment payment);

	void updateCard(Payment payment);
}
