package com.ninageek.dto;

public class StringCheckerResponseDto {
    private boolean isFirstStringPalindrome;
    private boolean isSecondStringPalindrome;
    private boolean permutationCheck;
    private boolean traverseCheck;

    public StringCheckerResponseDto() {
    }

    public boolean isFirstStringPalindrome() {

        return isFirstStringPalindrome;
    }

    public void setFirstStringPalindrome(boolean firstStringPalindrome) {
        isFirstStringPalindrome = firstStringPalindrome;
    }

    public boolean isSecondStringPalindrome() {
        return isSecondStringPalindrome;
    }

    public void setSecondStringPalindrome(boolean secondStringPalindrome) {
        isSecondStringPalindrome = secondStringPalindrome;
    }

    public boolean isPermutationCheck() {
        return permutationCheck;
    }

    public void setPermutationCheck(boolean permutationCheck) {
        this.permutationCheck = permutationCheck;
    }

    public boolean isTraverseCheck() {
        return traverseCheck;
    }

    public void setTraverseCheck(boolean traverseCheck) {
        this.traverseCheck = traverseCheck;
    }
}
