package com.wladblank.forexport.forexport.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;

import lombok.Data;

@Data
public class TechnicalResponse {

@JacksonXmlCData
 List<String> wrap = new ArrayList<>();


// @JacksonXmlElementWrapper(useWrapping = false)
// //@JacksonXmlProperty(localName = "div")
// List<Object> div = new ArrayList<>();
//
// @JacksonXmlProperty(localName = "table")
// private String table;
//
// @JacksonXmlProperty(localName = "h3")
// private String h3;
// 
// @JacksonXmlProperty(localName = "thead")
// private String thead;
//
// @JacksonXmlProperty(localName = "tbody")
// private String tbody;
//
// @JacksonXmlProperty(localName = "class")
// private String classweird;
//
// @JacksonXmlProperty(localName = "id")
// private String id;
//
//public Object getDiv() {
//	return div;
//}

}
