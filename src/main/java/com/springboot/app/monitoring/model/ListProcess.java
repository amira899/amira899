package com.springboot.app.monitoring.model;

import org.slf4j.LoggerFactory;
import com.google.gson.Gson;


public class ListProcess {

private int id;
private String nodeName;
private String processId;
private int difference;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNodeName() {
	return nodeName;
}
public void setNodeName(String nodeName) {
	this.nodeName = nodeName;
}
public String getProcessId() {
	return processId;
}
public void setProcessId(String processId) {
	this.processId = processId;
}
public int getDifference() {
	return difference;
}
public void setDifference(int difference) {
	this.difference = difference;
}
@Override
public String toString() {
	return "ListProcess [id=" + id + ", nodeName=" + nodeName + ", processId=" + processId + ", difference="
			+ difference + "]";
}

public String convertUsingGson(ListProcess e){
	org.slf4j.Logger logger = LoggerFactory.getLogger(ListProcess.class);
    Gson gson = new Gson();
    String listProcessJson = gson.toJson(e);
   System.out.println("listeProcess json : " +listProcessJson);
    return listProcessJson;
}
}