package com.aios.technicaltest.utils;

public interface ApiUrl {
    
    String BASE_PATH = "/api";

    /** order api **/
    String ORDER = BASE_PATH + "/order";

    /** recipient api **/
    String RECIPIENT = BASE_PATH + "/recipient";
    
    /** item by id **/
    String BY_ID = "/{id}";
    
}
