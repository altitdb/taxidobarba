package br.com.taxidobarba.service;

import br.com.taxidobarba.business.results.monthlyreport.MonthlyReportDTO;

public interface MonthlyReportService {

    public MonthlyReportDTO generate(Integer monthy, Integer year);
    
}
