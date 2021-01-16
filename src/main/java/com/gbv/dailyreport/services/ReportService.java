package com.gbv.dailyreport.services;

import com.gbv.dailyreport.model.Report;

import java.util.List;

public interface ReportService {
    void add(Report report);
    void delete(Report report);
    void edit(int id, Report report);
    Report get(int id);
    List<Report> getAll();
}