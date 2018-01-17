package com.cts.pnrservice.service;

import java.sql.SQLException;

import com.cts.pnrservice.dataobjects.pnrRetrivelDataObjectImpl;
import com.cts.pnrservice.model.PassengerInfo;
import com.cts.pnrservice.model.SegmentInfo;

public class PnrRetrivelServiceImpl implements PnrRetrivelService {

	@Override
	public SegmentInfo retrievePnrDetails(String pnrNum) throws SQLException, Exception {
		
		return new pnrRetrivelDataObjectImpl().retrievePnrDetails(pnrNum);
	}

	@Override
	public PassengerInfo retrievePassengerDetails(String pnrNum) throws SQLException, Exception {
		
		return new pnrRetrivelDataObjectImpl().retrievePassengerDetails(pnrNum);
	}
	
}
