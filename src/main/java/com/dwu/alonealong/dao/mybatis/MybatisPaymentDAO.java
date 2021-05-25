package com.dwu.alonealong.dao.mybatis;

import com.dwu.alonealong.dao.PaymentDAO;
import com.dwu.alonealong.dao.mybatis.mapper.PaymentMapper;
import com.dwu.alonealong.domain.Payment;

public class MybatisPaymentDAO implements PaymentDAO {

	private PaymentMapper paymentMapper;

	@Override
	public Payment getCard(String Id) {
		// TODO Auto-generated method stub
		return paymentMapper.getCard(Id);
	}

	@Override
	public void createCard(Payment payment) {
		// TODO Auto-generated method stub
		paymentMapper.createCard(payment);
	}

	@Override
	public void updateCard(Payment payment) {
		// TODO Auto-generated method stub
		paymentMapper.updateCard(payment);
	}

}