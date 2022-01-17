package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest {
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";

	@Test
	public void providedCSVCensusFile_WhenCorrectNumberOFRecords_ShouldReturnCorrectRecords(){
		CSVStateCensus censusAnalyser = new CSVStateCensus();
		int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
		Assert.assertEquals(29, numOfRecords);
	}
}
