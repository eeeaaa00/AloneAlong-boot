package com.dwu.alonealong.dao.mybatis.mapper;

import com.dwu.alonealong.domain.Payment;

public interface PaymentMapper {
	Payment getCard(String Id);

	void createCard(Payment payment);

	void updateCard(Payment payment);
}
