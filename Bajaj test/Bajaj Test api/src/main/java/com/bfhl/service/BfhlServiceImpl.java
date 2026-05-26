package com.bfhl.service;

import com.bfhl.dto.BfhlRequest;
import com.bfhl.dto.BfhlResponse;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    private static final String USER_ID = "shubhda_agrawal_29112005";
    private static final String EMAIL = "shubhdaagrawal230366@acropolis.in";
    private static final String ROLL = "0827cy231068";

    @Override
    public BfhlResponse process(BfhlRequest req) {
        List<String> odd = new ArrayList<>();
        List<String> even = new ArrayList<>();
        List<String> alpha = new ArrayList<>();
        List<String> special = new ArrayList<>();
        BigInteger sum = BigInteger.ZERO;
        StringBuilder letters = new StringBuilder();

        List<String> data = req.getData() == null ? new ArrayList<>() : req.getData();

        for (String s : data) {
            if (s == null) continue;
            if (s.matches("-?\\d+")) {
                BigInteger n = new BigInteger(s);
                if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) even.add(s);
                else odd.add(s);
                sum = sum.add(n);
            } else if (s.matches("[a-zA-Z]+")) {
                alpha.add(s.toUpperCase());
                letters.append(s);
            } else {
                special.add(s);
                for (char c : s.toCharArray()) {
                    if (Character.isLetter(c)) letters.append(c);
                }
            }
        }

        String reversed = letters.reverse().toString();
        StringBuilder concat = new StringBuilder();
        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            concat.append(i % 2 == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c));
        }

        BfhlResponse res = new BfhlResponse();
        res.setSuccess(true);
        res.setUserId(USER_ID);
        res.setEmail(EMAIL);
        res.setRollNumber(ROLL);
        res.setOddNumbers(odd);
        res.setEvenNumbers(even);
        res.setAlphabets(alpha);
        res.setSpecialCharacters(special);
        res.setSum(sum.toString());
        res.setConcatString(concat.toString());
        return res;
    }
}
