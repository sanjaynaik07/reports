package com.dorman.bitest.pages;
import java.util.ArrayList;
import java.util.List;
public class ReportProperties {

	private String _reportName;

    private String _sheetName;

    private Integer[] _primary_keys;





    public ReportProperties(String ReportName, String sheetName, Integer[] _pKeys) {

                    this.set_reportName(ReportName);

                    this.set_sheetName(sheetName);

                    this._primary_keys = _pKeys;

    }



    public String get_reportName() {

                    return _reportName;

    }



    public void set_reportName(String _reportName) {

                    this._reportName = _reportName;

    }



    public String get_sheetName() {

                    return _sheetName;

    }



    public void set_sheetName(String _sheetName) {

                    this._sheetName = _sheetName;

    }



    public Integer[] get_primary_keys() {

                    return _primary_keys;

    }



    public void set_primary_keys(Integer[] _primary_keys) {

                    this._primary_keys = _primary_keys;

    }
	

	
}
