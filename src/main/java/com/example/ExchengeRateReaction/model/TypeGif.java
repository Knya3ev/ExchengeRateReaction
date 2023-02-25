package com.example.ExchengeRateReaction.model;

public enum TypeGif {
    rich, broke;

    public static TypeGif getType(int t){
        return t >= 0 ? rich : broke;
    }
}