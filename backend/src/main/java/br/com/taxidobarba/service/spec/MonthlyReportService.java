package br.com.taxidobarba.service.spec;

import br.com.taxidobarba.business.results.monthlyreport.MonthlyReportDTO;

public interface MonthlyReportService {

    public MonthlyReportDTO generate(Integer monthy, Integer year);
    
}
