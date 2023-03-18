package com.btmstudio;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.util.Map;

public class APIResponce {
    private boolean success;
    private long timestamp;
    private boolean historical;
    private String base;
    private LocalDate date;
    private Map<String, String> rates;

    @JsonProperty("success")
    public boolean getSuccess() { return success; }
    @JsonProperty("success")
    public void setSuccess(boolean value) { this.success = value; }

    @JsonProperty("timestamp")
    public long getTimestamp() { return timestamp; }
    @JsonProperty("timestamp")
    public void setTimestamp(long value) { this.timestamp = value; }

    @JsonProperty("historical")
    public boolean getHistorical() { return historical; }
    @JsonProperty("historical")
    public void setHistorical(boolean value) { this.historical = value; }

    @JsonProperty("base")
    public String getBase() { return base; }
    @JsonProperty("base")
    public void setBase(String value) { this.base = value; }

    @JsonProperty("date")
    public LocalDate getDate() { return date; }
    @JsonProperty("date")
    public void setDate(LocalDate value) { this.date = value; }

    @JsonProperty("rates")
    public Map<String, String> getRates() { return rates; }
    @JsonProperty("rates")
    public void setRates(Map<String, String> value) { this.rates = value; }
}
