package com.bridgelabz;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVStateCensus {
	private int numberOfEnteries;

	public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
			Reader reader = null;
			try {
				reader = Files.newBufferedReader(Paths.get(csvFilePath));
			
				CsvToBeanBuilder<StatesCensusAnalyser> csvToBeanBuilder = new CsvToBeanBuilder<StatesCensusAnalyser>(reader);
				csvToBeanBuilder.withType(StatesCensusAnalyser.class);
				csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
				CsvToBean<StatesCensusAnalyser> csvToBean = csvToBeanBuilder.build();
				Iterator<StatesCensusAnalyser> CsvCensusIterator = csvToBean.iterator();
				
				
				while(CsvCensusIterator.hasNext()) {
					numberOfEnteries++;
					StatesCensusAnalyser censusData = CsvCensusIterator.next();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return numberOfEnteries;
			
    }
}