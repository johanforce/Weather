package com.example.weather;

public interface OnMainCallback {
    void showFrg(String sourceTag,String tag, boolean isMoveBack);

    void showFrg(String sourceTag, String tag, String city, boolean isMoveBack);

    void showFrg(String sourceTag, String tag, Object data, boolean isMoveBack);

    void closeApp();
}
