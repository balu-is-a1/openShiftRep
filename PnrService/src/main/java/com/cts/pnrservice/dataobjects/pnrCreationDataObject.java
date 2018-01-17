package com.cts.pnrservice.dataobjects;

import java.sql.SQLException;

import com.cts.pnrservice.model.CreatePnrRequest;
import com.cts.pnrservice.model.PassengerInfo;
import com.cts.pnrservice.model.SegmentInfo;

public interface pnrCreationDataObject {
	public String createPnr(CreatePnrRequest createPnr) throws SQLException,Exception;
}
