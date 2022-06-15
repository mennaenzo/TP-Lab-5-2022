package com.lab5.tp2022.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketballLiveMatchesList {
    private List<BasketballLiveMatch> matches;
}
