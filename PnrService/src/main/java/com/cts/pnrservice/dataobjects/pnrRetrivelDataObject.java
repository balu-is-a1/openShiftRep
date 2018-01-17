package com.cts.pnrservice.dataobjects;

import java.sql.SQLException;

import com.cts.pnrservice.model.PassengerInfo;
import com.cts.pnrservice.model.SegmentInfo;

public interface pnrRetrivelDataObject {
	public SegmentInfo retrievePnrDetails(String pnrNum) throws SQLException,Exception;
	public PassengerInfo retrievePassengerDetails(String pnrNum) throws SQLException,Exception;
}
