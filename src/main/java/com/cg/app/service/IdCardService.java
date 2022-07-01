package com.cg.app.service;

import com.cg.app.exception.IdCardException;
import com.cg.app.model.IdCard;

public interface IdCardService {
	public IdCard addIdCard (IdCard idcard);
	public IdCard getPanCardByNumber(String panNo)throws IdCardException;
	public IdCard getAdharCardByNo(long adharno)throws IdCardException;
}
