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

    @Override
    public Report add(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public Report edit(int id, Report report) {
        Report sourceReport = reportRepository.getOne(id);
        reportRepository.delete(sourceReport);
        reportRepository.save(report);
        return report;

    }

    @Override
    public Report get(int id) {

        if(reportRepository.existsById(id)){
            return reportRepository.getOne(id);
        }
        else{
            throw new IndexOutOfBoundsException();
        }

    }

    @Override
    public List<Report> getAll() {
        return reportRepository.findAll();
    }


    @Override
    public void delete(Report report) {
        reportRepository.delete(report);
    }
}
