package com.biomanuel97.akuretechexpo;

import java.util.ArrayList;

public class DataManager {
    private static final DataManager ourInstance = new DataManager();
    private static String[] dayOneRawProgrammeItemString = {
            "8.30am – 9.00am: REGISTRATION: Register at the Front Desk",
            "9.00am – 9.10am: ANTHEM: The Nigerian National Anthem",
            "9.10am – 9.30am: Welcome Address: Convener, Akure Tech Expo",
            "9.30am – 10.00am: SPEAKER ONE: Mr. Olumbe Akinkugbe (SSA ICT to the Governor of Ondo State)\n- Technology in driving business and economic growth.",
            "10.00am – 10.15am: Question & Answer: This Period is for you to ask bordering questions from the Speaker",
            "10.15am – 1.00pm: Training Session.: You will be Directed to your Training group",
            "1.00pm – 1.30pm: Launch & Exhibition: You can also use this period to do a little bit of Networking",
            "1.30pm – 4.00pm: Training Session: Training Session continues",
            "4.00pm – 5.00pm: Exhibition & Networking.: Meet People and Create productive connection with them."};

    private static String[] dayTwoRawProgrammeItemString = {
            "8.30am – 9.00am: REGISTRATION: Register at the Front Desk",
            "9.00am – 9.10am: ANTHEM: The Nigerian National Anthem",
            "9.10am – 9.30am: Welcome Address : Convener, Akure Tech Expo",
            "9.30am – 10.00am: LECTURE ONE: Speaker Mrs. Betty Anyanwu-Akeredolu (First Lady of Ondo State) \n- Keynote Address",
            "10.00am – 10.15am: Questions & Answers: This Period is for you to ask bordering questions from the Speaker",
            "10.15am – 10.50am: SPONSOR SPEAKS : Sponsor  CUSTOM MADE NIGERIA LIMITED",
            "10.50am – 11.20am: LECTURE TWO: Speaker Professor Kayode Alese (Professor of Information and Cyber Security FUTA) \n- Cyber Security Awareness for Businesses.",
            "11.20am – 11.30am: Questions & Answers: This Period is for you to ask bordering questions from the Speaker",
            "11.35am – 12.05am: SPONSOR SPEAKS: Sponsor SHOKENNY SOLUTIONS LIMITED",
            "12.10am – 12.40am: LUNCH AND EXHIBITION: You can also use this period to do a little bit of Networking",
            "12.45am – 1.00pm: SPONSOR SPEAKS : Sponsor ADNAIRA",
            "1.00pm – 1.30pm: LECTURE THREE : Speaker Mr. Oluyemi Medahunsi (Obeam Technologies) \n- The Role of A.I in Business",
            "1.30pm – 1.40pm: Questions & Answers: This Period is for you to ask bordering questions from the Speaker",
            "1.45pm – 2.15pm: SPONSOR SPEAKS : Sponsor ANKARA SOFTWARE LAB",
            "2.20pm – 2.50pm: LECTURE FOUR: Speaker Mr. Wale Oseni (State Controller DPR Ondo State)",
            "2.50pm – 3.00pm: Questions & Answers: This Period is for you to ask bordering questions from the Speaker",
            "3.00pm – 3.30pm: PITCH SESSION: Award of Cheque to Pitch Winners",
            "3.30pm – 4.00pm: LECTURE FIVE: Speaker Mr. Olufemi Akinyomi (Tech Speaker, Host of Talk Tech Empire Radio) \n- Technology in Business",
            "4.00pm – 4.10pm: Questions & Answers: This Period is for you to ask bordering questions from the Speaker",
            "4.10pm – 4.15pm: Vote of thanks (Conference Manager)",
            "4.20pm – 5.00pm: Exhibition/Link ups/ Networking."
    };
    private static ArrayList<ProgrammeItem> mDayOneProgrammeItems = new ArrayList<>();
    private static ArrayList<ProgrammeItem> mDayTwoProgrammeItems = new ArrayList<>();

    public static DataManager getInstance() {
        if (mDayOneProgrammeItems.isEmpty() && mDayTwoProgrammeItems.isEmpty()) {
            generateSamples();
        }
        return ourInstance;
    }

    private DataManager() {
    }

    private static void generateSamples() {
        for (String row : dayOneRawProgrammeItemString) {
            mDayOneProgrammeItems.add(new ProgrammeItem(row));
        }
        for (String row : dayTwoRawProgrammeItemString) {
            mDayTwoProgrammeItems.add(new ProgrammeItem(row));
        }
    }

    public ArrayList<ProgrammeItem> getProgrammeItems(int day) {
        if (day == 1) return mDayOneProgrammeItems;
        else if (day == 2) return mDayTwoProgrammeItems;
        else return new ArrayList<ProgrammeItem>();
    }
}
