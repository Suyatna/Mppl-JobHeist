package com.pejuangif.mppljobheist.apihelper;

public class UtilsApi {

    public static final String BASE_URL_API = "https://mpplsample-api.herokuapp.com/";

    public static BaseApiService getApiService() {
        return RetrofilClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
