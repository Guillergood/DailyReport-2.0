package com.gbv.dailyreport.services;

import com.gbv.dailyreport.model.Report;

import java.util.List;

public interface ReportService {
    Report add(Report report);
    void delete(Report report);
    Report edit(int id, Report report);
    Report get(int id);
    List<Report> getAll();
}
