package com.bfhl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class BfhlResponse {
    @JsonProperty("is_success") private boolean isSuccess;
    @JsonProperty("user_id") private String userId;
    @JsonProperty("email") private String email;
    @JsonProperty("roll_number") private String rollNumber;
    @JsonProperty("odd_numbers") private List<String> oddNumbers;
    @JsonProperty("even_numbers") private List<String> evenNumbers;
    @JsonProperty("alphabets") private List<String> alphabets;
    @JsonProperty("special_characters") private List<String> specialCharacters;
    @JsonProperty("sum") private String sum;
    @JsonProperty("concat_string") private String concatString;

    public boolean isSuccess() { return isSuccess; }
    public void setSuccess(boolean v) { this.isSuccess = v; }
    public String getUserId() { return userId; }
    public void setUserId(String v) { this.userId = v; }
    public String getEmail() { return email; }
    public void setEmail(String v) { this.email = v; }
    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String v) { this.rollNumber = v; }
    public List<String> getOddNumbers() { return oddNumbers; }
    public void setOddNumbers(List<String> v) { this.oddNumbers = v; }
    public List<String> getEvenNumbers() { return evenNumbers; }
    public void setEvenNumbers(List<String> v) { this.evenNumbers = v; }
    public List<String> getAlphabets() { return alphabets; }
    public void setAlphabets(List<String> v) { this.alphabets = v; }
    public List<String> getSpecialCharacters() { return specialCharacters; }
    public void setSpecialCharacters(List<String> v) { this.specialCharacters = v; }
    public String getSum() { return sum; }
    public void setSum(String v) { this.sum = v; }
    public String getConcatString() { return concatString; }
    public void setConcatString(String v) { this.concatString = v; }
}
