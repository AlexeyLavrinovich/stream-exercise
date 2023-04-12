package com.lavrinovich;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private String name;
    private int point;
    private Status status;
}