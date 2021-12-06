package com.nowicka.dominika.dziennik;

public enum StudentCondition {
    OBECNY{
        @Override
        public String toString() {
            return "OBECNY";
        }
        },
    ODRABIAJACY{
        @Override
        public String toString() {
            return "ODRABIAJACY";
        }
    },
    CHORY{
        @Override
        public String toString() {
            return "CHORY";
        }
    },
    NIEOBECNY{
        @Override
        public String toString() {
            return "NIEOBECNY";
        }
    }
}