package com.linkedin.collections.interfaces;

public class Application {
    public static void main(String[] args) {
        Contract contract = new Implementation();
        printTerms(contract);
    }
    public static void printTerms(Contract contract ){
        contract.term1();
        contract.term2();
        contract.extendedTerm();

    }
}
