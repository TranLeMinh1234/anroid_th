package com.example.thuchanh1;

public class ParamFilterQuery {
    public String fieldName;
    public Object valueField;
    public String typeFilter;


    public ParamFilterQuery(String fieldName, Object valueField, String typeFilter)
    {
        this.fieldName = fieldName;
        this.valueField = valueField;
        this.typeFilter = typeFilter;
    }
}
