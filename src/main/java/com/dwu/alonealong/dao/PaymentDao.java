package com.dwu.alonealong.dao;

import com.dwu.alonealong.domain.Payment;

public interface PaymentDao {
	Payment getCard(String Id);

	void createCard(Payment payment);

	void updateCard(Payment payment);
}
