package com.gbv.dailyreport.service.impl;

import com.gbv.dailyreport.model.Report;
import com.gbv.dailyreport.repositories.ReportRepository;
import com.gbv.dailyreport.services.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public void add(Report report) {
        reportRepository.save(report);
    }

    public void edit(int id, Report report) {
        Report sourceReport = reportRepository.getOne(id);
        reportRepository.delete(sourceReport);
        reportRepository.save(report);

    }

    public Report get(int id) {

        if(reportRepository.existsById(id)){
            return reportRepository.getOne(id);
        }
        else{
            throw new IndexOutOfBoundsException();
        }

    }

    public List<Report> getAll() {
        return reportRepository.findAll();
    }


    public void delete(Report report) {
        reportRepository.delete(report);
    }
}
